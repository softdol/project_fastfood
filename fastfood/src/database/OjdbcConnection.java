
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.model.PsList;

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
	 * ArrayList �̿� DB insert
	 * @param sql
	 * @param psList(I : number, S: varchar2, D:date)
	 * @return
	 */
	public static boolean insert(String sql, ArrayList<PsList> psList) {	
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			for(int i = 0; i < psList.size(); i++) {
				PsList ps = psList.get(i); 
				switch(ps.getType()) {
					case 'i': case 'I':
						pstmt.setInt(i + 1, Integer.parseInt(ps.getVal()));
						break;
					case 's': case 'S':
						pstmt.setString(i + 1, ps.getVal());
						break;
					case 'd': case 'D':
						Calendar cal = Calendar.getInstance();						
						String[] strDate = ps.getVal().split("-");
						cal.set(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]) - 1, Integer.parseInt(strDate[2]));
						java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());						
						pstmt.setDate(1, sqlDate);
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
	
	/**
	 * ArrayList �̿� DB select
	 * @param sql
	 * @param psList(I : number, S: varchar2, D:date)
	 * @return ResultSet ����Ʈ
	 */	
	public static ArrayList<ResultSet> select(String sql, ArrayList<PsList> psList) {
		
		ArrayList<ResultSet> rsList = new ArrayList<>();
		
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			for(int i = 0; i < psList.size(); i++) {
				PsList ps = psList.get(i); 
				switch(ps.getType()) {
					case 'i': case 'I':
						pstmt.setInt(i + 1, Integer.parseInt(ps.getVal()));
						break;
					case 's': case 'S':
						pstmt.setString(i + 1, ps.getVal());
						break;
					case 'd': case 'D':
						pstmt.setDate(i + 1, java.sql.Date.valueOf(ps.getVal()));
						break;
					default:
						pstmt.setString(i + 1, ps.getVal());
						break;				
				}
			}
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					rsList.add(rs);
				}
			}
			
			return rsList;
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ArrayList �̿� DB selectOne(����)
	 * @param sql
	 * @param psList(I : number, S: varchar2, D:date)
	 * @return ResultSet
	 */	
	public static ResultSet selectOne(String sql, ArrayList<PsList> psList) {		
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			for(int i = 0; i < psList.size(); i++) {
				PsList ps = psList.get(i);
				switch(ps.getType()) {
					case 'i': case 'I':
						pstmt.setInt(i + 1, Integer.parseInt(ps.getVal()));
						break;
					case 's': case 'S':
						pstmt.setString(i + 1, ps.getVal());
						break;
					case 'd': case 'D':
						pstmt.setDate(i + 1, java.sql.Date.valueOf(ps.getVal()));
						break;
					default:
						pstmt.setString(i + 1, ps.getVal());
						break;				
				}
			}
			
			try(ResultSet rs = pstmt.executeQuery()){
				return rs;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}		
			
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
