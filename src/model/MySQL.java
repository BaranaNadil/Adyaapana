package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    private static Connection connection;

    private static void createConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/adyapana_db",
                        "root",
                        "barananadil"
                );
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet executeSelect(String query, Object... params) throws SQLException {
        createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        setParameters(preparedStatement, params);
        return preparedStatement.executeQuery();
    }

    public static int executeUpdate(String query, Object... params) throws SQLException {
        createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        setParameters(preparedStatement, params);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return the generated key 
        } else {
//            return 0;
            throw new SQLException("Creating record failed, no ID obtained.");
        }
    }

    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }
}
