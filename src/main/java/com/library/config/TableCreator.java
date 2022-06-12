package com.library.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private TableCreator() {
    }

    public static void createTables() {
        String createTableAddress = "create table if not exists Address(" +
                "id int not null auto_increment," +
                "    country varchar(255)," +
                "    postalCode varchar(255)," +
                "    street varchar(255)," +
                "    details  varchar(255)," +
                "    primary key (id)" +
                ")";
        String createTableAuthor = "create table if not exists Author(" +
                "id int not null auto_increment," +
                "    firstName varchar(255)," +
                "    lastName varchar(255)," +
                "    primary key (id)" +
                ")";
        String createTableStaff = "create table if not exists Staff(" +
                "id int not null auto_increment," +
                "    firstName varchar(255)," +
                "    lastName varchar(255)," +
                "    phone varchar(255)," +
                "    salary double," +
                "    hireDate date," +
                "    primary key (id)" +
                ")";
        String createTableLibrarian = "create table if not exists Librarian(" +
                "id int not null auto_increment," +
                "    firstName varchar(255)," +
                "    lastName varchar(255)," +
                "    phone varchar(255)," +
                "    salary double," +
                "    hireDate date," +
                "    experience varchar(255)," +
                "    primary key (id)" +
                ")";


        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableAuthor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableStaff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableLibrarian);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
