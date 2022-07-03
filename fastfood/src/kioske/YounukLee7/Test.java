package kioske.YounukLee7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import kioske.pherkad0602.ui.ojdbcConnection;

public class Test {

	public static void main(String[] args) {
		
		String sql ="INSERT INTO PAYMENT_LIST "
				   + "VALUES (PAYMENT_LIST_SEQ.nextval,?,'N',?,sysdate)";

		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			conn.setAutoCommit(false);

			
			pstmt.setString(1, "P");
			pstmt.setInt(2, 20000);
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

			pstmt.setInt(1, 3);
			pstmt.setInt(2, 5000);
			pstmt.setInt(3, 4);
			pstmt.setInt(4, 20000);
			pstmt.setString(5,"테스트 버거");
			pstmt.setInt(6, 1);
			
			System.out.println("ORDER_LIST 추가");
//			System.out.println(list.getMENU_IDX() +" "+ list.getORDER_PRICE() + " " + list.getORDER_QUANTITY()
//			+ " "+ list.getORDER_PRICE_TOTAL() +" " + list.getMENU_NAME() + " " + list.getSET_IDX() );
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("ORDER_List 추가가 오류났음");
			e.printStackTrace();
		}
	}
}
