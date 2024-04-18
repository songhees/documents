package com.zerock.mallapi.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(config -> config.disable())
                .formLogin((formLogin) -> {
                    formLogin.loginPage("/api/member/login");
                    formLogin.successHandler(null);
                    formLogin.failureHandler(null);
                })
                .build();
    }
}
