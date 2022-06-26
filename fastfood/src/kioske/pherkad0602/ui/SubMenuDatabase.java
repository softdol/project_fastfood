package kioske.pherkad0602.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubMenuDatabase {
	
	
	static ArrayList subMenuName = new ArrayList<>();
	static ArrayList subMenuIdxNum = new ArrayList<>();

	
	public static void Database(String sql) {
	
		
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				subMenuIdxNum.add(rs.getInt(1));
				subMenuName.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int size (String sql) {
		Database(sql);
		int a = subMenuName.size();
		return a;
	}
	public static ArrayList subMenuNameArray(String sql) {
		Database(sql);
		return subMenuName;
	}
	
	public static ArrayList subMenuIdxNumArray(String sql) {
		Database(sql);
		return subMenuIdxNum;
	}
}