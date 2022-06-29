package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;

public class OrderIndex {
	
	static ArrayList <Integer> orderlist;
	
	public static ArrayList<Integer> getOrderlist() {
    
	    
		return orderlist;
		
	}
	  
	public static int main(String[] args) {
		
		String sql = "SELECT ORDER_IDX FROM ORDER_LIST";
		
		orderlist = new ArrayList<>();
		int lastorder = 0;
		

		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				) {
			
			while (rs.next()) {
				if (rs.next()) {
					orderlist.add(rs.getInt("ORDER_IDX"));
					
					for(int i = 0; i < orderlist.size(); i++) {
						System.out.println(lastorder);
						lastorder = i;
						
						
					}
				} else {
					orderlist.add(1);
					
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastorder;
		
	}

}
