package com.library.repository;

import com.library.config.DatabaseConfiguration;
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
            if(resultSet.next())
                return mapToAuthor(resultSet);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAuthor(Author author) {
        Audit.logFunctionCall("sql_addAuthor");
        String insertSql = "INSERT INTO author(firstName, lastName) VALUES(?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Author mapToAuthor(ResultSet resultSet) throws SQLException {
        return new Author(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3));
    }
}
