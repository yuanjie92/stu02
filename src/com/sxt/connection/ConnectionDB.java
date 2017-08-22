package com.sxt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=UTF-8";
	private static final String NAME = "root";
	private static final String PASSWORD = "shsxt";
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private Connection connection;
	
	static{
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try {
			this.connection = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.connection;
	}
	
	public void close(){
		if(this.connection != null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
