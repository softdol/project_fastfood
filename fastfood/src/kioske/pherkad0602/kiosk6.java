package kioske.pherkad0602;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class kiosk6 extends JFrame{

   JPanel pNorth = new JPanel();
   JPanel pSouth = new JPanel();
   JButton button1 = new JButton("���̵庯��");
   JButton button2 = new JButton("���ắ��");
   JButton button3 = new JButton("īƮ ���");
   JLabel logo = new JLabel("�ΰ�");
   JLabel menuName = new JLabel("ũ������ ����");
   JLabel label1 = new JLabel("�ܹ��� ����");
   JLabel label2 = new JLabel("���̵� ����");
   JLabel label3 = new JLabel("���� ����");
   
   public kiosk6() {
      
      pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
      pSouth.setBackground(new Color(0XFFE7DF));
      pSouth.setBounds(0,300,900,740);
      pSouth.setLayout(null);
      
      label1.setFont(new Font("���� ��� ����", Font.PLAIN, 50));
      label1.setIcon(new ImageIcon("image/solo1.png"));
      label1.setBounds(100, 150, 200, 170);
      
      label2.setFont(new Font("���� ��� ����", Font.PLAIN, 50));
      label2.setIcon(new ImageIcon("image/side.png"));
      label2.setBounds(350, 150, 200, 170);
      
      label3.setFont(new Font("���� ��� ����", Font.PLAIN, 50));
      label3.setIcon(new ImageIcon("image/coke.jpg"));
      label3.setBounds(600, 150, 200, 170);
      
      logo.setBounds(50, 50, 200, 200);
      logo.setIcon(new ImageIcon("image/logo.png"));
      
      menuName.setBounds(280, 50, 500, 200);
      menuName.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
      
      button1.setForeground(new Color(0x000000));
      button1.setBackground(new Color(0xCCCCCC));
      button1.setFont(new Font("���� ��� ����", Font.PLAIN, 20));
      button1.setBounds(375, 330, 150, 50);
      
      button2.setForeground(new Color(0x000000));
      button2.setBackground(new Color(0xCCCCCC));
      button2.setFont(new Font("���� ��� ����", Font.PLAIN, 20));
      button2.setBounds(625, 330, 150, 50);
      
      button3.setForeground(new Color(0xFFFFFF));
      button3.setBackground(new Color(0x000000));
      button3.setFont(new Font("���� ��� ����", Font.PLAIN, 30));
      button3.setBounds(150, 400, 590, 70);
      
      add(pNorth, BorderLayout.NORTH);
      add(pSouth, BorderLayout.SOUTH);
      
      pNorth.add(logo);
      pNorth.add(menuName);
      
      pSouth.add(button1);
      pSouth.add(button2);
      pSouth.add(button3);
      pSouth.add(label1);
      pSouth.add(label2);
      pSouth.add(label3);
      
      setLayout(null);
      setTitle("Select_Side_Drink");
      setBounds(510,0,900,1040);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   public static void main(String[] args) {
      new kiosk6();
   }
}