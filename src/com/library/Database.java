package com.library;

import com.library.entities.*;
import com.library.io.Read;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //Simulating a Database using ArrayLists/CSV Files
    public static List<Book> books=new ArrayList<>();
    public static List<Member> members=new ArrayList<>();
    public static List<Publisher> publishers=new ArrayList<>();
    public static List<Request> requests=new ArrayList<>();
    public static List<Address> addresses;
    public static List<Author> authors;
    public static List<Librarian> librarians;
    public static List<Staff> staff;
    static {
        try {
            addresses = Read.read(Address.class, Read.addressesReader);
            authors = Read.read(Author.class, Read.authorsReader);
            librarians = Read.read(Librarian.class, Read.librariansReader);
            staff = Read.read(Staff.class, Read.staffReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
