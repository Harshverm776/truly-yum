package com.ct.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	private static Connection conn = null;
	private static Properties props = new Properties();

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		try {

			FileInputStream input = null;
			input= new FileInputStream("C:/Users/Harsh Verma/Downloads/TruYum-spring-Mvc/TruYum-master/src/main/resources/connection.properties");
			props.load(input);

			Class.forName(props.getProperty("driver"));

			conn = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
					props.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
