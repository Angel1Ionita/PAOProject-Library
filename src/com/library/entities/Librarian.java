package com.library.entities;

import com.library.enums.Experience;

import java.time.LocalDate;

public class Librarian extends Staff {
    private Experience experience;
    private double salaryBonus; //depends on experience

    public Librarian(int id, String firstName, String lastName, String phone, double salary, LocalDate hireDate, Experience experience) {
        super(id, firstName, lastName, phone, salary, hireDate);
        this.experience = experience;
    }

    public Librarian() {
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public double getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(double salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", salary=" + super.getSalary() +
                ", hireDate=" + super.getHireDate() +
                ", experience=" + getExperience() +
                ", salaryBonus=" + getSalaryBonus() +
                '}';
    }


}
