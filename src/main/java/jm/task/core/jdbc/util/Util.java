package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    static final String URL = "jdbc:mysql://localhost:3306/SchemaOne?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "root1234";

    private Connection connection;

    public Connection getConnection() throws SQLException {
       if (connection == null || connection.isClosed()) {
           Driver driver = new com.mysql.cj.jdbc.Driver();
           DriverManager.registerDriver(driver);
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           connection.setAutoCommit(false);
       }
       return connection;
    }

}
