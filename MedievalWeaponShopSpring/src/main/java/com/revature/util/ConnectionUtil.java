package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {
	private Properties dbProps = new Properties();

	public ConnectionUtil() {
		try {
			dbProps.load(new FileInputStream("src/main/resources/database.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("username"),
				dbProps.getProperty("password"));
	}
}
