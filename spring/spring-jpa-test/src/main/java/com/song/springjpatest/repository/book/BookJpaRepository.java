package com.song.springjpatest.repository.book;

import com.song.springjpatest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long>, BookRepository {

}
