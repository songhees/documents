package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;

@SpringBootTest
public class BoardServiceTests {
    @Autowired
    private BoardService service;

    @Test
    public void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = service.register(dto);
    }

    @Test
    public void tesList() {
        PageRequestDTO requestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = service.getList(requestDTO);

        for (BoardDTO dto : result.getDtoList()) {
            System.out.println(dto);
        }
    }

    @Test
    public void testGet() {
        BoardDTO dto = service.get(100L);

        System.out.println(dto);
    }

    @Test
    public void testRemove() {
        Long bno = 4L;
        service.removeWithReplies(bno);
    }

    @Transactional
    @Test
    public void testModify() {
        BoardDTO dto = BoardDTO.builder()
                .bno(2L)
                .title("제목 변경")
                .content("내용 변경")
                .build();

        service.modify(dto);
    }
}
