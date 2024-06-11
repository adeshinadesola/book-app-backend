package com.mccss.bookapi.controller;

import com.mccss.bookapi.model.Book;
import com.mccss.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;

    // Custom exception class for not found scenario
    static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    // Get a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get PDF URL for a book
    @GetMapping("/{id}/pdf-url")
    public ResponseEntity<String> getPdfUrl(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent() && book.get().getPdfUrl() != null) {
            return ResponseEntity.ok(book.get().getPdfUrl());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setEdition(bookDetails.getEdition());
            book.setPublishedYear(bookDetails.getPublishedYear());
            book.setIsbn(bookDetails.getIsbn());
            book.setTotalPages(bookDetails.getTotalPages());
            book.setPrice(bookDetails.getPrice());
            book.setImageUrl(bookDetails.getImageUrl());
            book.setPdfUrl(bookDetails.getPdfUrl());
            Book updatedBook = bookService.save(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Search for books based on query
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String query) {
        List<Book> books = bookService.searchBooks(query);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    // Upload a PDF file for a book
    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadPdf(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            // Retrieve the book entity
            Book book = bookService.findById(id)
                    .orElseThrow(() -> new NotFoundException("Book not found"));

            // Validate file format
            if (!file.getContentType().equals("application/pdf")) {
                return ResponseEntity.badRequest().body("Only PDF files are allowed");
            }

            // Save PDF data to book entity
            book.setPdfData(file.getBytes());
            // Set PDF URL
            book.setPdfUrl("/books/" + id + "/download");
            bookService.save(book);

            return ResponseEntity.ok("PDF file uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading PDF file");
        }
    }
        // Download a book
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getPdfData() != null) {
                byte[] pdfData = book.getPdfData();
                String filename = book.getTitle().replaceAll("\\s+", "_") + ".pdf";

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", filename);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(pdfData);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
