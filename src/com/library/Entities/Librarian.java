package com.library.Entities;

import com.library.Enums.Experience;

import java.time.LocalDate;

public class Librarian extends Staff {
    private Experience experience;
    private double salaryBonus; //depends on experience

    public Librarian(int id, String firstName, String lastName, String phone, double salary, LocalDate hireDate, Experience experience) {
        super(id, firstName, lastName, phone, salary, hireDate);
        this.experience = experience;
        switch (experience) {
            case STARTER:
                this.salaryBonus = 0;
                break;
            case INTERMEDIATE:
                this.salaryBonus = 0.33;
                break;
            case EXPERIENCED:
                this.salaryBonus = 0.66;
                break;
        }
    }

    public Librarian() {
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
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
                ", experience=" + experience +
                '}';
    }

    public double getSalaryBonus() {
        return salaryBonus;
    }
}
