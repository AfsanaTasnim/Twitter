package edu.univdhaka.iit.twitter.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectionPool {

	private static final String DATABASE_NAME = "twitterdatabase";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "PROgramming";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		Connection conn = null;

		try {

			Class.forName(DRIVER_NAME);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(URL + DATABASE_NAME, USER_NAME,
					PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
