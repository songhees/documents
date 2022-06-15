package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.domain.Board;
import org.zerock.board.domain.Member;
import org.zerock.board.domain.Reply;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository repository;

    @Test
    public void insertReplys() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Long bno = (long)(Math.random() * 100) + 1;

            Board board = Board.builder()
                    .bno(bno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply...." + i)
                    .board(board)
                    .replyer("guest")
                    .build();
            repository.save(reply);
        });
    }

    @Test
    public void testListByBoard() {
        List<Reply> replyList = repository.getRepliesByBoardOrderByRno(Board.builder()
                .bno(97L).build());
        replyList.forEach(reply -> {
            System.out.println(reply);
        });
    }
}
