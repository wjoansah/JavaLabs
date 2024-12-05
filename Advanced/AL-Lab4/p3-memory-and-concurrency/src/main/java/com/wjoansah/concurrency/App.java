package com.wjoansah.concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        ObjectPool<Connection> connectionPool = new ObjectPool<Connection>(3, () -> {
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password123");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        Runnable task = () -> {
            try {
                Connection connection = connectionPool.borrowObject();
                System.out.println(Thread.currentThread().getName() + " using connection " + connection);
                Thread.sleep(1000);
                connectionPool.returnObject(connection);
                System.out.println(Thread.currentThread().getName() + " returned connection " + connection);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}
