package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Select_Set_Size;
import kioske.YounukLee7.Sub_JFrame;

public class Select_Set_down extends JPanel{
	
	public Select_Set_down(Sub_JFrame screen) {
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,770);
		setLayout(null);
		
		JLabel select_label = new JLabel("선택해주세요");
		select_label.setFont(new Font("HY견고딕", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		JButton single_button = new JButton("단품");
		single_button.setBounds(173, 200, 250, 350);
		single_button.setIcon(new ImageIcon("image/solo.png"));
		
		single_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton set_button = new JButton("세트");
		set_button.setBounds(463, 200, 250, 350);
		set_button.setIcon(new ImageIcon("image/set.jpg"));
		
		set_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Set_Size();
			}
		});
		
		add(single_button);
		add(set_button);
		add(select_label);
		
	}

}
