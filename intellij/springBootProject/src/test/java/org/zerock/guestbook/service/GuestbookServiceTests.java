package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(302L)
                .title("Sample Title.....")
                .content("Sample Content.....")
                .writer("user0")
                .build();
        System.out.println(service.register(dto));
    }

    @Test
    public void testList() {
        PageRequestDTO requestDTO = PageRequestDTO.builder()
                .page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(requestDTO);

        System.out.println("PREV" + resultDTO.isPrev());
        System.out.println("NEXT" + resultDTO.isNext());
        System.out.println("TOTAL" + resultDTO.getTotalPage());

        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearch() {
        PageRequestDTO dtp = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("한글")
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(dtp);

        System.out.println("PREV" + resultDTO.isPrev());
        System.out.println("NEXT" + resultDTO.isNext());
        System.out.println("TOTAL" + resultDTO.getTotalPage());

        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
