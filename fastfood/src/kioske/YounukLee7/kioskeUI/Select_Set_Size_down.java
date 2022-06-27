package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Select_Side_Drink;

public class Select_Set_Size_down extends JPanel{
	
	public Select_Set_Size_down() {
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,740);
		setLayout(null);
		
		JLabel label = new JLabel("<html><body style='text-align:center;'>700원 추가하시면 사이드와 음료가"
				+ "<br />라지사이즈로 변경됩니다."
				+ "<p>업그레이드 하시겠습니까?</body></html>");
		label.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		label.setBounds(210, 0, 500,200);
		
		JLabel image_label = new JLabel();
		image_label.setBounds(260, 170, 360, 260);
		image_label.setIcon(new ImageIcon("image/set1.jpg"));
		
		JButton no_button = new JButton("아니오");
		no_button.setForeground(new Color(0xFFFFFF));
		no_button.setBackground(new Color(0x000000));
		no_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		no_button.setBounds(173, 450, 250, 60);
		
		JButton yes_button = new JButton("예");
		yes_button.setForeground(new Color(0xFFFFFF));
		yes_button.setBackground(new Color(0xFF0000));
		yes_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		yes_button.setBounds(463, 450, 250, 60);
		
		yes_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Select_Side_Drink();
			}
		});
		
		add(no_button);
		add(yes_button);
		add(label);
		add(image_label);
		
	}

}
