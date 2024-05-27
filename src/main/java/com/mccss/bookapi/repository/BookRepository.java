package com.mccss.bookapi.repository;

import com.mccss.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b " +
            "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR b.publishedYear = :year " +
            "OR LOWER(b.edition) LIKE LOWER(CONCAT('%', :edition, '%')) " +
            "OR b.isbn LIKE CONCAT('%', :isbn, '%')")
    List<Book> searchBooks(String keyword, Integer year, String edition, String isbn);
}
