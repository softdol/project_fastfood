package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.OjdbcConnection;
import kioske.YounukLee7.dbtablePocket.MenuPicture;

public class Logo_MenuName_Panel extends JPanel{
	
	public Logo_MenuName_Panel(int idx,String set) {
		
		String sql = "SELECT set_idx, menu_name, set_name, set_img_path, img_big_path FROM menu INNER JOIN menu_set USING (menu_idx) WHERE menu_idx = ?";
		//MenuPicture menuPicture = null;
		ArrayList<MenuPicture> menuPicture = new ArrayList<>();
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			pstmt.setInt(1, idx);
			try(ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
//					menuPicture = new MenuPicture(rs);
					menuPicture.add(new MenuPicture(rs));
				}
				
			} catch (Exception e) {
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		setBackground(new Color(0XFFF2DD));
        setBounds(0,0,900,300);
        setLayout(null);
        
		JLabel logo = new JLabel("·Î°í");
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		String check_menuName;
		if (set == "s") {
			check_menuName = menuPicture.get(0).getSet_name();
		}else if (set == "l") {
			check_menuName = menuPicture.get(1).getSet_name();
		}else {
			check_menuName = menuPicture.get(0).getMenu_name();
		}
		JLabel menuName = new JLabel();
		menuName.setText(check_menuName);
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		
		add(logo);
		add(menuName);
		
	}

}
