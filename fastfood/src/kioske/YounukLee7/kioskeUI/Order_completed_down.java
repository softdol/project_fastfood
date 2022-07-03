package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.OjdbcConnection;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.dbtablePocket.MenuPicture;
import kioske.YounukLee7.dbtablePocket.Payment_List;

public class Order_completed_down extends JPanel{
	
	Main_JFrame frame;
	
	public Order_completed_down(Main_JFrame frame) {
		this.frame = frame;
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,770);
		setLayout(null);
		
		JLabel word1 = new JLabel("주문이 완료되었습니다!");
		word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setBounds(225, 0, 600,200);
		
		JLabel word2 = new JLabel("주문번호");
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		word2.setOpaque(true);
		word2.setForeground(Color.red);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(380, 150, 300, 30);
		
		String sql = "select * from PAYMENT_LIST order by payment_idx desc";
		//Payment_List list = null;
		ArrayList<Payment_List> list = new ArrayList<>();
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				list.add(new Payment_List(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		int order_num = list.get(0).getPayment_idx();
		JLabel order_number = new JLabel();
		order_number.setText(String.valueOf(order_num));
		order_number.setFont(new Font("HY견고딕", Font.PLAIN, 150));
		order_number.setOpaque(true);
		order_number.setForeground(Color.red);
		order_number.setBackground(new Color(0XFFE7DF));
		order_number.setHorizontalAlignment(JLabel.CENTER);
		order_number.setBounds(130, 200, 600, 150);
		
		JLabel payImage = new JLabel("결제 완료 이미지");
		payImage.setBounds(240, 350,400,230);
		payImage.setIcon(new ImageIcon("image/pay_exit.png"));
		
		add(word1);
		add(word2);
		add(order_number);
		add(payImage);
		
		
	}

}
