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

	public  MenuNamePanel(int i, ArrayList<SubMenuDatabase> sList) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		setBounds(0, 100, 684, 100);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
		
		JLabel mName = new JLabel("  "+String.valueOf(sList.get(i).getMENU_SUBCATEGORY_NAME()));
		
		mName.setBounds(20,10,500,80);
		mName.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,55));
		add(mName);
		
		
	}
	
}
