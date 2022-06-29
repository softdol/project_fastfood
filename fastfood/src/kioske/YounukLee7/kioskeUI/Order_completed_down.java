package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Order_completed_down extends JPanel{
	
	public Order_completed_down() {
		
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
		
		int order_num = 1;
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
