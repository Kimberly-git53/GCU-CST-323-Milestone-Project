// Define the package where this repository belongs
package com.comicbooks.library.repositories;

// Import JpaRepository so we can use built-in database methods (CRUD)
import org.springframework.data.jpa.repository.JpaRepository;

// Import the ComicBook model from the CORRECT updated package
import com.comicbooks.library.models.ComicBook;

// Create an interface that extends JpaRepository
// <ComicBook, Long> means:
// - ComicBook = the entity (table)
// - Long = the type of the primary key (ID)
public interface ComicBookRepository extends JpaRepository<ComicBook, Long> {

    // No code needed here!
    // JpaRepository already provides:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
}