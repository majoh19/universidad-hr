package com.iudigital.universidad.hr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/universidad_hr?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "fenzyk-wojhin-fYsze2";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
