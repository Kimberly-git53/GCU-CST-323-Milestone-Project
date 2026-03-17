package com.comicbooks.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.comicbooks.models.ComicBook;
import com.comicbooks.repositories.ComicBookRepository;

@Service
public class ComicBookService {

    private final ComicBookRepository comicBookRepository;

    public ComicBookService(ComicBookRepository comicBookRepository) {
        this.comicBookRepository = comicBookRepository;
    }

    public List<ComicBook> getAllComicBooks() {
        return comicBookRepository.findAll();
    }

    public ComicBook getComicBookById(Long id) {
        return comicBookRepository.findById(id).orElse(null);
    }

    public ComicBook saveComicBook(ComicBook comicBook) {
        return comicBookRepository.save(comicBook);
    }

    public void deleteComicBook(Long id) {
        comicBookRepository.deleteById(id);
    }

}
