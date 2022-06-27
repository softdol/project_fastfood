package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cart_down extends JPanel{

	public Cart_down() {
		int total = 0;
		
		setBackground(new Color(0XFFF2DD));
		setBounds(0,800,900,240);
		setLayout(null);
		
		
		JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
		allpay.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		JLabel allmoney = new JLabel();
		allmoney.setText(String.valueOf(total) + "¿ø");
		allmoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
	
		JButton order_completed_button = new JButton("ÁÖ¹® ¿Ï·á");
		order_completed_button.setForeground(new Color(0xFFFFFF));
		order_completed_button.setBackground(new Color(0XFF0000));
		order_completed_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		order_completed_button.setBounds(450, 100, 380, 80);
		
		JButton more_order_button = new JButton("Ãß°¡ ÁÖ¹®");
		more_order_button.setForeground(new Color(0xFFFFFF));
		more_order_button.setBackground(new Color(0X000000));
		more_order_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		more_order_button.setBounds(40, 100, 380, 80);
		
		add(allpay);
		add(allmoney);
		add(order_completed_button);
		add(more_order_button);
	}
}
