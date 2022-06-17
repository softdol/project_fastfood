package database.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;
import database.model.PsList;

public class ReturnModel {
	
	/**
	 * ���� �α��� üũ(���� ���� ����)
	 * @param sql
	 * @param psList
	 * @return Member
	 */	
	public static Member selMember(String sql, ArrayList<PsList> psList) {		
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
				if(rs.next()) {
					return new Member(rs);
				}else {
					return null;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}		
			
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ī�װ� ����Ʈ �ҷ�����
	 * @param sql
	 * @param psList
	 * @return ArrayList<Catagory>
	 */
	public static ArrayList<Category> catagoryList(String sql){
		ArrayList<Category> cateList = new ArrayList<>();
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					cateList.add(new Category(rs));					
				}				
				return cateList;
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
