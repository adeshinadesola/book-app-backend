package com.mccss.bookapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String edition;
    private int publishedYear;
    private String isbn;
    private int totalPages;
    private double price;
    private String imageUrl; // New field for image URL
    private byte[] pdfData; // New field for PDF data
    private String pdfUrl; // New field for PDF URL

    // Constructors, getters, and setters

    // Default constructor
    public Book() {
        // Default constructor with no arguments
    }
    // Constructor without ID as it is generated automatically
    public Book(String title, String author, String edition, int publishedYear, String isbn, int totalPages, double price, String imageUrl, byte[] pdfData, String pdfUrl) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
        this.totalPages = totalPages;
        this.price = price;
        this.imageUrl = imageUrl;
        this.pdfData = pdfData;
        this.pdfUrl = pdfUrl;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pdfData) {
        this.pdfData = pdfData;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
