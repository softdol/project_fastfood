package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Set_down {
	
	public JPanel Select_Set_down() {
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		JLabel select_label = new JLabel("�������ּ���");
		select_label.setFont(new Font("HY�߰���", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		JButton single_button = new JButton("��ǰ");
		single_button.setBounds(173, 200, 250, 350);
		single_button.setIcon(new ImageIcon("image/solo.png"));
		
		JButton set_button = new JButton("��Ʈ");
		set_button.setBounds(463, 200, 250, 350);
		set_button.setIcon(new ImageIcon("image/set.jpg"));
		
		pSouth.add(single_button);
		pSouth.add(set_button);
		pSouth.add(select_label);
		
		return pSouth;
	}

}