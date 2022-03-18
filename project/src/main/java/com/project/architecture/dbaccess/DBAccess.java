package com.project.architecture.dbaccess;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBAccess {
	private static Connection conn;
	
	public static synchronized Connection getConnection() throws ClassNotFoundException, IOException, SQLException{
		try {
			ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
			InputStream input=classLoader.getResourceAsStream("properties/config.properties");
			
			Properties p=new Properties();
			p.load(input);
			
			Class.forName(p.getProperty("jdbcDriver"));
			conn=DriverManager.getConnection(
					p.getProperty("jdbcURL"),
					p.getProperty("jdbcUsername"),
					p.getProperty("jdbcPassword"));
			conn.setAutoCommit(false);	
		} catch (SQLException sql) {
			throw sql;
		}
		return conn;
	}
	
	public static void closeConnection() throws SQLException  {
		try {
			if(conn!=null)
			conn.close();
		}catch(SQLException sql) {
			throw sql;
		}
	}
}