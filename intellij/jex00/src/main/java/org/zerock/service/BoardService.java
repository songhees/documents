package org.zerock.service;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

public interface BoardService {

//    public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public List<BoardAttachVO> getAttachList(Long bno);

    public boolean remove(Long bno);

    public boolean modify(BoardVO board);

    public int getTotal(Criteria cri);

}
