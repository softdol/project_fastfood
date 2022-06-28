package kioske.pherkad0602.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kioske.pherkad0602.ui.ojdbcConnection;

public class SubMenuDatabase {
	
	
	static ArrayList subMenuName = new ArrayList<>();
	static ArrayList subMenuIdxNum = new ArrayList<>();
	static ArrayList menuCategoryIdx = new ArrayList<>();

	
	public static void Database(String sql) {
	
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				subMenuIdxNum.add(rs.getInt(1));
				subMenuName.add(rs.getString(2));
				menuCategoryIdx.add(rs.getInt(3));

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
	
	public static ArrayList menuCategoryIdxArray(String sql) {
		Database(sql);
		return menuCategoryIdx;
	}
	
}