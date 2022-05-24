package com.library.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pao";
    private static final String USER = "admin";
    private static final String PASSWORD = "shadowfight2001";
    private static Connection databaseConnection;

    private DatabaseConfiguration() {
    }

    public static Connection getDatabaseConnection() {
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database! Make sure the credentials are correct");
            System.out.println("These are the current credentials:");
            System.out.println("Database URL: "+DatabaseConfiguration.DB_URL);
            System.out.println("User: "+DatabaseConfiguration.USER);
            System.out.println("Password: "+DatabaseConfiguration.PASSWORD);
            System.exit(1);

        }
        return databaseConnection;
    }

    public static void closeDatabaseConnection() {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}