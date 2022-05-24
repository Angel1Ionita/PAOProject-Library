package com.library;

import com.library.entities.*;
import com.library.enums.Experience;
import com.library.services.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Initializing services
        IAddressService addressService = AddressService.getInstance();
        IAuthorService authorService = AuthorService.getInstance();
        IBookService bookService = BookService.getInstance();
        ILibrarianService librarianService = LibrarianService.getInstance();
        IMemberService memberService = MemberService.getInstance();
        IPublisherService publisherService = PublisherService.getInstance();
        IRequestService requestService = RequestService.getInstance();
        IStaffService staffService = StaffService.getInstance();

        //Calls to services

        librarianService.updateAllSalaryBonuses();
        System.out.println(Database.librarians.toString());
        System.out.println("Librarian 1 before promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        librarianService.promoteLibrarian(1);
        System.out.println("Librarian 1 after promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        System.out.println("List of librarians:");
        System.out.println(librarianService.getAllLibrarians());

        addressService.addAddress(new Address(2, "Romania", "041946", "Victoriei nr 5", "Bloc A5 ap.24"));
        authorService.addAuthor(new Author(1,"Ion","Creanga"));
        staffService.updateStaff(new Staff(1, "Maria", "Hristache", "0741386051", 1000.1, LocalDate.parse("2012-01-08"))); //updates staff member with id 1

        System.out.println(addressService.getAllAdresses());  //display all addresses
        System.out.println(staffService.getAllStaff());       //display all staff
        System.out.println(authorService.getAllAuthors());    //display all authors
        //If it doesn't already exist, a new Audit.csv file will be generated at "src/com/library/Database"

    }
}
