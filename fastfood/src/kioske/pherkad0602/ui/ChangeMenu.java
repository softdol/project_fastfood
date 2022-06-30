package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
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

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.action.MenuChangeAction;
import kioske.pherkad0602.database.MenuDatabase;

public class ChangeMenu extends JPanel{
	
HomeMenuKiosk hMain;
	
	public ChangeMenu(ArrayList<MenuDatabase> menuList, int idx) {
		this.hMain = hMain;
		EmptyBorder border = new EmptyBorder(getInsets());
		
		int a = menuList.size();
		int b = (a/3)+1;
		
		LayoutManager manager = new GridLayout(b, 3);

		setBounds(0, 0, 670, 210*b);
		setBackground(Color.white);
		setLayout(manager);
		setBorder(border);

		
		for(int i = 0; i <a; ++i) {
			
			
			JButton btn3 = new JButton();
			btn3.setBackground(new Color(0xFFFFFF));
			btn3.setName(String.valueOf(menuList.get(i).getMenu_idx()));
			btn3.addActionListener(new MenuChangeAction(hMain, menuList.get(i).getMenu_idx(), idx));
			btn3.setBorder(border);
			btn3.setLayout(null);
			
			ImageIcon icon = new ImageIcon(String.valueOf(menuList.get(i).getImg_big_path()));		
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(210, 160, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			JLabel imageLabel= new JLabel(changeIcon);
			
			imageLabel.setBounds(0,0,210,160);
			imageLabel.setBackground(Color.white);
			imageLabel.setBorder(border);
			btn3.add(imageLabel);

			
			JTextPane nameLabel = new JTextPane();
			nameLabel.setText(String.valueOf(menuList.get(i).getMenu_name()));
			nameLabel.setBounds(0,160,210,25);
			nameLabel.setBackground(Color.white);
			nameLabel.setFont(new Font("�ü�ü", Font.BOLD,20));
			nameLabel.setBorder(border);
			
			StyledDocument doc1 = nameLabel.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc1.setParagraphAttributes(0, doc1.getLength(), center, false);
			
			btn3.add(nameLabel);
			
			JTextPane priceLabel = new JTextPane();
			priceLabel.setText(String.valueOf(menuList.get(i).getMenu_price() +"��"));
			priceLabel.setBounds(0,185,210,25);
			priceLabel.setBackground(Color.white);
			priceLabel.setFont(new Font("�ü�ü", Font.BOLD,20));
			priceLabel.setBorder(border);
			

			StyledDocument doc2 = priceLabel.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc2.setParagraphAttributes(0, doc2.getLength(), center, false);
			
			btn3.add(priceLabel);
			
				
			add(btn3);
		}
				
	}
	
}
