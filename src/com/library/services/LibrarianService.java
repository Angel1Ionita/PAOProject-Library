package com.library.services;

import com.library.entities.Librarian;
import com.library.enums.Experience;

import static com.library.Database.librarians;
import static com.library.enums.Experience.*;

public class LibrarianService implements ILibrarianService {
    @Override
    public String getAllLibrarians() {
        return librarians.toString();
    }

    @Override
    public String getLibrarianById(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id)
                return l.toString();
        return "No librarians found with the given id";
    }

    @Override
    public void addLibrarian(Librarian l) {
        librarians.add(l);
    }

    @Override
    public void updateLibrarian(Librarian l) {
        for (int i = 0; i < librarians.size(); i++)
            if (librarians.get(i).getId() == l.getId())
                librarians.set(i, l);
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
        for(Librarian l:librarians)
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
    }

    @Override
    public void deleteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id)
                librarians.remove(l);

    }
}
