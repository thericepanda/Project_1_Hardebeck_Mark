package com.TRMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	private static final String url = "jdbc:oracle:thin:@markymarksdatabase.c1heybotdkrw.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String user = "TRS";
	private static final String password = "p4ssw0rd";

	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return conn;
	}
}
