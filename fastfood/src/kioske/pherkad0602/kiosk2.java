package kioske.pherkad0602;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class kiosk2 extends JFrame {
	
	public kiosk2() {
			
			LayoutManager manager = new GridLayout(3,3);
			
			setLayout(null);
			JPanel catePanel = new JPanel();
			JPanel subMenuPanel = new JPanel();
			JPanel mainPanel = new JPanel();
			JPanel payPanel = new JPanel();
	
			add(catePanel);
			add(payPanel);
			add(subMenuPanel);
			add(mainPanel);
			
			catePanel.setBounds(0, 0, 200, 800);
			catePanel.setLayout(null);
	
			subMenuPanel.setBounds(200, 0, 684, 200);
			subMenuPanel.setLayout(null);
			
			payPanel.setBounds(0, 800, 884, 200);
			payPanel.setLayout(null);
	
			mainPanel.setBounds(200, 200, 684, 600);
			mainPanel.setLayout(manager);
	
			
			
			
			String[] cate = {"Ȩ", "�ܹ���", "���̵�", "����", "����Ʈ"};// ���߿� DB���� ī�װ� �޾ƿ��� �������� �ٲ�
			
			// Ŭ����ȭ ī�װ�
			
			JLabel logo = new JLabel("�ΰ�");
			logo.setBounds(0,0,200,100);
			catePanel.add(logo);
	
			for(int i = 0; i <cate.length; ++i) {
				JButton btn1 = new JButton(cate[i]);
				btn1.setFont(new Font("�ü�ü", Font.PLAIN,40));
				btn1.setBackground(new Color(0xFFFFFF));
				btn1.setBounds(0,100*(i+1),200,100);
				catePanel.add(btn1);
			}
			
			//
			
			// Ŭ����ȭ ���� �޴�
			
			String[] subMenu = {"Ŀ��" , "ź��", "�׿�����"};
			
			for(int i = 0; i <subMenu.length; ++i) {
				
				JButton btn4 = new JButton(subMenu[i]);
				btn4.setFont(new Font("�ü�ü", Font.PLAIN,40));
				btn4.setBounds(40+(100*(i*2)), 50, 200, 80);
				btn4.setBackground(new Color(0xFFFFFF));
				subMenuPanel.add(btn4);
			}
			//
			
			// Ŭ����ȭ ����
			
			for(int i = 0; i <9; ++i) {
				
				JButton btn3 = new JButton("�޴�");
				btn3.setFont(new Font("�ü�ü", Font.PLAIN,40));
				btn3.setBackground(new Color(0xFFFFFF));
				mainPanel.add(btn3);
			}
			
	
			//
			
			// Ŭ����ȭ ����
			JLabel price = new JLabel("�� �ֹ� ���� : ");
			price.setFont(new Font("�ü�ü", Font.PLAIN,40));
			price.setBounds(500,20,400,80);
			payPanel.add(price);
			
			String[] payMenu = {"ó������", "�ֹ�����", "����"};
	
			for(int i = 0; i <payMenu.length; ++i) {
				
				JButton btn4 = new JButton(payMenu[i]);
				btn4.setFont(new Font("�ü�ü", Font.PLAIN,40));
				btn4.setBounds(40+(100*(i*3)), 100, 200, 80);
				btn4.setBackground(new Color(0xFFFFFF));
				payPanel.add(btn4);
			}
			
			
			//
			setBounds(500,0,900,1040);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
	
	public static void main(String[] args) {
		
		new kiosk2();

	}
}

