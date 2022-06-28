package database.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import database.OjdbcConnection;
import database.model.PsList;
import kioske.pherkad0602.database.SubMenuDatabase;

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
	 * 직원 목록 불러오기
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static ArrayList<Member> selMemberList(String sql, ArrayList<PsList> psList) {
		ArrayList<Member> memberList = new ArrayList<>();
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
					memberList.add(new Member(rs));					
				}				
				return memberList;				
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
	 * @return ArrayList<Category>
	 */
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
	
	/**
	 * 세트 메뉴 리스트 불러오기
	 * @param sql
	 * @param psList
	 * @return ArrayList<MenuSet>
	 */
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
	
	/**
	 * 세트 메뉴 정보
	 * @param sql
	 * @param psList
	 * @return MenuSet
	 */
	public static MenuSet selMenuSet(String sql, ArrayList<PsList> psList) {		
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
					return new MenuSet(rs);					
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
	 * 메뉴 정보 불러오기
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static Menu selMenu(String sql, ArrayList<PsList> psList) {		
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
					return new Menu(rs);					
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
	 * 매장 정보 불러오기
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static Store selStore(String sql, ArrayList<PsList> psList) {		
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
					return new Store(rs);					
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
	 * 정산 월 매출 정보(일별 오픈/마감/매출)목록
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static ArrayList<Calculate> selCalculateMonth(String sql, ArrayList<PsList> psList) {
		ArrayList<Calculate> calculateList = new ArrayList<>();
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
						cal.set(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]) - 1, 1);
						java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());						
						pstmt.setDate(1, sqlDate);
						break;
					default:
						pstmt.setString(i + 1, ps.getVal());
						break;				
				}
			}
			
			try(ResultSet rs = pstmt.executeQuery()){

				while(rs.next()) {
					calculateList.add(new Calculate(rs));					
				}
				return calculateList;
				
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
	 * 년 매출 정보 목록
	 * @param sql
	 * @param psList
	 * @return
	 */
	public static ArrayList<SaleMonth> selCalculateYear(String sql, ArrayList<PsList> psList) {
		ArrayList<SaleMonth> saleMonthList = new ArrayList<>();
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
						cal.set(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]) - 1, 1);
						java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());						
						pstmt.setDate(1, sqlDate);
						break;
					default:
						pstmt.setString(i + 1, ps.getVal());
						break;				
				}
			}
			
			try(ResultSet rs = pstmt.executeQuery()){

				while(rs.next()) {
					saleMonthList.add(new SaleMonth(rs));					
				}
				return saleMonthList;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}		
			
						
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
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
	
	

}
