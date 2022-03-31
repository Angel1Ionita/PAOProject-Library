package com.library;

import com.library.Entities.*;
import com.library.Enums.Experience;
import com.library.Services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Initializing services
        IAddressService addressService = new AddressService();
        IAuthorService authorService = new AuthorService();
        IBookService bookService = new BookService();
        ICategoryService categoryService = new CategoryService();
        ILibrarianService librarianService = new LibrarianService();
        IMemberService memberService = new MemberService();
        IPublisherService publisherService = new PublisherService();
        IRequestService requestService = new RequestService();
        IStaffService staffService = new StaffService();

        //Calls to services
        List<Author> la1 = new ArrayList<>();
        la1.add(new Author(1, "Ion", "Creanga"));
        la1.add(new Author(2, "Mihai", "Eminescu"));
        Book b1 = new Book(2392894, "History", LocalDate.parse("2019-11-12"), la1, null);
        Book b2 = new Book(2392893, "Art", LocalDate.parse("2010-10-12"), null, null);
        bookService.addBook(b1);
        bookService.addBook(b2);
        System.out.println(bookService.getAllBooks());
        System.out.println(bookService.getBookNamesAlphabetically());

        Member m1 = new Member(1, "Marian", "Andrei", "0724297491", "myemail@email.com", null);
        requestService.addRequest(new Request(5, m1, null, null, null));
        System.out.println(requestService.getRequestById(5));

        bookService.deleteBook(2392894);
        System.out.println(bookService.getAllBooks());

        Librarian l1 = new Librarian(1, "Maria", "Andreescu", "0731394051", 1065.6, LocalDate.parse("2010-08-11"), Experience.INTERMEDIATE);
        librarianService.addLibrarian(l1);
        System.out.println(librarianService.getLibrarianById(1));
        librarianService.promoteLibrarian(1);
        System.out.println(librarianService.getLibrarianById(1));
        System.out.println(librarianService.getAllLibrarians());
    }
}
