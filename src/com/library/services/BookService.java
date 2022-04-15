package com.library.services;

import com.library.entities.Book;

import java.util.Comparator;

import static com.library.Database.books;


public class BookService implements IBookService {
    @Override
    public String getAllBooks() {
        return books.toString();
    }

    @Override
    public String getBookByIsbn(long isbn) {
        for (Book b : books) {
            if (b.getIsbn() == isbn)
                return b.toString();
        }
        return "No book found with the given isbn";
    }

    @Override
    public void addBook(Book b) {
        books.add(b);

    }

    @Override
    public void deleteBook(long isbn) {
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                books.remove(b);
                break;
            }
        }
    }

    @Override
    public String getBookNamesAlphabetically() {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < books.size() - 1; i++) {
            str.append(books.get(i).getTitle());
            str.append(", ");
        }
        str.append(books.get(books.size() - 1).getTitle());
        str.append("]");
        return str.toString();
    }
}
