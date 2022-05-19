package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.domain.MemberVO;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class MemberMapperTests {

    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private SampleDAO dao;

    @Test
    public void testMapper() {
        MemberVO vo = mapper.read("admin90");
        log.info(vo);
        vo.getAuthList().forEach(authVO -> log.info(authVO));
    }

    @Test
    public void testDao() throws SQLException, ClassNotFoundException {
        dao.getMe();
    }
}
