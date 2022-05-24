package com.library;

import com.library.config.DatabaseConfiguration;
import com.library.config.TableCreator;
import com.library.entities.Address;
import com.library.entities.Author;
import com.library.entities.Staff;
import com.library.repository.AddressRepository;
import com.library.repository.AuthorRepository;
import com.library.services.*;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

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
        System.out.println(librarianService.getAllLibrarians()); //display all librarians

        addressService.addAddress(new Address(2, "Romania", "041946", "Victoriei nr 5", "Bloc A5 ap.24"));
        authorService.addAuthor(new Author(1,"Ion","Creanga"));
        staffService.updateStaff(new Staff(1, "Maria", "Hristache", "0741386051", 1000.1, LocalDate.parse("2012-01-08"))); //updates staff member with id 1

        System.out.println(addressService.getAllAdresses());  //display all addresses
        System.out.println(staffService.getAllStaff());       //display all staff
        System.out.println(authorService.getAllAuthors());    //display all authors
        //If it doesn't already exist, a new Audit.csv file will be generated at "src/main/java/com/library/Database"

        TableCreator.createTables();
        System.out.println(AuthorRepository.getAllAuthors());   //returns a list of all authors retrieved from database or an empty list if there are none
        System.out.println(AuthorRepository.getAuthorById(1));  //returns the author with the given id retrieved from dababase or null if the id doesn't exist
        AddressRepository.addAddress(new Address(0,"Romania","012345","Strada Soarelui nr.5","-")); //id doesn't matter here because it gets auto generated
        AddressRepository.updateAddress(new Address(2,"Bulgaria","123456","Strada Soarelui nr.6","Bloc A5"));

        System.out.println(AddressRepository.getAllAddresses()); //display all addresses
        DatabaseConfiguration.closeDatabaseConnection();

    }
}
