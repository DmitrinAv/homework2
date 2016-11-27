package ru.innopolis.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 022 22.11.16.
 */
public class ConnectionFactory {

    private static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String JDBC_LOGIN = "postgres";
    private static final String JDBC_PASSWORD = "111111";

    public static Connection getSqlConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Драйвер не найден!");
        }

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
