package com.mobileapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelDAO {
	static Connection connection;
	public static final String URL ="jdbc:mysql://localhost:3306/training";
	public static final String USERNAME ="root";
	public static final String PASSWORD ="Sambika@123";
	public static Connection openConnection() {
		try {
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
