package org.song.springwebsocket.repository;

import org.song.springwebsocket.domain.FileVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRepository extends JpaRepository<FileVO, Long> {

}
