package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class OrderCheck extends JFrame{
	
	public OrderCheck() {
		
		JFrame checkFrame = new JFrame();
		checkFrame.setLayout(null);
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);


		
		JLabel label = new JLabel("��ٱ��Ͽ� �߰��Ͻðڽ��ϱ�?");
		label.setBounds(60,10,300,50);
		label.setFont(new Font("�ü�ü", Font.BOLD,20));
		checkFrame.add(label);
		
		JButton btn1 = new JButton("��");
		btn1.setBounds(35,80,130,50);
		btn1.setFont(new Font("�ü�ü", Font.BOLD,20));
		btn1.setBackground(new Color(240,240,240));
		btn1.setBorder(border);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkFrame.dispose();
			}
		});
		checkFrame.add(btn1);
		
		JButton btn2 = new JButton("�ƴϿ�");
		btn2.setBounds(220,80,130,50);
		btn2.setFont(new Font("�ü�ü", Font.BOLD,20));
		btn2.setBackground(new Color(240,240,240));
		btn2.setBorder(border);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkFrame.dispose();
			}
		});
		checkFrame.add(btn2);
		
		
		checkFrame.setSize(400, 200);
		checkFrame.setLocationRelativeTo(null);
		checkFrame.getContentPane().setBackground(Color.white);
		checkFrame.setVisible(true);
		checkFrame.setResizable(false);
	

	}

	public static void main(String[] args) {
		new OrderCheck();
	}
	
}
