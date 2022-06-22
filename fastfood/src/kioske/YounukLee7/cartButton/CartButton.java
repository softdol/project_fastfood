package kioske.YounukLee7.cartButton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartButton {

	public CartButton(JPanel Cpanel , int num) {
		for (int i = 0; i < num; i++) {
			
			JPanel panel = new JPanel(); 
			
			panel.setBounds(0, 150 * i, 900, 150);
			panel.setBackground(new Color(0XFFFFEE));
			// panel.setBorder(new LineBorder(Color.red, i + 2));
			panel.setLayout(null);
			
			JButton cancel = new JButton("Ãë¼Ò");
			cancel.setBounds(10, 50, 100, 50);
			cancel.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			cancel.setBackground(Color.black);
			cancel.setForeground(Color.white);
			
			JLabel menuImg = new JLabel("¸Å´º ÀÌ¹ÌÁö");
			menuImg.setBounds(120, 0, 150, 150);
			menuImg.setIcon(new ImageIcon("image/set2.jpg"));
			menuImg.setText("");
			
			JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å ¼¼Æ® »çÀÌ´Ù °¨ÀÚÆ¢±è",0);
			menuName.setBounds(280, 0, 500, 60);
			menuName.setOpaque(true);
			//menuName.setHorizontalAlignment(JLabel.CENTER);
			menuName.setForeground(Color.black);
			menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			menuName.setBackground(new Color(0XFFFF00));
			
			JButton minus = new JButton("-");
			minus.setBounds(280, 80, 100, 50);
			minus.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			minus.setBackground(Color.black);
			minus.setForeground(Color.white);
			
			JLabel cnt = new JLabel("1");
			cnt.setBounds(380, 80, 100, 50);
			cnt.setOpaque(true);
			cnt.setHorizontalAlignment(JLabel.CENTER);
			cnt.setForeground(Color.black);
			cnt.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			cnt.setBackground(new Color(0XFFFFFF));
			
			JButton plus = new JButton("+");
			plus.setBounds(480, 80, 100, 50);
			plus.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			plus.setBackground(Color.black);
			plus.setForeground(Color.white);
			
			JLabel menuMoney = new JLabel("5500¿ø");
			menuMoney.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			menuMoney.setOpaque(true);
			menuMoney.setForeground(Color.RED);
			menuMoney.setBackground(new Color(0XFFE7DF));
			menuMoney.setBounds(600, 90, 200, 30);
			
			panel.add(cancel);
			panel.add(menuImg);
			panel.add(menuName);
			panel.add(minus);
			panel.add(plus);
			panel.add(cnt);
			panel.add(menuMoney);
			
			Cpanel.add(panel);
			
		}
	}
}
