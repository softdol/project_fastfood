package kioske.pherkad0602.ui;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

public class test {
	public static void main(String[] args) {
	
		
		LayoutManager manager = new GridLayout(4, 3);
		
		String sql = "SELECT * FROM Menu";
		
		ArrayList menuImage = new ArrayList<>();
		ArrayList menuName = new ArrayList<>();
		
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				menuImage.add(rs.getString(3));
				menuName.add(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
