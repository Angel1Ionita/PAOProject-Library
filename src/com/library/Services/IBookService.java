package com.library.Services;

import com.library.Entities.Book;

public interface IBookService {
    String getAllBooks();

    String getBookByIsbn(long isbn);

    void addBook(Book b);

    void deleteBook(long isbn);

    String getBookNamesAlphabetically();
}
