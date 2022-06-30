package kioske.pherkad0602;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.pherkad0602.ui.ChangeMenuPanel;

public class kiosk7 extends JFrame{

	   JPanel pNorth = new JPanel();
	   JPanel pSouth = new JPanel();
	   JPanel payPanel = new JPanel();

	   
	   JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å");
	 
	   
	   public kiosk7() {
	      
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
	      
	      
	      menuName.setBounds(280, 50, 500, 200);
	      menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
	 
	      pNorth.add(logo);
	      pNorth.add(menuName);
	     
	      // ¸Þ´º ÆÐ³Î Å¬·¡½ºÈ­ ÇØ¾ßÇÔ
		  JLabel menuLabel = new JLabel();
	     
		  menuLabel.setBounds(100,50,300,50);
		  menuLabel.setText("ÇÜ¹ö°Å º¯°æ");
		  menuLabel.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		  pSouth.add(menuLabel);
	      
		  String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";

		 //ChangeMenuPanel chgMenu = new ChangeMenuPanel();
		//  pSouth.add(chgMenu.ChangeMenuPanel(this,sql1));
		 
			
	      
	      // °áÁ¦ÆÐ³Î Å¬·¡½ºÈ­ ÇØ¾ßÇÔ
		   JLabel payLabel1 = new JLabel();
		   JLabel payLabel2 = new JLabel();
		   JButton payBtn1 = new JButton();
		   JButton payBtn2 = new JButton();
		   
		   payLabel1.setBounds(100,20,300,50);
		   payLabel1.setText("ÃÑ ÁÖ¹® ±Ý¾×");
		   payLabel1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		   payPanel.add(payLabel1);
		   
		   payLabel2.setBounds(700,20,300,50);
		   payLabel2.setText("5000¿ø");
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
	      new kiosk7();
	   }
}