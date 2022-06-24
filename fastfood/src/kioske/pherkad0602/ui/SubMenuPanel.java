package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SubMenuPanel extends JPanel{
	
	public Component SubMenuPanel(String sql){
		
		
		ArrayList menuName = MenuDatabase.menuNameArray(sql);
		ArrayList subMenuName = SubMenuDatabase.subMenuNameArray(sql);
		ArrayList subMenuIdx = SubMenuDatabase.subMenuIdxNumArray(sql);
		
		int a =  SubMenuDatabase.size(sql);
		
		JPanel subMenuPanel = new JPanel();
		
		subMenuPanel.setBounds(0, 0, 684, 100);
		subMenuPanel.setLayout(null);
		
	

		for(int i = 0; i <a; ++i) {
			
			JButton btn4 = new JButton(String.valueOf(subMenuName.get(i)));
			btn4.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,20));
			btn4.setBounds(15+(i*170), 30, 150, 50);
			btn4.setBackground(new Color(0xFFFFFF));
			subMenuPanel.add(btn4);
		}
		
		
		return subMenuPanel;
		
		
	}
	
}
