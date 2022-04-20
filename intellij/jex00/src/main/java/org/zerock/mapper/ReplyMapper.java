package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyVO vo);

    /**
     * 댓글 조회
     * @param rno 댓글 번호
     * @return 댓글 정보
     */
    public ReplyVO read(Long rno);

    /**
     * 댓글 삭제
     * @param rno 댓글 번호
     * @return
     */
    public int delete(Long rno);

    /**
     * 댓글 수정
     * @param vo 댓글 정보
     * @return
     */
    public int update(ReplyVO vo);

    /**
     * 페이징 처리된 댓글 목록 조회
     * @param cri 검색조건
     * @param bno 글 번호
     * @return 댓글 목록
     */
    public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
