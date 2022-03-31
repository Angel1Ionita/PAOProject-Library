package com.library.Services;

import com.library.Entities.Author;

import static com.library.Database.authors;

public class AuthorService implements IAuthorService {
    @Override
    public String getAllAuthors() {
        return authors.toString();
    }

    @Override
    public String getAuthorById(int id) {
        for (Author a : authors)
            if (a.getId() == id)
                return a.toString();
        return "No author found with the given id";
    }

    @Override
    public void addAuthor(Author a) {
        authors.add(a);

    }

    @Override
    public void deleteAuthor(int id) {
        for (Author a : authors) {
            if (a.getId() == id) {
                authors.remove(a);
                break;
            }
        }

    }
}
