package com.library.repository;

import com.library.config.DatabaseConfiguration;
import com.library.entities.Staff;
import com.library.io.Audit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository {
    private StaffRepository() {
    }
    public static List<Staff> getAllStaff() {
        Audit.logFunctionCall("sql_getAllStaff");
        String selectSql = "SELECT * FROM staff";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            List<Staff> staff = new ArrayList<>();
            while (resultSet.next()) {
                staff.add(mapToStaff(resultSet));
            }
            return staff;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Staff getStaffById(int id) {
        Audit.logFunctionCall("sql_getStaffById");
        String selectSql = "SELECT * FROM staff WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToStaff(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Staff mapToStaff(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Staff(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getDate(6).toLocalDate()
            );
        }
        return null;
    }
}
