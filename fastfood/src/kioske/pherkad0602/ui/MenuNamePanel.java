package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.database.SubMenuDatabase;

public class MenuNamePanel extends JPanel {

	public Component MenuNamePanel(int i) {
		EmptyBorder border = new EmptyBorder(getInsets());
		JPanel mNamePanel = new JPanel();
		
		mNamePanel.setBounds(0, 100, 684, 100);
		mNamePanel.setLayout(null);
		mNamePanel.setBackground(Color.white);
		mNamePanel.setBorder(border);
		
		String sql = "SELECT * FROM Menu_Subcategory";
		ArrayList name = SubMenuDatabase.subMenuNameArray(sql);
		
		
		JLabel mName = new JLabel("  "+String.valueOf(name.get(i)));
		
		mName.setBounds(20,10,500,80);
		mName.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,55));
		mNamePanel.add(mName);
		
		return mNamePanel;
	}
	
}
