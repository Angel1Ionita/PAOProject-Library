package com.library.io;

import com.library.entities.Address;
import com.library.entities.Author;
import com.library.entities.Librarian;
import com.library.entities.Staff;

import java.io.*;
import java.util.List;


public class Write {
    private static final String mainPath = "src/main/java/com/library/database/";
    public static PrintWriter addressesWriter, authorsWriter, librariansWriter, staffWriter;

    private Write() {
    }

    static {
        try {
            addressesWriter = new PrintWriter(new FileOutputStream(mainPath + "Address.csv"));
            authorsWriter = new PrintWriter(new FileOutputStream(mainPath + "Author.csv"));
            librariansWriter = new PrintWriter(new FileOutputStream(mainPath + "Librarian.csv"));
            staffWriter = new PrintWriter(new FileOutputStream(mainPath + "Staff.csv"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Converts an entity to a CSV line
     */
    public static <T> String toCSVline(T ob, Class<T> cls) {
        if (cls == Address.class)
            return ((Address) ob).getId() + "," +
                    ((Address) ob).getCountry() + "," +
                    ((Address) ob).getPostalCode() + "," +
                    ((Address) ob).getStreet() + "," +
                    ((Address) ob).getDetails();
        else if (cls == Author.class)
            return ((Author) ob).getId() + "," +
                    ((Author) ob).getFirstName() + "," +
                    ((Author) ob).getLastName();
        else if (cls == Librarian.class)
            return ((Librarian) ob).getId() + "," +
                    ((Librarian) ob).getFirstName() + "," +
                    ((Librarian) ob).getLastName() + "," +
                    ((Librarian) ob).getPhone() + "," +
                    ((Librarian) ob).getSalary() + "," +
                    ((Librarian) ob).getHireDate().toString() + "," +
                    ((Librarian) ob).getExperience().name();
        else if (cls == Staff.class)
            return ((Staff) ob).getId() + "," +
                    ((Staff) ob).getFirstName() + "," +
                    ((Staff) ob).getLastName() + "," +
                    ((Staff) ob).getPhone() + "," +
                    ((Staff) ob).getSalary() + "," +
                    ((Staff) ob).getHireDate().toString();
        return null;
    }

    public static <T> void toCSVFile(List<T> list, Class<T> cls, PrintWriter buffer) {
        if (cls == Address.class)
            buffer.println("id,country,postalCode,street,details");
        else if (cls == Author.class)
            buffer.println("id,firstName,lastName");
        else if (cls == Librarian.class)
            buffer.println("id,FirstName,lastName,phone,salary,hireDate,experience");
        else if (cls == Staff.class)
            buffer.println("id,FirstName,lastName,phone,salary,hireDate");
        list.stream().map(elem -> toCSVline(elem, cls)).forEach(buffer::println);
        buffer.flush();
    }
}
