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
	
	public PayPanel() {
		
		String sql = "SELECT * FROM Menu";
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
		
		setBounds(0, 800, 884, 200);
		setLayout(null);
		

		JLabel price = new JLabel("�� �ֹ� ���� : " );
		price.setFont(new Font("�ü�ü", Font.PLAIN,40));
		price.setBounds(500,20,400,80);
		add(price);
		
		String[] payMenu = {"ó������", "�ֹ�����", "����"};

		for(int i = 0; i <payMenu.length; ++i) {
			
			JButton btn4 = new JButton(payMenu[i]);
			btn4.setFont(new Font("�ü�ü", Font.PLAIN,40));
			btn4.setBounds(40+(100*(i*3)), 100, 200, 80);
			btn4.setBackground(new Color(0xFFFFFF));
			add(btn4);
		}
		
	
	}
	
}
