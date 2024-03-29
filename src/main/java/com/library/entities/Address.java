package com.library.entities;

public class Address {
    private int id;
    private String country;
    private String postalCode;
    private String street;
    private String details;

    public Address(int id, String country, String postalCode, String street, String details) {
        this.id = id;
        this.country = country;
        this.postalCode = postalCode;
        this.street = street;
        this.details = details;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + getId() +
                ", country='" + getCountry() + '\'' +
                ", postalCode='" + getPostalCode() + '\'' +
                ", street='" + getStreet() + '\'' +
                ", details='" + getDetails() + '\'' +
                '}';
    }
}
