package kioske.YounukLee7.cartButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import kioske.pherkad0602.MainMenuKiosk;

public class CartButton {
	
	int count = 1;
	// 매뉴 가격 (db에서 뽑아 쓰니까 값이 안변하는 값 하나 필요)
	int money = 5000;
	int sub_money = 5000;

	public CartButton(ArrayList<JPanel> arrpanel, JPanel pCenter , int num) {
			
			JPanel panel = new JPanel(); 
			JButton cancel = new JButton("취소");
			JLabel menuImg = new JLabel("매뉴 이미지");
			JLabel menuName = new JLabel("크리스피 버거 세트 사이다 감자튀김",0);
			JLabel cnt_label = new JLabel();
			JButton plus = new JButton("+");
			JButton minus = new JButton("-");
			JLabel menuMoney = new JLabel();
			
			panel.setBounds(0, 150 * num, 900, 150);
			panel.setBackground(new Color(0XFFE7DF));
			panel.setLayout(null);
			
			cancel.setBounds(10, 50, 100, 50);
			cancel.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			cancel.setBackground(Color.black);
			cancel.setForeground(Color.white);
			
			menuImg.setBounds(120, 0, 150, 150);
			menuImg.setIcon(new ImageIcon("image/set2.jpg"));
			menuImg.setText("");
			
			menuName.setBounds(280, 0, 500, 60);
			menuName.setOpaque(true);
			menuName.setForeground(Color.black);
			menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuName.setBackground(new Color(0XFFFF00));
			
			minus.setBounds(280, 80, 100, 50);
			minus.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			minus.setBackground(Color.black);
			minus.setForeground(Color.white);
			
			minus.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (count == 1) {
						cnt_label.setText(String.valueOf(count));
						menuMoney.setText(String.valueOf(sub_money) + "원");
					}else {
						count = count - 1;
						cnt_label.setText(String.valueOf(count));
						sub_money = sub_money - money;
						menuMoney.setText(String.valueOf(sub_money) + "원");
					}
				}
			});
			
			cnt_label.setText(String.valueOf(count));
			cnt_label.setBounds(380, 80, 100, 50);
			cnt_label.setOpaque(true);
			cnt_label.setHorizontalAlignment(JLabel.CENTER);
			cnt_label.setForeground(Color.black);
			cnt_label.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			cnt_label.setBackground(new Color(0XFFFFFF));
			
			plus.setBounds(480, 80, 100, 50);
			plus.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			plus.setBackground(Color.black);
			plus.setForeground(Color.white);
			
			plus.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					cnt_label.setText(String.valueOf(count));
					
					sub_money = sub_money + money;
					menuMoney.setText(String.valueOf(sub_money) + "원");
				}
			});
			
			menuMoney.setText(String.valueOf(money) + "원");
			menuMoney.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuMoney.setOpaque(true);
			menuMoney.setForeground(Color.RED);
			menuMoney.setBackground(new Color(0XFFE7DF));
			menuMoney.setBounds(600, 90, 200, 30);
			
			panel.add(cancel);
			panel.add(menuImg);
			panel.add(menuName);
			panel.add(minus);
			panel.add(plus);
			panel.add(cnt_label);
			panel.add(menuMoney);
			
			arrpanel.add(panel);
			pCenter.add(arrpanel.get(num));
	}
	
	public int getSub_money() {
		return sub_money;
	}
}
