package com.library.services;

import com.library.io.Audit;
import com.library.io.Write;
import com.library.entities.Author;

import static com.library.Database.authors;

public class AuthorService implements IAuthorService {
    private static AuthorService instance = null;

    private AuthorService() {
    }

    @Override
    public String getAllAuthors() {
        Audit.logFunctionCall("getAllAuthors");
        return authors.toString();
    }

    @Override
    public String getAuthorById(int id) {
        for (Author a : authors)
            if (a.getId() == id)
                return a.toString();
        Audit.logFunctionCall("getAuthorById");
        return "No author found with the given id";

    }

    @Override
    public void addAuthor(Author a) {
        authors.add(a);
        Write.toCSVFile(authors,Author.class,Write.authorsWriter);
        Audit.logFunctionCall("addAuthor");
    }

    @Override
    public void deleteAuthor(int id) {
        for (Author a : authors) {
            if (a.getId() == id) {
                authors.remove(a);
                break;
            }
        }
        Write.toCSVFile(authors,Author.class,Write.authorsWriter);
        Audit.logFunctionCall("deleteAuthor");

    }

    public static AuthorService getInstance() {
        {
            if (instance == null)
                instance = new AuthorService();

            return instance;
        }
    }
}
