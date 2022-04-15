package com.library.entities;

import com.library.abstracts.Person;

import java.time.LocalDate;

public class Staff extends Person {
    private double salary;
    private LocalDate hireDate;

    public Staff(int id, String firstName, String lastName, String phone, double salary, LocalDate hireDate) {
        super(id,firstName,lastName,phone);
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Staff() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", salary=" + getSalary() +
                ", hireDate=" + getHireDate() +
                '}';
    }
}
