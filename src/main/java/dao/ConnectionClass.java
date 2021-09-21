package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static Connection getConnection;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33062/otilia" ,"otilia", "otilia");
    }



}
