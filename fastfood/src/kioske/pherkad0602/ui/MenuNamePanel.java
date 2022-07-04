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

	public  MenuNamePanel(String subTitle) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		setBounds(0, 100, 684, 100);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
		
		JLabel mName = new JLabel("  " + subTitle);
		
		mName.setBounds(20,10,500,80);
		mName.setFont(new Font("HY°ß°íµñ", Font.PLAIN,55));
		add(mName);
		
		
	}
	
}
