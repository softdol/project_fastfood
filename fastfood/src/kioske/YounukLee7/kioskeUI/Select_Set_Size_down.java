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
import kioske.YounukLee7.Select_Side_Drink;
import kioske.YounukLee7.Sub_JFrame;
import kioske.YounukLee7.dbtablePocket.MenuPicture;

public class Select_Set_Size_down extends JPanel{
	
	public Select_Set_Size_down(Sub_JFrame screen, int idx) {
		
		String sql = "SELECT set_idx, menu_name, set_name, set_img_path, img_big_path FROM menu INNER JOIN menu_set USING (menu_idx) WHERE menu_idx = ?";
//		MenuPicture menuPicture = null;
		ArrayList<MenuPicture> menuPicture = new ArrayList<>();
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, idx);
			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
//					menuPicture = new MenuPicture(rs);
					menuPicture.add(new MenuPicture(rs));
				}
			} catch (Exception e) {
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
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
		
		ImageIcon icon = new ImageIcon(menuPicture.get(0).getSet_img_path());
		Image img = icon.getImage();
		Image setimg = img.getScaledInstance(360, 260, Image.SCALE_SMOOTH);
		ImageIcon seticon = new ImageIcon(setimg);
		
		image_label.setIcon(seticon);
		
		JButton no_button = new JButton("아니오");
		no_button.setForeground(new Color(0xFFFFFF));
		no_button.setBackground(new Color(0x000000));
		no_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		no_button.setBounds(173, 450, 250, 60);
		
		no_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 세트 유무 "s"
				// 매뉴 idx, tpxm idx
				screen.veiw_Select_Side_Drink(idx, "s", menuPicture.get(0).getSet_idx(),0,0);
			}
		});
		
		JButton yes_button = new JButton("예");
		yes_button.setForeground(new Color(0xFFFFFF));
		yes_button.setBackground(new Color(0xFF0000));
		yes_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		yes_button.setBounds(463, 450, 250, 60);
		
		yes_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 라지세트 유무 "l"
				// 매뉴 idx, 세트 idx
				screen.veiw_Select_Side_Drink(idx, "l", menuPicture.get(1).getSet_idx(),0,0);
			}
		});
		
		add(no_button);
		add(yes_button);
		add(label);
		add(image_label);
		
	}

}
