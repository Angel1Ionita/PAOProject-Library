package com.library.Services;

import com.library.Entities.Librarian;
import com.library.Enums.Experience;

import static com.library.Database.librarians;

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

    public void promoteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id) {
                if (l.getExperience() == Experience.STARTER)
                    l.setExperience(Experience.INTERMEDIATE);
                else
                    l.setExperience(Experience.EXPERIENCED);
            }
    }

    public void demoteLibrarian(int id) {
        for (int i = 0; i < librarians.size(); i++)
            if (librarians.get(i).getId() == id) {
                if (librarians.get(i).getExperience() == Experience.EXPERIENCED)
                    librarians.get(i).setExperience(Experience.INTERMEDIATE);
                else
                    librarians.get(i).setExperience(Experience.STARTER);
            }
    }

    @Override
    public void deleteLibrarian(int id) {
        for (Librarian l : librarians)
            if (l.getId() == id)
                librarians.remove(l);

    }
}
