package com.library.entities;

import com.library.abstracts.Person;

public class Member extends Person {
    private String email;
    private Address address;

    public Member(int id, String firstName, String lastName, String phone, String email, Address address) {
        super(id,firstName,lastName,phone);
        this.email = email;
        this.address = address;
    }

    public Member() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}
