package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class PayPanel extends JPanel {
	public JLabel price;
	HomeMenuKiosk hMain;
	public void view_menu(String name) {
		String a = name;
	}
	
	public PayPanel(HomeMenuKiosk hMain) {
		this.hMain = hMain;
		String sql = "SELECT * FROM Menu";
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
		
		setBounds(0, 800, 884, 200);
		setLayout(null);
		
		JLabel priceName = new JLabel("ÃÑ ÁÖ¹® °¡°Ý : " );
		priceName.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
		priceName.setBounds(200,20,300,80);		
		add(priceName);
		
		price = new JLabel("");
		price.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
		price.setBounds(600,20,200,80);		
		add(price);
		
		String[] payMenu = {"Ã³À½À¸·Î", "ÁÖ¹®³»¿ª", "µµ¿ò"};

			
		JButton payBtn1 = new JButton(payMenu[0]);
		payBtn1.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
		payBtn1.setBounds(40, 100, 200, 80);
		payBtn1.setBackground(new Color(0xFFFFFF));
		payBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hMain.orderReset();
			}
		});
		add(payBtn1);
		
		JButton payBtn2 = new JButton(payMenu[1]);
		payBtn2.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
		payBtn2.setBounds(340, 100, 200, 80);
		payBtn2.setBackground(new Color(0xFFFFFF));
		payBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(payBtn2);
		
		JButton payBtn3 = new JButton(payMenu[2]);
		payBtn3.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,40));
		payBtn3.setBounds(640, 100, 200, 80);
		payBtn3.setBackground(new Color(0xFFFFFF));
		add(payBtn3);
			
	
	}

	
	
}
