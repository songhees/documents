package org.zerock.mapper;

import org.zerock.domain.BoardAttachVO;

import java.util.List;

public interface BoardAttachVOMapper {

    public void insert(BoardAttachVO vo);

    public void delete(String uuid);

    public List<BoardAttachVO> findByBno(Long bno);

    public void deleteAll(Long bno);

    public List<BoardAttachVO> getOldFiles();
}
