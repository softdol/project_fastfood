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
			
			String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
			String sql2 = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = 1";
			
//			Category cate = new Category();		
//			add(cate);
			
			//MenuPanel menu = new MenuPanel(sql1,sql2);
//			d(menu);
			
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

