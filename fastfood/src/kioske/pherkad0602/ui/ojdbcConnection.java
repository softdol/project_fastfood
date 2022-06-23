package kioske.pherkad0602.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ojdbcConnection {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@3.39.84.37:1521:XE";
	private static String user = "fastfood";
	private static String password = "fastfood!@";
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("driver Name Error :" + driverName);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
}
