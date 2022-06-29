package kioske.YounukLee7.cartButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import database.OjdbcConnection;
import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.dbtablePocket.Menu;
import kioske.YounukLee7.kioskeUI.Cart_mid;
import kioske.pherkad0602.MainMenuKiosk;

public class CartButton {
	
	int count = 1;
	// 매뉴 가격 (db에서 뽑아 쓰니까 값이 안변하는 값 하나 필요)
	int money = 5000;
	int sub_money = 5000;

	public CartButton(ArrayList arrayList, JPanel pCenter , int num) {
		
		// ArrayList에 한개만 들어있을 때
		String sql = "SELECT * FROM menu where menu_idx = ?";
		Menu menu = null;
		if (arrayList.size() == 1) {
			int menu_idx = Integer.valueOf(String.valueOf(arrayList.get(0)));

				try (
						Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
					pstmt.setInt(1, menu_idx);
					try (ResultSet rs = pstmt.executeQuery();) {
						while (rs.next()) {
							menu = new Menu(rs);
						}
					} catch (Exception e) {
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}else {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			JPanel panel = new JPanel(); 
			panel.setBounds(0, 150 * num, 900, 150);
			panel.setBackground(new Color(0XFFE7DF));
			panel.setLayout(null);
			
			JButton cancel = new JButton("취소");
			cancel.setBounds(10, 50, 100, 50);
			cancel.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			cancel.setBackground(Color.black);
			cancel.setForeground(Color.white);
			
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			JLabel menuImg = new JLabel();
			menuImg.setBounds(120, 0, 150, 150);
			
			// arrayList에 주문이 한개일 때
			if (arrayList.size() == 1) {
				ImageIcon icon = new ImageIcon(menu.getIMG_BIG_PATH());
				Image img = icon.getImage();
				Image sideimg = img.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
				ImageIcon sideicon = new ImageIcon(sideimg);
				menuImg.setIcon(sideicon);
			}
			
			
			JLabel menuName = new JLabel();
			menuName.setBounds(280, 0, 500, 60);
			menuName.setOpaque(true);
			menuName.setForeground(Color.black);
			menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuName.setBackground(new Color(0XFFFF00));
			
			if (arrayList.size() == 1) {
				menuName.setText(menu.getMENU_NAME());
			}
			
			JLabel cnt_label = new JLabel();
			cnt_label.setText(String.valueOf(count));
			cnt_label.setBounds(380, 80, 100, 50);
			cnt_label.setOpaque(true);
			cnt_label.setHorizontalAlignment(JLabel.CENTER);
			cnt_label.setForeground(Color.black);
			cnt_label.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			cnt_label.setBackground(new Color(0XFFFFFF));
			
			JLabel menuMoney = new JLabel();
			menuMoney.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuMoney.setOpaque(true);
			menuMoney.setForeground(Color.RED);
			menuMoney.setBackground(new Color(0XFFE7DF));
			menuMoney.setBounds(600, 90, 200, 30);
			
			if (arrayList.size() == 1) {
				menuMoney.setText(menu.getMENU_PRICE() + "원");
			}
			
			JButton minus = new JButton("-");
			minus.setBounds(280, 80, 100, 50);
			minus.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			minus.setBackground(Color.black);
			minus.setForeground(Color.white);
			
			int menuPrice = 0;
			if (arrayList.size() == 1) {
				menuPrice = menu.getMENU_PRICE();
			}
			int price = menuPrice;
			minus.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if (count == 1) {
						cnt_label.setText(String.valueOf(count));
						menuMoney.setText(price + "원");
					}else {
						count = count - 1;
						cnt_label.setText(String.valueOf(count));
						sub_money = sub_money - money;
						menuMoney.setText(price + "원");
					}
				}
			});
			
			JButton plus = new JButton("+");
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
			
			panel.add(cancel);
			panel.add(menuImg);
			panel.add(menuName);
			panel.add(minus);
			panel.add(plus);
			panel.add(cnt_label);
			panel.add(menuMoney);
			
			pCenter.add(panel);
	}
	
	public int getSub_money() {
		return sub_money;
	}
}
