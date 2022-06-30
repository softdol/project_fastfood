package kioske.pherkad0602;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.database.SetDatabase;
import kioske.pherkad0602.ui.ChangeCheck;
import kioske.pherkad0602.ui.ChangeMenuPanel;
import kioske.pherkad0602.ui.OrderCheck;
import kioske.pherkad0602.ui.PayPanel;

public class kiosk7 extends JFrame{
		
	   Main_JFrame frame;
	   int idx;
	   kiosk7 ki7;
	   int final_price;
	   JLabel payLabel1 = new JLabel();
	   JLabel payLabel2 = new JLabel();
	   JButton payBtn1 = new JButton();
	   JButton payBtn2 = new JButton();
	   
	   
	   public void order(kiosk7 ki7, int idx, String addCost) {
			// TODO Auto-generated method stub
		}
   
		public void setPrice(kiosk7 ki7,int idx, int addCost) {
			payLabel2.setText(String.valueOf(addCost)+ "¿ø");
			
			payBtn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			payBtn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	   
	   public kiosk7(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int catei) {
	      
		  ArrayList<PsList> psList = new ArrayList<>();
		  String sql = "select * from menu where MENU_CATEGORY_IDX = ?";
	  	  psList.add(new PsList('I', String.valueOf(catei)));
		  ArrayList<MenuDatabase> menuList = ReturnModel.selMenuList1(sql, psList);
		   
		  ArrayList<PsList> psList2 = new ArrayList<>();
		  String sql2 = "select * from menu where MENU_IDX IN (?,?,?)";
	  	  psList2.add(new PsList('I', String.valueOf(menuidx)));
	  	  psList2.add(new PsList('I', String.valueOf(sideidx)));
	  	  psList2.add(new PsList('I', String.valueOf(drinkidx)));
		  ArrayList<MenuDatabase> menuInfo = ReturnModel.selMenuList1(sql2, psList2);

		  ArrayList<PsList> psList3 = new ArrayList<>();
		  String sql3 = "select * from menu_set where Set_IDX = ?";
	  	  psList3.add(new PsList('I', String.valueOf(setidx)));
		  ArrayList<SetDatabase> setList = ReturnModel.setList(sql3, psList3);
		   
		  JPanel pNorth = new JPanel();
		  JPanel pSouth = new JPanel();
		  JPanel payPanel = new JPanel();

		   
		  JLabel menuName = new JLabel(menuInfo.get(0).getMenu_name() + " ¼¼Æ®");
		  menuName.setBounds(280, 50, 500, 200);
		   menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.BOLD, 50));
		 
		  
	      pNorth.setBackground(new Color(0XFFF2DD));
	      pNorth.setBounds(0,0,900,300);
	      pNorth.setLayout(null);
	        
	      pSouth.setBackground(new Color(0XFFE7DF));
	      pSouth.setBounds(0,300,900,540);
	      pSouth.setLayout(null);
	      
	      payPanel.setBackground(Color.cyan);
	      payPanel.setBounds(0,840,900,200);
	      payPanel.setLayout(null);
	      
	      // ÀÌ¹ÌÁö Ãß°¡
	      ImageIcon icon = new ImageIcon("pos_image/logo.png");		
	      Image img = icon.getImage();
	      Image changeImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	      ImageIcon changeIcon = new ImageIcon(changeImg);
	      JLabel logo = new JLabel(changeIcon);

	      logo.setBounds(50,50,200,200);
	      //
	      
	      
	   
	      pNorth.add(logo);
	      pNorth.add(menuName);
	     
	      // ¸Þ´º ÆÐ³Î Å¬·¡½ºÈ­ ÇØ¾ßÇÔ
		  JLabel menuLabel = new JLabel();
	     
		  menuLabel.setBounds(100,20,300,50);
		  
		  if (catei ==2) {
			  menuLabel.setText("À½·á º¯°æ");
		  } else {
			  menuLabel.setText("ÇÜ¹ö°Å º¯°æ");

		  }
		  menuLabel.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.BOLD, 40));
		  pSouth.add(menuLabel);
	      

		
		 
			
	      
	      // °áÁ¦ÆÐ³Î Å¬·¡½ºÈ­ ÇØ¾ßÇÔ
		  payLabel1 = new JLabel();
		  payLabel2 = new JLabel();
		  payBtn1 = new JButton();
		  payBtn2 = new JButton();
		   
		   payLabel1.setBounds(100,20,300,50);
		   payLabel1.setText("ÃÑ ÁÖ¹® ±Ý¾×");
		   payLabel1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		   payPanel.add(payLabel1);
		   
		   int price = Integer.valueOf(menuInfo.get(0).getMenu_price())
				   + Integer.valueOf(menuInfo.get(1).getMenu_price())
				   + Integer.valueOf(menuInfo.get(2).getMenu_price());
		   int sale = Integer.valueOf(setList.get(0).getSET_SALE());
		   
		   final_price = (price *(100-sale))/100;
		   
		   ChangeMenuPanel chgMenu = new ChangeMenuPanel(menuList, menuInfo, setList, 
					 menuidx, set, setidx, sideidx, drinkidx, catei, this, final_price);
		   pSouth.add(chgMenu);
		   
		   payLabel2.setBounds(700,20,300,50);
		   payLabel2.setText(String.valueOf(final_price)+"¿ø");
		   payLabel2.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		   payPanel.add(payLabel2);
		   
		   payBtn1.setBounds(50,100,350,50);
		   payBtn1.setText("Ãë¼Ò");
		   payBtn1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		   payPanel.add(payBtn1);
		   
		   payBtn2.setBounds(480,100,350,50);
		   payBtn2.setText("¿Ï·á");
		   payBtn2.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		   payPanel.add(payBtn2);
	      //
	      
		     
		  add(pNorth);
		  add(pSouth);
		  add(payPanel);
		      
	      setLayout(null);
	      setBounds(510,0,900,1040);
	      setResizable(false);
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      setVisible(true);
	   }
	   public static void main(String[] args) {
	      new kiosk7(1, "µð·°½º ¹ö°Å ¼¼Æ®", 1, 5, 4, 2);
	   }

	

	

}