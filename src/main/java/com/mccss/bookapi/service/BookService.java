package com.mccss.bookapi.service;

import com.mccss.bookapi.model.Book;
import com.mccss.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks(String query) {
        try {
            int year = Integer.parseInt(query);
            // If the query can be parsed as a year, search by published year
            return bookRepository.searchBooks(query, year, query, query);
        } catch (NumberFormatException e) {
            // If the query cannot be parsed as a year, fall back to searching by other criteria
            return bookRepository.searchBooks(query, null, query, query);
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
