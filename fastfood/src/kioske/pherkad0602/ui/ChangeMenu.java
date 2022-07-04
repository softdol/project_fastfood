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

import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.Set_Option;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.action.MenuChangeAction;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.SetDatabase;
import manager.component.ManagerCP;

public class ChangeMenu extends JPanel{
	
	kiosk7  kiosk7;
	
	public ChangeMenu(Set_Option option, ArrayList<MenuDatabase> menuList, ArrayList<MenuDatabase> menuInfo,
			ArrayList<SetDatabase> setList, int menuidx, String  set, int setidx, int sideidx, int drinkidx, int catei
			,kiosk7 kiosk7, int final_price) {
		
		this.kiosk7 = kiosk7;
		EmptyBorder border = new EmptyBorder(getInsets());
		
		int a = menuList.size();
		int b = (a/3)+1;
		
		LayoutManager manager = new GridLayout(b, 3);

		setBounds(0, 0, 670, 220*b);
		setBackground(Color.white);
		setLayout(manager);
		setBorder(border);
		
		
		for(int i = 0; i <a; ++i) {
			
			JButton btn3 = new JButton();
			btn3.setBackground(new Color(0xFFFFFF));
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
			nameLabel.setBounds(0,160,210,35);
			nameLabel.setBackground(Color.white);
			if(menuList.get(i).getMenu_name().length() >10) {
				nameLabel.setFont(new Font("HY°ß°íµñ", Font.BOLD,13));
			} else {
				nameLabel.setFont(new Font("HY°ß°íµñ", Font.BOLD,20));
			}
			nameLabel.setBorder(border);
			
			StyledDocument doc1 = nameLabel.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc1.setParagraphAttributes(0, doc1.getLength(), center, false);
			
			btn3.add(nameLabel);
			
			int drinkprice = menuList.get(i).getMenu_price()-menuInfo.get(1).getMenu_price(); 
			int sideprice = menuList.get(i).getMenu_price()-menuInfo.get(2).getMenu_price(); 
			int sale = Integer.valueOf(menuInfo.get(0).getMenu_sale());

			JTextPane priceLabel = new JTextPane();
			int temp1 = 0;
			if(catei == 2) {

				priceLabel.setText(ManagerCP.viewWon((drinkprice*(100-sale))/100)+"¿ø");
				temp1 = (drinkprice*(100-sale))/100;
				
			} else if(catei ==3){
				priceLabel.setText(ManagerCP.viewWon((sideprice*(100-sale))/100)+"¿ø");
				temp1 = (sideprice*(100-sale))/100;
				
			}
			

			int addCost = temp1+final_price;
			
			btn3.addActionListener(new MenuChangeAction(option, menuidx, set, setidx, sideidx, drinkidx, catei, kiosk7, menuList.get(i).getMenu_idx(), addCost));

			priceLabel.setBounds(0,195,210,25);
			priceLabel.setBackground(Color.white);
			priceLabel.setFont(new Font("HY°ß°íµñ", Font.BOLD,20));
			priceLabel.setBorder(border);
			

			StyledDocument doc2 = priceLabel.getStyledDocument();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc2.setParagraphAttributes(0, doc2.getLength(), center, false);
			

			btn3.add(priceLabel);
			
				
			add(btn3);
		}
				
	}
	
}
