package com.mtgjson.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class MtgDbConn {
	
	private static final String URL = "jdbc:mysql://localhost:3306/new_mtg";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    
    public Connection connectDB() throws SQLException {
    	return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    
}