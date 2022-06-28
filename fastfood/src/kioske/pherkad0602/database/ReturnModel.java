package kioske.pherkad0602.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import database.OjdbcConnection;
import database.manager.Category;
import database.manager.Menu;
import database.model.PsList;
import kioske.pherkad0602.database.SubMenuDatabase;

public class ReturnModel {
	
	/**
	 * 직원 로그인 체크(직원 정보 리턴)
	 * @param sql
	 * @param psList
	 * @return Member
	 */	
	
	public static ArrayList<SubMenuDatabase> selSubCateList(String sql, ArrayList<PsList> psList) {
		ArrayList<SubMenuDatabase> menuList = new ArrayList<>();
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
					menuList.add(new SubMenuDatabase(rs));					
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
	
	public static ArrayList<MenuDatabase> selMenuList1(String sql, ArrayList<PsList> psList) {
		ArrayList<MenuDatabase> menuList = new ArrayList<>();
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
					menuList.add(new MenuDatabase(rs));					
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
	
	public static ArrayList<Category> categoryList(){
		ArrayList<Category> cateList = new ArrayList<>();
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement("select * from menu_category");
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
	
	public static ArrayList<MenuDatabase> menuList(String sql){
		ArrayList<MenuDatabase> menuList = new ArrayList<>();
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					menuList.add(new MenuDatabase(rs));					
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
	
	public static ArrayList<SubMenuDatabase> subCateList(String sql){
		ArrayList<SubMenuDatabase> subCateList = new ArrayList<>();
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql);
			){
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					subCateList.add(new SubMenuDatabase(rs));					
				}				
				return subCateList;
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
