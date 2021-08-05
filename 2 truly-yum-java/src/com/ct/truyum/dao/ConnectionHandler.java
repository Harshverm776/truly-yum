package com.ct.truyum.dao;

//import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		/* BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");*/
		
		InputStream bufferedInputStream = (InputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		

		Properties properties = new Properties();
		Connection connection = null;
		try {
			properties.load(bufferedInputStream);
			String driver = properties.getProperty("driver");
			if (driver != null) {
				Class.forName(driver);
			}
			String url = properties.getProperty("connection-url");
			String username = properties.getProperty("user");
			String password = properties.getProperty("password");
			connection = DriverManager.getConnection(url, username, password);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
