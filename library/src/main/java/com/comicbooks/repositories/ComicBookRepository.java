package com.comicbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comicbooks.models.ComicBook;

public interface ComicBookRepository extends JpaRepository<ComicBook, Long> {
    
}
