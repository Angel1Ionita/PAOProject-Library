package com.library.services;

import com.library.entities.Author;

public interface IAuthorService {
    String getAllAuthors();

    String getAuthorById(int id);

    void addAuthor(Author a);

    void deleteAuthor(int id);
}
