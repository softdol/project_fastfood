package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OrderCheck extends JFrame{
	
	public OrderCheck() {
		
		JFrame checkFrame = new JFrame();
		checkFrame.setLayout(null);
		
		JLabel label = new JLabel("장바구니에 추가하시겠습니까?");
		label.setBounds(65,10,200,50);
		checkFrame.add(label);
		
		JButton btn1 = new JButton("네");
		btn1.setBounds(30,90,100,50);
		checkFrame.add(btn1);
		
		JButton btn2 = new JButton("아니오");
		btn2.setBounds(155,90,100,50);
		checkFrame.add(btn2);
		
		
		checkFrame.setSize(300, 200);
		checkFrame.setLocationRelativeTo(null);
		checkFrame.setBackground(Color.white);
		checkFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		checkFrame.setVisible(true);
		checkFrame.setResizable(false);
	

	}

	public static void main(String[] args) {
		new OrderCheck();
	}
	
}
