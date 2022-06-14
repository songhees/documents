package org.zerock.board.service;

import org.zerock.board.domain.Board;
import org.zerock.board.domain.Member;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    
    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);

    void modify(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();

        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return entity;
    }

    default BoardDTO entityToDTO(Board entity, Member member, Long replyCount) {
        BoardDTO dto = BoardDTO.builder()
                .bno(entity.getBno())
                .content(entity.getContent())
                .title(entity.getTitle())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .redDate(entity.getRedDate())
                .modDate(entity.getModDate())
                .replyCount(replyCount.intValue())
                .build();
        return dto;
    }
}
