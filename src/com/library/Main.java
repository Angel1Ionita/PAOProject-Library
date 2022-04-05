package com.library;

import com.library.entities.*;
import com.library.enums.Experience;
import com.library.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Initializing services
        IAddressService addressService = new AddressService();
        IAuthorService authorService = new AuthorService();
        IBookService bookService = new BookService();
        ILibrarianService librarianService = new LibrarianService();
        IMemberService memberService = new MemberService();
        IPublisherService publisherService = new PublisherService();
        IRequestService requestService = new RequestService();
        IStaffService staffService = new StaffService();

        //Calls to services


        List<Author> la1 = new ArrayList<>();
        la1.add(new Author(1, "Ion", "Creanga"));
        la1.add(new Author(2, "Mihai", "Eminescu"));
        //Create 2 new books and add them in list
        Book b1 = new Book(2392894, "History", LocalDate.parse("2019-11-12"), la1, null);
        Book b2 = new Book(2392893, "Art", LocalDate.parse("2010-10-12"), null, null);
        bookService.addBook(b1);
        bookService.addBook(b2);
        System.out.println("List of books:");
        System.out.println(bookService.getAllBooks()); //Print books in current order
        System.out.println("List of books alphabetically, by title:");
        System.out.println(bookService.getBookNamesAlphabetically()); //Print books after being sorted by their title

        //Add a new request
        Member m1 = new Member(1, "Marian", "Andrei", "0724297491", "myemail@email.com", null);
        requestService.addRequest(new Request(5, m1, null, null, null));
        System.out.println("Request with the id 5:");
        System.out.println(requestService.getRequestById(5)); //Print the request with the given id

        bookService.deleteBook(2392894); //Remove book with the given Isbn from list
        System.out.println(bookService.getAllBooks()); //Print all books

        //Create a new Librarian
        Librarian l1 = new Librarian(1, "Maria", "Andreescu", "0731394051", 1065.6, LocalDate.parse("2010-08-11"), Experience.INTERMEDIATE);
        librarianService.updateSalaryBonus(l1);
        librarianService.addLibrarian(l1);
        System.out.println("Librarian l1 before promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        librarianService.promoteLibrarian(1);
        System.out.println("Librarian l1 after promotion:");
        System.out.println(librarianService.getLibrarianById(1));
        System.out.println("List of librarians:");
        System.out.println(librarianService.getAllLibrarians());
    }
}
