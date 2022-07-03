package kioske.YounukLee7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;
import kioske.YounukLee7.dbtablePocket.Dual;
import kioske.YounukLee7.dbtablePocket.EventPage;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.YounukLee7.dbtablePocket.Payment_List;
import kioske.pherkad0602.ui.ojdbcConnection;

public class Insert_List {
	
	Main_JFrame frame;
	Insert_List_Second second;

	public Insert_List(Main_JFrame frame, String payment, int sum) {
		this.frame = frame;

//		String sql = "SELECT PAYMENT_LIST_SEQ.nextval FROM dual";
//
//		Dual dual = null;
//
//		try (
//				Connection conn = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//			) {
//			while (rs.next()) {
//				dual = new Dual(rs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		int payment_idx = Integer.valueOf(dual.getDummy());
		
			String sql1 = "INSERT INTO PAYMENT_LIST " + "VALUES (PAYMENT_LIST_SEQ.nextval,?,'N',?,sysdate)";

			try (
					Connection conn = ojdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql1);
				) {
				conn.setAutoCommit(false);

				pstmt.setString(1, payment);
				pstmt.setInt(2, sum);
				System.out.println("PAYMENET_LIST 추가");
				pstmt.executeUpdate();

				conn.commit();

			} catch (SQLException e) {
				System.out.println("PAYMENT_LIST 추가가 오류났음");
				e.printStackTrace();
			}
			
	
		String sql2 = "select * from PAYMENT_LIST order by payment_idx desc";
		
		ArrayList<Payment_List> payment_List = new ArrayList<>();
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2);
				ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				payment_List.add(new Payment_List(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int payment_idx = payment_List.get(0).getPayment_idx();
		
		second = new Insert_List_Second(frame, payment_idx);
	}
}
