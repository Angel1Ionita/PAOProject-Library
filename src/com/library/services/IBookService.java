package com.library.services;

import com.library.entities.Book;

public interface IBookService {
    String getAllBooks();

    String getBookByIsbn(long isbn);

    void addBook(Book b);

    void deleteBook(long isbn);

    String getBookNamesAlphabetically();
}
