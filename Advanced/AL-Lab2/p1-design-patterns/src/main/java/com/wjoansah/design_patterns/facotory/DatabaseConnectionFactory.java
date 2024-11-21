package com.wjoansah.design_patterns.facotory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

enum DatabaseType {
    MYSQL,
    POSTGRESQL
}

public class DatabaseConnectionFactory {

    public static Connection getConnection(DatabaseType dbType, String url, String user, String password) throws SQLException {
        Connection connection = null;

        switch (dbType) {
            case MYSQL:
                connection = createMySQLConnection(url, user, password);
                break;
            case POSTGRESQL:
                connection = createPostgreSQLConnection(url, user, password);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported database type: " + dbType);
        }

        return connection;
    }

    private static Connection createMySQLConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found", e);
        }
    }

    private static Connection createPostgreSQLConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC driver not found", e);
        }
    }
}
