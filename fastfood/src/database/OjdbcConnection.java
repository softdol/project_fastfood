package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OjdbcConnection {
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@3.39.84.37:1521:XE";
	private static String user = "fastfood";
	private static String password = "fastfood!@";
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("dirver Name Error : " + driverName);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * ArrayList ÀÌ¿כ DB insert
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static boolean insert(String sql, ArrayList<PsInsert> psList) {	
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			for(int i = 0; i < psList.size(); i++) {
				PsInsert ps = psList.get(i); 
				switch(ps.getType()) {
					case 'i': case 'I':
						pstmt.setInt(i + 1, Integer.parseInt(ps.getVal()));
						break;
					case 's': case 'S':
						pstmt.setString(i + 1, ps.getVal());
						break;
					case 'd': case 'D':
						//java.sql.Date.valueOf(LocalDate.now())
						pstmt.setDate(i + 1, java.sql.Date.valueOf(ps.getVal()));
						break;
					default:
						pstmt.setString(i + 1, ps.getVal());
						break;				
				}
			}
			
			return pstmt.executeUpdate() > 0;
						
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
