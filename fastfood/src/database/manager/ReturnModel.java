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
	 * 직원 로그인 체크(직원 정보 리턴)
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
	 * 카테고리 리스트 불러오기
	 * @param 
	 * @param psList
	 * @return ArrayList<Catagory>
	 */
	public static ArrayList<Category> catagoryList(){
		ArrayList<Category> cateList = new ArrayList<>();
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement("select * from menu_catagory");
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
	
	/**
	 * 메뉴 목록 불러오기
	 * @param sql
	 * @param psList
	 * @return 메뉴 목록
	 */
	public static ArrayList<Menu> selMenuList(String sql, ArrayList<PsList> psList) {
		ArrayList<Menu> menuList = new ArrayList<>();
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

				while(rs.next()) {
					menuList.add(new Menu(rs));					
				}
				
				return menuList;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}		
			
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<MenuSet> selMenuSetList(String sql, ArrayList<PsList> psList) {
		ArrayList<MenuSet> menuList = new ArrayList<>();
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

				while(rs.next()) {
					menuList.add(new MenuSet(rs));					
				}
				
				return menuList;
				
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
