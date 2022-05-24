package com.library.services;

import com.library.io.Audit;
import com.library.io.Write;
import com.library.entities.Librarian;
import com.library.enums.Experience;

import static com.library.Database.librarians;
import static com.library.enums.Experience.*;

public class LibrarianService implements ILibrarianService {
    private static LibrarianService instance = null;

    private LibrarianService() {
    }

    @Override
    public String getAllLibrarians() {
        Audit.logFunctionCall("getAllLibrarians");
        return librarians.toString();
    }

    @Override
    public String getLibrarianById(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id)
                return l.toString();
        Audit.logFunctionCall("getLibrarianById");
        return "No librarians found with the given id";
    }

    @Override
    public void addLibrarian(Librarian l) {
        librarians.add(l);
        Write.toCSVFile(librarians, Librarian.class, Write.librariansWriter);
        Audit.logFunctionCall("addLibrarian");
    }

    @Override
    public void updateLibrarian(Librarian l) {
        for (int i = 0; i < librarians.size(); i++)
            if (librarians.get(i).getId() == l.getId()) {
                librarians.set(i, l);
                break;
            }
        Write.toCSVFile(librarians, Librarian.class, Write.librariansWriter);
        Audit.logFunctionCall("updateLibrarian");
    }

    @Override
    //Should be called first time when creating a new librarian
    //This function is called automatically when promoting or demoting a librarian
    public void updateSalaryBonus(Librarian l) {
        switch (l.getExperience()) {
            case STARTER:
                l.setSalaryBonus(0);
                break;
            case INTERMEDIATE:
                l.setSalaryBonus(0.33);
                break;
            case EXPERIENCED:
                l.setSalaryBonus(0.66);
                break;
        }
    }

    @Override
    public void updateAllSalaryBonuses() {
        for (Librarian l : librarians)
            updateSalaryBonus(l);
    }

    @Override
    public void promoteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id) {
                if (l.getExperience() == STARTER)
                    l.setExperience(Experience.INTERMEDIATE);
                else
                    l.setExperience(Experience.EXPERIENCED);
                updateSalaryBonus(l);
                break;
            }
        Write.toCSVFile(librarians, Librarian.class, Write.librariansWriter);
        Audit.logFunctionCall("promoteLibrarian");

    }

    @Override
    public void demoteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id) {
                if (l.getExperience() == Experience.EXPERIENCED)
                    l.setExperience(Experience.INTERMEDIATE);
                else
                    l.setExperience(STARTER);
                updateSalaryBonus(l);
                break;
            }
        Audit.logFunctionCall("demoteLibrarian");
    }

    @Override
    public void deleteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id) {
                librarians.remove(l);
                break;
            }
        Write.toCSVFile(librarians, Librarian.class, Write.librariansWriter);
        Audit.logFunctionCall("deleteLibrarian");
    }

    public static LibrarianService getInstance() {
        {
            if (instance == null)
                instance = new LibrarianService();

            return instance;
        }
    }
}
