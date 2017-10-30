package com.recruitment.dbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Utility Class that establishes Connection with a Method--> Connection
 * getConnection()
 * 
 * @author User
 *
 */
public class DBConnection {

	private static Logger logger = Logger.getLogger(DBConnection.class);// Logger
																		// object
	private static Connection connection = null;// data member to establish
												// Connection

	public DBConnection() {
		super();
	}
	
	public static Connection getConnection() {

		try {
			if (connection != null) {

				if (!connection.isClosed()) {
					return connection;
				}
			}

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream isrt = loader
					.getResourceAsStream("./com/properties/db.properties");
			Properties properties = new Properties();
			properties.load(isrt);

			String dbHost = properties.getProperty("db.host", "localhost");
			String dbPort = properties.getProperty("db.port", "3306");
			String dbDriver = properties.getProperty("db.driver",
					"com.mysql.jdbc.Driver");
			String dbName = properties.getProperty("db.dbname", "nccourse");
			String dbUser = properties.getProperty("db.user", "root");
			String dbPassword = properties.getProperty("db.password",
					"mahadev@321");
			String dbProtocol = properties.getProperty("db.protocol",
					"jdbc:mysql");

			logger.info(dbDriver);

			Class.forName(dbDriver);

			String connectionString = dbProtocol + "://" + dbHost + ":"
					+ dbPort + "/" + dbName;

			connection = DriverManager.getConnection(connectionString, dbUser,
					dbPassword);

			logger.info(connection);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
}
