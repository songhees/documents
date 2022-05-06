package org.zerock.config;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.zerock.security.CustomAccessDeniedHandler;
import org.zerock.security.CustomLoginSuccessHandler;
import org.zerock.security.CustomNoOpPasswordEncoder;
import org.zerock.security.CustomUserDetailsService;

import javax.sql.DataSource;
import java.sql.ResultSet;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Setter(onMethod_ = @Autowired)
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/customLogout");
        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                        .antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')")
                        .antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')");

        http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login");
                //.successHandler(loginSuccessHandler());
        http.exceptionHandling().accessDeniedHandler(deniedHandler());

        http.logout()
                .logoutUrl("/customLogout")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSION_ID");

        http.rememberMe()
                .key("zerock")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(604800);

        // security 설정 후 인코딩 필터 설정
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler deniedHandler() {return new CustomAccessDeniedHandler();}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {return new CustomUserDetailsService(); }

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure...................");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("member").password("$2a$10$ttRCcOJqbHW2I9FW4YDzGOoN9ursb2P.DzYMtKlBvPYMbjLff1H4u").roles("MEMBER");
    }   */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure jdbc...................");

        String queryUser = "select userid, userpw, enabled from tbl_member where userid = ? ";
        String queryDetail = "select userid, auth from tbl_member_auth where userid = ? ";

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(queryUser)
//                .authoritiesByUsernameQuery(queryDetail);

        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
}
