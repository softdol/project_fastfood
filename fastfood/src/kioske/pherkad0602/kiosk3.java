package kioske.pherkad0602;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class kiosk3 extends JFrame{
	
	public kiosk3() {
		
		LayoutManager manager = new GridLayout(4, 3);
		
		setLayout(null);
		JPanel catePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel payPanel = new JPanel();

		add(catePanel);
		add(payPanel);
		//add(mainPanel);
		
		
		catePanel.setBounds(0, 0, 200, 800);
		catePanel.setLayout(null);
		
		payPanel.setBounds(0, 800, 884, 200);
		payPanel.setLayout(null);

		mainPanel.setBounds(200, 0, 684, 1200);
		mainPanel.setLayout(null);

		
		
		
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
		
		// �̺�Ʈ
		for(int i = 0; i <3; ++i) {
			
			JButton btn2 = new JButton("�̺�Ʈ ���");
			btn2.setBounds(0, i*150, 670, 150);
			btn2.setBackground(Color.white);
			mainPanel.add(btn2);
		}
		
		
		//
		
		// Ŭ����ȭ ����
		

		
		JPanel menuPanel = new JPanel();
		mainPanel.add(menuPanel);
		menuPanel.setBounds(0, 450, 670, 800);
		menuPanel.setLayout(manager);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(200, 0, 684, 800);
		Dimension size = new Dimension();
				size.setSize(600,1250);
		mainPanel.setPreferredSize(size);
		add(scrollPane);
		
		
		//mainPanel.add(scrollPane);
		for(int i = 0; i <12; ++i) {
			
			JButton btn3 = new JButton("�޴�");
			btn3.setFont(new Font("�ü�ü", Font.PLAIN,40));
			btn3.setBackground(new Color(0xFFFFFF));
			menuPanel.add(btn3);
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
		setBounds(510,0,900,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    setResizable(false);

	}
	
	public static void main(String[] args) {
		
		new kiosk3();

	}
}
