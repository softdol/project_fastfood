package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Menu extends JPanel {	
	
	public Component Menu() {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		
		String sql = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
		
		ArrayList menuImage = new ArrayList<>();
		ArrayList menuName = new ArrayList<>();
		ArrayList menuIdxNum = new ArrayList<>();

	//	ArrayList menuImage1 = MenuDatabase.menuImageArray(sql);
	//	ArrayList menuName1 = MenuDatabase.menuNameArray(sql);

		
		try(
				Connection conn = ojdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				menuImage.add(rs.getString(3));
				menuName.add(rs.getString(4));
				menuIdxNum.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//int a = MenuDatabase.size(sql);
		
		int a = menuImage.size();
		int b = (a/3)+1;
		
		LayoutManager manager = new GridLayout(b, 3);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 550, 670, 200*b);
		menuPanel.setLayout(manager);
		menuPanel.setBorder(border);


		for(int i = 0; i <a; ++i) {
			
			JButton btn3 = new JButton();
			btn3.setBackground(new Color(0xFFFFFF));
			btn3.setName(String.valueOf(menuIdxNum.get(i)));
			btn3.setBorder(border);
			btn3.setLayout(null);
			
			ImageIcon icon = new ImageIcon(String.valueOf(menuImage.get(i)));		
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(210, 140, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			JLabel imageLabel= new JLabel(changeIcon);
			
			imageLabel.setBounds(0,0,210,150);
			imageLabel.setBackground(Color.white);
			imageLabel.setBorder(border);
			btn3.add(imageLabel);

			
			JTextPane textLabel = new JTextPane();
			textLabel.setText(String.valueOf(menuName.get(i)));
			textLabel.setBounds(0,150,210,50);
			textLabel.setBackground(Color.white);
			textLabel.setFont(new Font("±Ã¼­Ã¼", Font.BOLD,20));
			textLabel.setBorder(border);
			
			StyledDocument doc = textLabel.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			
			btn3.add(textLabel);
				
			menuPanel.add(btn3);
		}
		
		return menuPanel;
	}

}
