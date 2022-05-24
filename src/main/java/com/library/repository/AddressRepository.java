package com.library.repository;

import com.library.config.DatabaseConfiguration;
import com.library.entities.Address;
import com.library.io.Audit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    private AddressRepository() {
    }

    public static List<Address> getAllAddresses() {
        Audit.logFunctionCall("sql_getAllAddresses");
        String selectSql = "SELECT * FROM address";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()) {
                addresses.add(mapToAddress(resultSet));
            }
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Address getAddressById(int id) {
        Audit.logFunctionCall("sql_getAddressesById");
        String selectSql = "SELECT * FROM address WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAddress(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAddress(Address address) {
        Audit.logFunctionCall("sql_addAddresses");
        String insertSql = "INSERT INTO address(country, postalCode, street, details) VALUES(?, ?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getPostalCode());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getDetails());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAddress(Address address) {
        Audit.logFunctionCall("sql_updateAddress");
        String updateSql = "UPDATE address SET country=?, postalCode=?, street=?, details=? WHERE id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getPostalCode());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getDetails());
            preparedStatement.setInt(5, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAddress(int id) {
        Audit.logFunctionCall("sql_deleteAddress");
        String deleteSql = "DELETE from ADDRESS where id=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Address mapToAddress(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Address(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));//1 int 4 string-uri
        }
        return null;
    }

}
