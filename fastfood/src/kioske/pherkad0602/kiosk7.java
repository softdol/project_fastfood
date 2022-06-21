package kioske.pherkad0602;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class kiosk7 extends JFrame{

	   JPanel pNorth = new JPanel();
	   JPanel pSouth = new JPanel();
	   JPanel payPanel = new JPanel();

	   
	   JLabel logo = new JLabel("�ΰ�");
	   JLabel menuName = new JLabel("ũ������ ����");
	 
	   
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
	      
	      logo.setBounds(50, 50, 200, 200);
	      logo.setIcon(new ImageIcon("image/logo.png"));
	      
	      menuName.setBounds(280, 50, 500, 200);
	      menuName.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
	 
	      pNorth.add(logo);
	      pNorth.add(menuName);
	     
	      // �޴� �г� Ŭ����ȭ �ؾ���
		  JLabel menuLabel = new JLabel();
	      JPanel menuPanel = new JPanel();
	      
	      LayoutManager manager = new GridLayout(4, 3);
	      
		  menuLabel.setBounds(100,50,300,50);
		  menuLabel.setText("�ܹ��� ����");
		  menuLabel.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
		  pSouth.add(menuLabel);
	      
		
		  // �޴� ����
		  menuPanel.setLayout(manager);
		  for(int i = 0; i <12; ++i) {
				
			  JButton btn3 = new JButton("�޴�");
			  btn3.setFont(new Font("�ü�ü", Font.PLAIN,40));
			  btn3.setBackground(new Color(0xFFFFFF));
			  menuPanel.add(btn3);
		  }
		  
		  // ��ũ�� ����
		  JScrollPane scrollPane = new JScrollPane(menuPanel);
		  scrollPane.setBounds(100, 100, 684, 440);
		  Dimension size = new Dimension();
		  		size.setSize(600,900);
		  menuPanel.setPreferredSize(size);
		  pSouth.add(scrollPane);
	      
		 
			
	      
	      // �����г� Ŭ����ȭ �ؾ���
		   JLabel payLabel1 = new JLabel();
		   JLabel payLabel2 = new JLabel();
		   JButton payBtn1 = new JButton();
		   JButton payBtn2 = new JButton();
		   
		   payLabel1.setBounds(100,20,300,50);
		   payLabel1.setText("�� �ֹ� �ݾ�");
		   payLabel1.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
		   payPanel.add(payLabel1);
		   
		   payLabel2.setBounds(700,20,300,50);
		   payLabel2.setText("5000��");
		   payLabel2.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
		   payPanel.add(payLabel2);
		   
		   payBtn1.setBounds(50,100,350,50);
		   payBtn1.setText("���");
		   payBtn1.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
		   payPanel.add(payBtn1);
		   
		   payBtn2.setBounds(480,100,350,50);
		   payBtn2.setText("�Ϸ�");
		   payBtn2.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
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