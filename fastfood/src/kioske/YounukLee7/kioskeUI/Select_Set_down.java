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
import kioske.YounukLee7.Select_Set_Size;
import kioske.YounukLee7.Sub_JFrame;
import kioske.YounukLee7.dbtablePocket.EventPage;
import kioske.YounukLee7.dbtablePocket.MenuPicture;
import kioske.pherkad0602.HomeMenuKiosk;

public class Select_Set_down extends JPanel{
	
	public Select_Set_down(Main_JFrame frame, int menuidx) {
		
		String sql = "SELECT set_idx, menu_name, set_name, set_img_path, img_big_path FROM menu INNER JOIN menu_set USING (menu_idx) WHERE menu_idx = ?";
//		ArrayList<MenuPicture> menuPicture = new ArrayList<>();
		MenuPicture menuPicture = null;
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			pstmt.setInt(1, menuidx);
			try(ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					menuPicture = new MenuPicture(rs);
//					menuPicture.add(new MenuPicture(rs));
				}
				
			} catch (Exception e) {
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
//		for (int i = 0; i < MenuPicture_list.size(); i++) {
//			System.out.println(menuPicture.getImg_big_path());
//			System.out.println(menuPicture.getSet_img_path());
//		}
		
//		System.out.println("set down: " + idx);
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,770);
		setLayout(null);
		
		JLabel select_label = new JLabel("선택해주세요");
		select_label.setFont(new Font("HY견고딕", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		JButton single_button = new JButton("단품");
		single_button.setBounds(173, 200, 250, 350);
		ImageIcon icon = new ImageIcon(menuPicture.getImg_big_path());
		Image img = icon.getImage();
		Image soloimg = img.getScaledInstance(250, 350, Image.SCALE_SMOOTH);
		ImageIcon soloicon = new ImageIcon(soloimg);
		single_button.setIcon(soloicon);
		
		// 단품 눌렀을 때
		single_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 매뉴 idx 보내기
				frame.veiw_Home_solo_burger(menuidx);
//				HomeMenuKiosk home = new HomeMenuKiosk(frame, idx);
//				home.setPrice(idx);
			}
		});
		
		JButton set_button = new JButton("세트");
		set_button.setBounds(463, 200, 250, 350);
		ImageIcon icon1 = new ImageIcon(menuPicture.getSet_img_path());
		Image img1 = icon1.getImage();
		Image setimg = img1.getScaledInstance(250, 350, Image.SCALE_SMOOTH);
		ImageIcon seticon = new ImageIcon(setimg);
		set_button.setIcon(seticon);
		
		int set_idx = menuPicture.getSet_idx();
		set_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				                         // 세트 표시 s
				//screen.veiw_Set_Size(idx,"s");
				frame.veiw_Select_Side_Drink(menuidx, "s", set_idx, 0, 0);
			}
		});
		
		add(single_button);
		add(set_button);
		add(select_label);
		
	}

}
