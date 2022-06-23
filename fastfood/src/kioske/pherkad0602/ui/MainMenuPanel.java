package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainMenuPanel extends JPanel{
	
	public Component MainMenuPanel() {
		
		LayoutManager manager = new GridLayout(4,3);
		
		JPanel menuPanel = new JPanel();
		
		menuPanel.setLayout(manager);
		
		JScrollPane scrollPane = new JScrollPane(menuPanel);
		scrollPane.setBounds(0, 200, 684, 600);
		Dimension size = new Dimension();
				size.setSize(600,800);
		menuPanel.setPreferredSize(size);
		
		for(int i = 0; i <12; ++i) {
			
			JButton btn3 = new JButton("¸Þ´º");
			btn3.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
			btn3.setBackground(new Color(0xFFFFFF));
			menuPanel.add(btn3);
		}
		
		
		return scrollPane;
	}
	
	
}
