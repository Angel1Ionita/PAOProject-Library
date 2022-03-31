package com.library.Services;

import com.library.Entities.Librarian;

public interface ILibrarianService {
    String getAllLibrarians();

    String getLibrarianById(int id);

    void addLibrarian(Librarian l);

    void updateLibrarian(Librarian l);

    void deleteLibrarian(int id);

    void promoteLibrarian(int id);

    void demoteLibrarian(int id);

}
