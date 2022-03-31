package com.library.Services;

import com.library.Entities.Author;

public interface IAuthorService {
    String getAllAuthors();

    String getAuthorById(int id);

    void addAuthor(Author a);

    void deleteAuthor(int id);
}
