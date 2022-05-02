package org.zerock.security;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.config.SecurityConfig;

@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
public class PasswordEncoderTests {

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder encoder;

    @Test
    public void testEncode() {
        String str = "member";
        String enstr = encoder.encode(str);

        log.info(enstr);
    }
}
