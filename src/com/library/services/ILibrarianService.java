package com.library.services;

import com.library.entities.Librarian;

public interface ILibrarianService {
    String getAllLibrarians();

    String getLibrarianById(int id);

    void addLibrarian(Librarian l);

    void updateLibrarian(Librarian l);

    void updateSalaryBonus(Librarian l);

    void updateAllSalaryBonuses();

    void deleteLibrarian(int id);

    void promoteLibrarian(int id);

    void demoteLibrarian(int id);



}
