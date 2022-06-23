package kioske.pherkad0602;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.HomePanel;
import kioske.pherkad0602.ui.MenuPanel;
import kioske.pherkad0602.ui.PayPanel;

public class MainMenuKiosk extends JFrame {
	
	public MainMenuKiosk() {
			
			setLayout(null);
			
			
			Category cate = new Category();		
			add(cate.Category());
			
			MenuPanel menu = new MenuPanel();
			add(menu.MenuPanel());
			
			PayPanel pay = new PayPanel();
			add(pay.PayPanel());
		
			
			
			setBounds(510,0,900,1040);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		    setResizable(false);

		}
	
	public static void main(String[] args) {
		
		new MainMenuKiosk();

	}
}

