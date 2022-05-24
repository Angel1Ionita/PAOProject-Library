package com.library.entities;

import java.time.LocalDate;
import java.util.List;

public class Request {
    private int id;
    private Member member;
    private List<Book> books;
    private LocalDate borrowingDate;
    private LocalDate returnDate;

    public Request(int id, Member member, List<Book> books, LocalDate borrowingDate, LocalDate returnDate) {
        this.id = id;
        this.member = member;
        this.books = books;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + getId() +
                ", member=" + getMember() +
                ", books=" + getBooks() +
                ", borrowingDate=" + getBorrowingDate() +
                ", returnDate=" + getReturnDate() +
                '}';
    }
}
