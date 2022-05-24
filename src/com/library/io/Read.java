package com.library.io;

import com.library.entities.*;
import com.library.enums.Experience;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Read {
    private static final String mainPath = "src/com/library/database/";
    public static BufferedReader addressesReader,authorsReader,librariansReader,staffReader;

    static {
        try {
            addressesReader = new BufferedReader(new FileReader(mainPath + "Address.csv"));
            authorsReader = new BufferedReader(new FileReader(mainPath + "Author.csv"));
            librariansReader = new BufferedReader(new FileReader(mainPath + "Librarian.csv"));
            staffReader = new BufferedReader(new FileReader(mainPath + "Staff.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseLine(Class<?> cls, String[] line) {
        if (cls == Address.class)
            return (T) new Address(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4]);
        else if (cls == Author.class)
            return (T) new Author(Integer.parseInt(line[0]), line[1], line[2]);
        else if (cls == Librarian.class)
            return (T) new Librarian(Integer.parseInt(line[0]), line[1], line[2], line[3], Double.parseDouble(line[4]), LocalDate.parse(line[5]), Experience.valueOf(line[6]));
        else if (cls == Staff.class)
            return (T) new Staff(Integer.parseInt(line[0]), line[1], line[2], line[3], Double.parseDouble(line[4]), LocalDate.parse(line[5]));
        return null;
    }
    public static <T> List<T> read(Class<T> tclass,BufferedReader buffer) throws IOException {
        List<T> records = new ArrayList<>();
        String line;
        buffer.readLine();
        while ((line = buffer.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Read.parseLine(tclass, values));
        }
        return records;
    }
}
