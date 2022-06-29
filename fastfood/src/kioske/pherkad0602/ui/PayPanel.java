package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class PayPanel extends JPanel {
	public JLabel price;
	
	public void view_menu(String name) {
		String a = name;
	}
	
	public PayPanel() {
		String sql = "SELECT * FROM Menu";
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
		
		setBounds(0, 800, 884, 200);
		setLayout(null);
		
		JLabel priceName = new JLabel("총 주문 가격 : " );
		priceName.setFont(new Font("궁서체", Font.PLAIN,40));
		priceName.setBounds(200,20,300,80);		
		add(priceName);
		
		price = new JLabel("");
		price.setFont(new Font("궁서체", Font.PLAIN,40));
		price.setBounds(600,20,200,80);		
		add(price);
		
		String[] payMenu = {"처음으로", "주문내역", "도움"};

		for(int i = 0; i <payMenu.length; ++i) {
			
			JButton btn4 = new JButton(payMenu[i]);
			btn4.setFont(new Font("궁서체", Font.PLAIN,40));
			btn4.setBounds(40+(100*(i*3)), 100, 200, 80);
			btn4.setBackground(new Color(0xFFFFFF));
			add(btn4);
		}
		
	
	}

	
	
}
