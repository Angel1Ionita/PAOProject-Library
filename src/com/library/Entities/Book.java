package com.library.Entities;

import java.time.LocalDate;
import java.util.List;


public class Book {
    private long isbn;
    private String title;
    private LocalDate publicationDate;
    private List<Author> authors;
    private List<Category> categories;

    public Book(long isbn, String title, LocalDate publicationDate, List<Author> authors, List<Category> categories) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.authors = authors;
        this.categories = categories;
    }

    public Book() {
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", authors=" + authors +
                ", categories=" + categories +
                '}';
    }
}
