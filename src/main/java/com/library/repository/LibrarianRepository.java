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
            return mapToLibrarian(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Librarian mapToLibrarian(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Librarian(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getDate(6).toLocalDate(),
                    Experience.valueOf(resultSet.getString(7))
                    );
        }
        return null;
    }
}
