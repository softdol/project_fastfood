package kioske.YounukLee7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.OjdbcConnection;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.pherkad0602.ui.ojdbcConnection;

public class Insert_List {
	
	Main_JFrame frame;

	public Insert_List(Main_JFrame frame, String payment) {
		this.frame = frame;
		
		for (int i = 0; i < frame.orderList.size(); i++) {
			Order_list list = frame.orderList.get(i);
		
		String sql = "INSERT INTO PAYMENT_LIST "
				   + "VALUES (PAYMENT_LIST_SEQ.nextval,?,'N',?,sysdate)";
		
		try (
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			conn.setAutoCommit(false);

			
			pstmt.setString(1, payment);
			pstmt.setInt(2, list.getORDER_PRICE_TOTAL());
			System.out.println("PAYMENET_LIST 추가");
			pstmt.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			System.out.println("PAYMENT_LIST 추가가 오류났음");
			e.printStackTrace();
		}
		
		String sql2 = "INSERT INTO ORDER_List "
					+ "VALUES (ORDER_IDX_SEQ.nextval,?,0,?,?,?,null,?,sysdate,?,PAYMENT_LIST_SEQ.currval)";
		
		try (
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2);
		){
			
			conn.setAutoCommit(false);

			pstmt.setInt(1, list.getMENU_IDX());
			pstmt.setInt(2, list.getORDER_PRICE());
			pstmt.setInt(3, list.getORDER_QUANTITY());
			pstmt.setInt(4, list.getORDER_PRICE_TOTAL());
			pstmt.setString(5, list.getMENU_NAME());
			pstmt.setInt(6, list.getSET_IDX());
			
			System.out.println("ORDER_LIST 추가");
			System.out.println(list.getMENU_IDX() +" "+ list.getORDER_PRICE() + " " + list.getORDER_QUANTITY()
			+ " "+ list.getORDER_PRICE_TOTAL() +" " + list.getMENU_NAME() + " " + list.getSET_IDX() );
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			System.out.println("ORDER_List 추가가 오류났음");
			e.printStackTrace();
		}
		}
	}
}
