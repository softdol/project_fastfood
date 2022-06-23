package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HomePanel extends JPanel{

	public Component HomePanel() {
		LayoutManager manager = new GridLayout(4, 3);
		
		JPanel mainPanel = new JPanel();
		
		
		mainPanel.setBounds(200, 0, 684, 1200);
		mainPanel.setLayout(null);

		
		for(int i = 0; i <3; ++i) {
			
			JButton btn2 = new JButton("이벤트 배너");
			btn2.setBounds(0, i*150, 670, 150);
			btn2.setBackground(Color.white);
			mainPanel.add(btn2);
		}
		

		JPanel menuPanel = new JPanel();
		mainPanel.add(menuPanel);
		menuPanel.setBounds(0, 450, 670, 800);
		menuPanel.setLayout(manager);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(200, 0, 684, 800);
		Dimension size = new Dimension();
				size.setSize(600,1250);
		mainPanel.setPreferredSize(size);
	
	
		for(int i = 0; i <12; ++i) {
			
			JButton btn3 = new JButton("메뉴");
			btn3.setFont(new Font("궁서체", Font.PLAIN,40));
			btn3.setBackground(new Color(0xFFFFFF));
			menuPanel.add(btn3);
		}
		
		return scrollPane;
	}

}
