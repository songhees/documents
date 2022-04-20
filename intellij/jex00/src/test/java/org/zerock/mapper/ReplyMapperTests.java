package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class ReplyMapperTests {

    private Long[] bnoArr = {14345L, 14344L, 14343L, 14342L, 14341L};

    @Setter(onMethod_ = @Autowired)
    ReplyMapper mapper;

    @Test
    public void testMapper () {
        log.info(mapper);
    }

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ReplyVO vo = new ReplyVO();

            vo.setBno(bnoArr[i%5]);
            vo.setReply("댓글테스트 " + i);
            vo.setReplyer("replyer" + i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testRead() {
        log.info(mapper.read(5L));
    }

    @Test
    public void testDelete() {
        Long targetRno = 2L;
        mapper.delete(targetRno);
    }

    @Test
    public void testUpdate() {
        Long targetRno = 10L;

        ReplyVO vo = new ReplyVO();
        vo.setRno(targetRno);
        vo.setReply("Update Reply");

        int count = mapper.update(vo);
        log.info("UPDATE COUNT: " + count);
    }

    @Test
    public void testList() {
        Criteria cri = new Criteria();
        List<ReplyVO> list = mapper.getListWithPaging(cri, 14341L);

        list.forEach(reply -> log.info(reply));
    }
}
