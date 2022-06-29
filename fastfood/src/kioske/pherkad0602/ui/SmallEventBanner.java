package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.StringValueExp;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.action.MenuSelectionAction;

public class SmallEventBanner extends JPanel{
	
	public Component SmallEventBanner(int i) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		String sql = "SELECT Small_Event_Page FROM Event_Page";
		
		ArrayList evBanner = new ArrayList<>();
		
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				evBanner.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MenuSelectionAction listener = new MenuSelectionAction();
		
		JButton evButton = new JButton();
		evButton.setBounds(5, i*150, 650, 145);
		evButton.setBackground(Color.white);
		evButton.setBorder(border);
		evButton.addActionListener(listener);
		ImageIcon icon = new ImageIcon(String.valueOf(evBanner.get(i)));		
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(680, 150, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel logo = new JLabel(changeIcon);
		evButton.add(logo);
		

		return evButton;
	
	}
	
	public static void main(String[] args) {
	}

}
