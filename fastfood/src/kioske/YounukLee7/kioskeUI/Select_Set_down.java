package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
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
import kioske.YounukLee7.Select_Set_Size;
import kioske.YounukLee7.Sub_JFrame;
import kioske.YounukLee7.dbtablePocket.EventPage;
import kioske.YounukLee7.dbtablePocket.MenuPicture;

public class Select_Set_down extends JPanel{
	
	public Select_Set_down(Sub_JFrame screen, int idx) {
		
		String sql = "SELECT s.set_img_path, m.img_big_path FROM menu m INNER JOIN menu_set s on m.menu_idx = s.set_rep WHERE menu_idx = ?";
//		ArrayList<MenuPicture> MenuPicture_list = new ArrayList<>();
		MenuPicture menuPicture = null;
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			pstmt.setInt(1, idx);
			try(ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					menuPicture = new MenuPicture(rs);
//					MenuPicture_list.add(new MenuPicture(rs));
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
		single_button.setIcon(new ImageIcon(menuPicture.getImg_big_path()));
		
		single_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton set_button = new JButton("세트");
		set_button.setBounds(463, 200, 250, 350);
		set_button.setIcon(new ImageIcon(menuPicture.getSet_img_path()));
		
		set_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Set_Size(idx);
			}
		});
		
		add(single_button);
		add(set_button);
		add(select_label);
		
	}

}
