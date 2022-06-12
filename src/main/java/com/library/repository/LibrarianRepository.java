package com.library.repository;

import com.library.config.DatabaseConfiguration;
import com.library.entities.Librarian;
import com.library.enums.Experience;
import com.library.io.Audit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianRepository {
    private LibrarianRepository() {
    }
    public static List<Librarian> getAllLibrarians() {
        Audit.logFunctionCall("sql_getAllLibrarians");
        String selectSql = "SELECT * FROM librarian";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<Librarian> librarians = new ArrayList<>();
            while (resultSet.next()) {
                librarians.add(mapToLibrarian(resultSet));
            }
            return librarians;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Librarian getLibrarianById(int id) {
        Audit.logFunctionCall("sql_getLibrarianById");
        String selectSql = "SELECT * FROM librarian WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return mapToLibrarian(resultSet);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void addLibrarian(Librarian librarian) {
        Audit.logFunctionCall("sql_addLibrarian");
        String insertSql = "INSERT INTO librarian(firstName, lastName, phone, salary, hireDate, experience) VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, librarian.getFirstName());
            preparedStatement.setString(2, librarian.getLastName());
            preparedStatement.setString(3, librarian.getPhone());
            preparedStatement.setDouble(4, librarian.getSalary());
            preparedStatement.setDate(5, Date.valueOf(librarian.getHireDate()));
            preparedStatement.setString(6, librarian.getExperience().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Librarian mapToLibrarian(ResultSet resultSet) throws SQLException {
        return new Librarian(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getDouble(5),
                resultSet.getDate(6).toLocalDate(),
                Experience.valueOf(resultSet.getString(7)));

    }
}
