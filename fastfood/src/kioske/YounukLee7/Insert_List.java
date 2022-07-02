package kioske.YounukLee7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.OjdbcConnection;
import kioske.YounukLee7.dbtablePocket.Order_list;

public class Insert_List {
	
	Main_JFrame frame;

	public Insert_List(Main_JFrame frame, String payment) {
		this.frame = frame;
		
		for (int i = 0; i < frame.orderList.size(); i++) {
			Order_list list = frame.orderList.get(i);
		
		String sql = "INSERT INTO PAYMENT_LIST (payment_idx,payment_type,payment_cash_receipts,payment_price,payment_date)\r\n"
				   + "VALUES (PAYMENT_LIST_SEQ.nextval,?,'N',?,sysdate)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, payment);
			pstmt.setInt(2, list.getORDER_PRICE_TOTAL());
		} catch (SQLException e) {
			System.out.println("PAYMENT_LIST 추가가 오류났음");
			e.printStackTrace();
		}
		
		String sql2 = "INSERT INTO ORDER_List (ORDER_IDX,MENU_IDX,ORDER_STATE,ORDER_PRICE,ORDER_QUANTITY,ORDER_PRICE_TOTAL,ORDER_MOD_DATE,MENU_NAME,ORDER_IN_DATE,SET_IDX,PAYMENT_IDX)\r\n"
					+ "VALUES (ORDER_IDX_SEQ.nextval,?,0,?,?,?,null,?,sysdate,?,PAYMENT_LIST_SEQ.currval)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2);
		){
			pstmt.setInt(1, list.getMENU_IDX());
			pstmt.setInt(2, list.getORDER_PRICE());
			pstmt.setInt(3, list.getORDER_QUANTITY());
			pstmt.setInt(4, list.getORDER_PRICE_TOTAL());
			pstmt.setString(5, list.getMENU_NAME());
			pstmt.setInt(6, list.getSET_IDX());
		} catch (SQLException e) {
			System.out.println("ORDER_List 추가가 오류났음");
			e.printStackTrace();
		}
		}
	}
}
