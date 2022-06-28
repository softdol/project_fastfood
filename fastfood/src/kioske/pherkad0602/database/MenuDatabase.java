package kioske.pherkad0602.database;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kioske.pherkad0602.ui.ojdbcConnection;

public class MenuDatabase {
	
	static ArrayList menuImage = new ArrayList<>();
	static ArrayList menuName = new ArrayList<>();
	static ArrayList menuIdxNum = new ArrayList<>();

	
	public static void Database(String sql) {
	
		
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				menuIdxNum.add(rs.getInt(1));
				menuImage.add(rs.getString(3));
				menuName.add(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int size(String sql) {
		Database(sql);
		int a = menuImage.size();
		return a;
	}
	public static ArrayList menuImageArray(String sql) {
		Database(sql);
		return menuImage;
	}
	public static ArrayList menuNameArray(String sql) {
		Database(sql);
		return menuName;
	}
	
	public static ArrayList menuIdxNum(String sql) {
		Database(sql);
		return menuIdxNum;
	}
	
}
