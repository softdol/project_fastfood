package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PayPanel extends JPanel {
	
	public Component PayPanel() {
		
		JPanel payPanel = new JPanel();
		
		payPanel.setBounds(0, 800, 884, 200);
		payPanel.setLayout(null);
		

		JLabel price = new JLabel("총 주문 가격 : ");
		price.setFont(new Font("궁서체", Font.PLAIN,40));
		price.setBounds(500,20,400,80);
		payPanel.add(price);
		
		String[] payMenu = {"처음으로", "주문내역", "도움"};

		for(int i = 0; i <payMenu.length; ++i) {
			
			JButton btn4 = new JButton(payMenu[i]);
			btn4.setFont(new Font("궁서체", Font.PLAIN,40));
			btn4.setBounds(40+(100*(i*3)), 100, 200, 80);
			btn4.setBackground(new Color(0xFFFFFF));
			payPanel.add(btn4);
		}
		
		
		return payPanel;
	}
	
}
