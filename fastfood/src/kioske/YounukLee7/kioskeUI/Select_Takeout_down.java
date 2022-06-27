package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Takeout_down extends JPanel{

	public Select_Takeout_down() {
		
		JButton storeOrder_button = new JButton("매장 식사 H");
		JButton takeout_button = new JButton("포장 주문 T");
		JLabel select_label = new JLabel("선택해주세요");
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,740);
		setLayout(null);
		
		select_label.setFont(new Font("HY견고딕", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		storeOrder_button.setBounds(173, 200, 250, 350);
		takeout_button.setBounds(463, 200, 250, 350);
		
		storeOrder_button.setIcon(new ImageIcon("image/8.first.jpg"));
		takeout_button.setIcon(new ImageIcon("image/8.second.jpg"));
		
		
		storeOrder_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
			}  
		});
		
		takeout_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
			}  
		});
		
		add(select_label);
		add(storeOrder_button);
		add(takeout_button);
		
	}
}
