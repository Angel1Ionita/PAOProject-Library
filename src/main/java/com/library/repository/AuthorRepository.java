package com.library.repository;

import com.library.config.DatabaseConfiguration;
import com.library.entities.Address;
import com.library.entities.Author;
import com.library.io.Audit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private AuthorRepository() {
    }
    public static List<Author> getAllAuthors() {
        Audit.logFunctionCall("sql_getAllAuthors");
        String selectSql = "SELECT * FROM author";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<Author> authors = new ArrayList<>();
            while (resultSet.next()) {
                authors.add(mapToAuthor(resultSet));
            }
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Author getAuthorById(int id) {
        Audit.logFunctionCall("sql_getAuthorById");
        String selectSql = "SELECT * FROM author WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAuthor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Author mapToAuthor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));//1 int 2 string-uri
        }
        return null;
    }
}
