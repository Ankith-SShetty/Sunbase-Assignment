package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class DbConnection {
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunbase_assignment","root","root");
		}
		catch(Exception e) {
			e.printStackTrace();		}
		return con;
	}
}
