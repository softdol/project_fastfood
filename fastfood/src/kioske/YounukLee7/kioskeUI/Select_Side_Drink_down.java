package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.OjdbcConnection;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.Set_Option;
import kioske.YounukLee7.Sub_JFrame;
import kioske.YounukLee7.dbtablePocket.EventPage;
import kioske.YounukLee7.dbtablePocket.Menu;
import kioske.YounukLee7.dbtablePocket.MenuPicture;

public class Select_Side_Drink_down extends JPanel{
	
	public Select_Side_Drink_down(Set_Option option, int menuidx, int setidx, int sideidx, int drinkidx) {
		
		String sql = "SELECT * FROM menu where menu_idx in (SELECT menu_idx FROM menu_set_list WHERE set_idx = ?) order by menu_category_idx";
		ArrayList<Menu> menu = new ArrayList<>();

		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setInt(1, setidx);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					menu.add(new Menu(rs));
				}
			} catch (Exception e) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 사이드 변경하면 실행
		String sql2 = "SELECT * FROM menu where menu_idx = ?";
		Menu menu2 = null;

		if (sideidx > 0) {

			try (
					Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql2);
				) {
				pstmt.setInt(1, sideidx);
				try (ResultSet rs = pstmt.executeQuery();) {
					while (rs.next()) {
						menu2 = new Menu(rs);
					}
				} catch (Exception e) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// 음료 변경하면 실행
		String sql3 = "SELECT * FROM menu where menu_idx = ?";
		Menu menu3 = null;

		if (drinkidx > 0) {

			try (
					Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql3);
				) {
				pstmt.setInt(1, drinkidx);
				try (ResultSet rs = pstmt.executeQuery();) {
					while (rs.next()) {
						menu3 = new Menu(rs);
					}
				} catch (Exception e) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,740);
		setLayout(null);
		
		JLabel burgerlabel = new JLabel("햄버거 사진");
		burgerlabel.setBounds(100, 150, 200, 170);
		ImageIcon icon = new ImageIcon(menu.get(0).getIMG_BIG_PATH());
		Image img = icon.getImage();
		Image burgerimg = img.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
		ImageIcon burgericon = new ImageIcon(burgerimg);
		burgerlabel.setIcon(burgericon);
		
		
		JLabel side_label = new JLabel("사이드 사진");
		side_label.setBounds(350, 150, 200, 170);
		
		if (sideidx > 0) {
			ImageIcon icon1 = new ImageIcon(menu2.getIMG_BIG_PATH());
			Image img1 = icon1.getImage();
			Image sideimg = img1.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
			ImageIcon sideicon = new ImageIcon(sideimg);
			side_label.setIcon(sideicon);
		}else {
			ImageIcon icon1 = new ImageIcon(menu.get(2).getIMG_BIG_PATH());
			Image img1 = icon1.getImage();
			Image sideimg = img1.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
			ImageIcon sideicon = new ImageIcon(sideimg);
			side_label.setIcon(sideicon);
		}
		
		
		
		JLabel drink_label = new JLabel("음료 사진");
		drink_label.setBounds(600, 150, 200, 170);
		
		// 음료 변경하면 실행
		if (drinkidx > 0) {
			ImageIcon icon2 = new ImageIcon(menu3.getIMG_BIG_PATH());
			Image img2 = icon2.getImage();
			Image drinkimg = img2.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
			ImageIcon drinkicon = new ImageIcon(drinkimg);
			drink_label.setIcon(drinkicon);
		} else {
			ImageIcon icon2 = new ImageIcon(menu.get(1).getIMG_BIG_PATH());
			Image img2 = icon2.getImage();
			Image drinkimg = img2.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
			ImageIcon drinkicon = new ImageIcon(drinkimg);
			drink_label.setIcon(drinkicon);
		}
		
		// 사이드변경 버튼 눌렀을 때
		JButton side_button = new JButton("사이드변경");
		side_button.setForeground(new Color(0x000000));
		side_button.setBackground(new Color(0xCCCCCC));
		side_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		side_button.setBounds(375, 330, 150, 50);
		
		side_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option.veiw_Select_Side(menuidx, "s", setidx, sideidx, drinkidx, 3);
			}
		});
		
		// 음료버튼 눌렀을 때
		JButton drink_button = new JButton("음료변경");
		drink_button.setForeground(new Color(0x000000));
		drink_button.setBackground(new Color(0xCCCCCC));
		drink_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		drink_button.setBounds(625, 330, 150, 50);
		
		drink_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option.veiw_Select_Drink(menuidx, "s", setidx, sideidx, drinkidx, 2);
			}
		});
		
		// 가격 보여줌
		int burgerPrice = menu.get(0).getMENU_PRICE(); // 햄버거
		int sidePrice; // 사이드 가격
		int drinkPrice; // 음료 가격
		
		if (sideidx > 0) {
			sidePrice = menu2.getMENU_PRICE();
		}else {
			sidePrice = menu.get(2).getMENU_PRICE();
		}
		
		if (drinkidx > 0) {
			drinkPrice = menu3.getMENU_PRICE();
		}else {
			drinkPrice = menu.get(1).getMENU_PRICE();
		}
		
		int sum = burgerPrice + drinkPrice + sidePrice;
		
		double price = sum - sum * (menu.get(0).getMENU_SALE() * 0.01);
		
		int allPrice = (int)Math.floor(price);
		
		//System.out.println(allPrice);
		
		JButton cart_button = new JButton("카트 담기");
		cart_button.setForeground(new Color(0xFFFFFF));
		cart_button.setBackground(new Color(0x000000));
		cart_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		cart_button.setBounds(150, 400, 590, 70);
		
		cart_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 햄버거번호, 세트번호, 음료번호, 사이드번호, 총 가격
				option.veiw_Home_set_burger(menuidx);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 600, 900, 140);
		panel.setBackground(new Color(0XFFF2DD));
		panel.setLayout(null);
		add(panel);
		
		JLabel label = new JLabel("총 주문 가격 : " + allPrice + "원");
		label.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		label.setForeground(new Color(0x000000));
		label.setBounds(500, 30, 400, 30);
		panel.add(label);
		
		add(burgerlabel);
		add(side_label);
		add(drink_label);
		add(side_button);
		add(drink_button);
		add(cart_button);
		
	}

}
