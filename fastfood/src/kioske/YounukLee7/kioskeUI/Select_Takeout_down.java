package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Main_JFrame;

public class Select_Takeout_down extends JPanel{

	public Select_Takeout_down(Main_JFrame frame) {
		
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
		
		
		storeOrder_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Home("H");
			}
		});
		
		takeout_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Home("T");
			}
		});
		
		add(select_label);
		add(storeOrder_button);
		add(takeout_button);
		
	}
}
