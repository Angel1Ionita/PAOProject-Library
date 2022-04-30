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

        //Create a new Librarian
        Librarian l1 = new Librarian(1, "Maria", "Andreescu", "0731394051", 1065.6, LocalDate.parse("2010-08-11"), Experience.INTERMEDIATE);
        librarianService.updateSalaryBonus(l1);
        librarianService.addLibrarian(l1);
        System.out.println(Database.librarians.toString());

        System.out.println("Librarian l1 before promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        librarianService.promoteLibrarian(1);
        System.out.println("Librarian l1 after promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        System.out.println("List of librarians:");
        System.out.println(librarianService.getAllLibrarians());

        addressService.addAddress(new Address(2, "2", "3", "4", "5"));
        System.out.println(addressService.getAllAdresses());
        //If it doesn't already exist, a new Audit.csv file will be generated at "src/com/library/Database"

        /*
        Note: File IO (except for Audit) is a little bugged right now, not sure what causes the issue.
        Delete the contents of Librarian.csv if issues with running the application appear.
         */


    }
}
