package com.crudoperation.cruapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	static Connection con;

	public static Connection createDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employeedb";
			String username = "root";
			String password = "Gopal@123";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

}
