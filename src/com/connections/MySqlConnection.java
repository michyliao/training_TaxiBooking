package com.connections;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MySqlConnection {
	public static Connection getMyOracleConnection(){
		Connection con = null;
		
		try {
			Properties props = new Properties();
			
			//FileInputStream inStream = new FileInputStream(new File("DBConnection.properties"));
			
			InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("DbConnection.properties"	);
			
			props.load(inStream);
			
			Class.forName(props.getProperty("db.driverClass"));
			
			con = DriverManager.getConnection(props.getProperty("db.driverURL"),
					props.getProperty("db.userName"), 
					props.getProperty("db.password"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void main(String[] args){
		getMyOracleConnection();
	}
}
