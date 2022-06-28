package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.SubMenuDatabase;

public class SubMenuPanel extends JPanel{
	
	public SubMenuPanel(ArrayList<SubMenuDatabase> sList){
		EmptyBorder border = new EmptyBorder(getInsets());
		
//		ArrayList menuName = MenuDatabase.menuNameArray(sql);
//		ArrayList subMenuName = SubMenuDatabase.subMenuNameArray(sql);
//		ArrayList subMenuIdx = SubMenuDatabase.subMenuIdxNumArray(sql);
//		
//		int a =  SubMenuDatabase.size(sql);
		
		
		
		setBounds(0, 0, 684, 100);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
	

		for(int i = 0; i <sList.size(); ++i) {
			
			JButton btn4 = new JButton(sList.get(i).getMENU_SUBCATEGORY_NAME());
			btn4.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN,20));
			btn4.setBounds(15+(i*170), 30, 150, 50);
			btn4.setBackground(new Color(0xFFFFFF));
			add(btn4);
		}
			
		
	}
	
}
