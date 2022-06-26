package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Side_Drink_down {
	
	public JPanel Select_Side_Drink_down() {
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,740);
		pSouth.setLayout(null);
		
		JLabel burgerlabel = new JLabel("햄버거 사진");
		burgerlabel.setIcon(new ImageIcon("image/solo1.png"));
		burgerlabel.setBounds(100, 150, 200, 170);
		
		JLabel side_label = new JLabel("사이드 사진");
		side_label.setIcon(new ImageIcon("image/side.png"));
		side_label.setBounds(350, 150, 200, 170);
		
		JLabel drink_label = new JLabel("음료 사진");
		drink_label.setIcon(new ImageIcon("image/coke.jpg"));
		drink_label.setBounds(600, 150, 200, 170);
		
		JButton side_button = new JButton("사이드변경");
		side_button.setForeground(new Color(0x000000));
		side_button.setBackground(new Color(0xCCCCCC));
		side_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		side_button.setBounds(375, 330, 150, 50);
		
		JButton drink_button = new JButton("음료변경");
		drink_button.setForeground(new Color(0x000000));
		drink_button.setBackground(new Color(0xCCCCCC));
		drink_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		drink_button.setBounds(625, 330, 150, 50);
		
		JButton cart_button = new JButton("카트 담기");
		cart_button.setForeground(new Color(0xFFFFFF));
		cart_button.setBackground(new Color(0x000000));
		cart_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		cart_button.setBounds(150, 400, 590, 70);
		
		pSouth.add(burgerlabel);
		pSouth.add(side_label);
		pSouth.add(drink_label);
		pSouth.add(side_button);
		pSouth.add(drink_button);
		pSouth.add(cart_button);
		
		return pSouth;
	}

}
