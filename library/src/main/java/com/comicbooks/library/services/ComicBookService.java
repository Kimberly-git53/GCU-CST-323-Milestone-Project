// Define the package where this service class belongs
package com.comicbooks.library.services;

// Import List so we can return multiple ComicBook objects
import java.util.List;

// Import Spring annotation to mark this class as a service component
import org.springframework.stereotype.Service;

// Import the ComicBook model from the NEW correct package
import com.comicbooks.library.models.ComicBook;

// Import the repository from the NEW correct package
import com.comicbooks.library.repositories.ComicBookRepository;

// Mark this class as a Service so Spring can manage it
@Service
public class ComicBookService {

    // Create a reference to the repository (used to talk to the database)
    private final ComicBookRepository comicBookRepository;

    // Constructor that allows Spring to inject the repository automatically
    public ComicBookService(ComicBookRepository comicBookRepository) {

        // Assign the injected repository to our local variable
        this.comicBookRepository = comicBookRepository;
    }

    // Method to get ALL comic books from the database
    public List<ComicBook> getAllComicBooks() {

        // Call the repository method to retrieve all records
        return comicBookRepository.findAll();
    }

    // Method to get a SINGLE comic book by its ID
    public ComicBook getComicBookById(Long id) {

        // Find the comic book by ID
        // If not found, return null instead of crashing
        return comicBookRepository.findById(id).orElse(null);
    }

    // Method to SAVE a comic book (used for BOTH create and update)
    public ComicBook saveComicBook(ComicBook comicBook) {

        // Save the comic book to the database
        // If it has no ID → creates new record
        // If it has ID → updates existing record
        return comicBookRepository.save(comicBook);
    }

    // Method to DELETE a comic book by ID
    public void deleteComicBook(Long id) {

        // Delete the record from the database using its ID
        comicBookRepository.deleteById(id);
    }
}