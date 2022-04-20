package org.zerock.service;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public ReplyVO get(Long rno);

    public int register(ReplyVO vo);

    public int remove(Long rno);

    public int modify(ReplyVO vo);

    public List<ReplyVO> getList(Criteria cri, Long bno);
}
