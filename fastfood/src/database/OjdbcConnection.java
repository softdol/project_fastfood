
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	 * ArrayList 이용 DB insert
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
	
	/**
	 * ArrayList 이용 DB select
	 * @param sql
	 * @param psList(I : number, S: varchar2, D:date)
	 * @return ResultSet 리스트
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
	 * ArrayList 이용 DB selectOne(단일)
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
				if(rs.next()){
					return rs;
				}
			}			
			return null;
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
