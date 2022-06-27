package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Pos_EatIn_PaymentPage extends JFrame {
  
         
   public static void main(String[] args) {
      
     String[] str = {"��", "�ƴϿ�"};
      JFrame frame = new JFrame("����â");

      Font fontsize60 = new Font("���� ���", Font.PLAIN, 60);
      Font fontsize20 = new Font("���� ���", Font.PLAIN, 20);

      JLabel label = new JLabel("<Eat-In>");
      label.setFont(fontsize60);
      frame.add(label);
      label.setBounds(115, 10, 300, 100);

      JButton orderaddBtn = new JButton("�߰��ֹ�");
      orderaddBtn.setFont(fontsize20);
      orderaddBtn.setBounds(70, 120, 150, 100);
      frame.add(orderaddBtn);

      JButton ordercancelBtn = new JButton("��ü���");
      ordercancelBtn.setFont(fontsize20);
      ordercancelBtn.setBounds(250, 120, 150, 100);
      frame.add(ordercancelBtn);

      JButton pay_card = new JButton("ī�����");
      pay_card.setFont(fontsize20);
      pay_card.setBounds(70, 230, 330, 100);
      frame.add(pay_card);

      JButton pay_cash = new JButton("���ݰ���");
      pay_cash.setFont(fontsize20);
      pay_cash.setBounds(70, 340, 330, 100);
      frame.add(pay_cash);

      JButton pay_coupon = new JButton("��������");
      pay_coupon.setFont(fontsize20);
      pay_coupon.setBounds(70, 450, 330, 100);
      frame.add(pay_coupon);
      
      
      // �ֹ� ��ȣ
      Label orderlabel= new Label();
      
      orderlabel.setText("                 �ֹ���ȣ");
      orderlabel.setBackground(new Color(0x00769E));
      orderlabel.setForeground(Color.white);
      orderlabel.setFont(fontsize20);
     orderlabel.setBounds(600, 115, 300, 40);
     
     frame.add(orderlabel);
     
     //�Ǹž�
      Label saleslabel= new Label();
      
      saleslabel.setText("      �Ǹž�");
      saleslabel.setBackground(new Color(0x00769E));
      saleslabel.setForeground(Color.white);
      saleslabel.setFont(fontsize20);
      saleslabel.setBounds(600, 350, 140, 40);
     
     frame.add(saleslabel);
     
     //���ξ�
     Label discountlabel= new Label();
     
     discountlabel.setText("      ���ξ�"); 
     discountlabel.setBackground(new Color(0x00769E));
      discountlabel.setForeground(Color.white);
      discountlabel.setFont(fontsize20);
      discountlabel.setBounds(600, 390, 140, 40);
     
     frame.add(discountlabel);
     
     //�հ�
     Label totallabel= new Label();
     totallabel.setText("        �հ�");
     
     totallabel.setBackground(new Color(0x00769E));
     totallabel.setForeground(Color.white);
     totallabel.setFont(fontsize20);
     totallabel.setBounds(600, 430, 140, 40);
     
     frame.add(totallabel);
     //----------------------------------------------------
     //�Ǹžװ� ���� ��
      Label saleslabel2= new Label();
      
      saleslabel2.setText("      ");
      saleslabel2.setBackground(new Color(0xCCFFFF));
      saleslabel2.setForeground(Color.white);
      saleslabel2.setFont(fontsize20);
      saleslabel2.setBounds(740, 350, 160, 40);
     
     frame.add(saleslabel2);
     
     //���ξװ� ���� ��
     Label discountlabel2= new Label();
     
     discountlabel2.setText("      "); 
     discountlabel2.setBackground(new Color(0xCCFFFF));
      discountlabel2.setForeground(Color.white);
      discountlabel2.setFont(fontsize20);
      discountlabel2.setBounds(740, 390, 160, 40);
     
     frame.add(discountlabel2);
     
     //�հ谪 ���� ��
     Label totallabel2= new Label();
     totallabel2.setText("       ");
     
     totallabel2.setBackground(new Color(0xCCFFFF));
     totallabel2.setForeground(Color.white);
     totallabel2.setFont(fontsize20);
     totallabel2.setBounds(740, 430, 160, 40);
     
     frame.add(totallabel2);

       
       
      // �޴� ���� �ܰ� �ݾ� ���̺�
      String[][] rowData = {
            {"  �޴�", "  ����", "  �ܰ�", "  �ݾ�"},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
      };
      String[] columnNames = {"Menu Name", "Quantity", "UnitPrice", "Price"};
      
      JTable table = new JTable(rowData, columnNames);
      
      JScrollPane scrollPane = new JScrollPane(table);
      
      table.setRowHeight(40);
      table.setFont(fontsize20);
      table.setBounds(600, 150, 300, 200);
      
      frame.add(table);
      

      
      //�������� ���� �� �ƴϿ� ��ư �׼� ������
      pay_cash.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_cash, "�������� ���� �Ͻðڽ��ϱ�?",
                  "���� Ȯ��", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.CLOSED_OPTION) {
                // �� �ƴϿ� ���� ���� ���̾�α� â�� ���� ���
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ���� ������ ���
               }
                   
               else {
                  // �ƴϿ��� ������ ���
               }
                   
         }
      });
      
    //ī��� ���� �� �ƴϿ� ��ư �׼� ������
      pay_card.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_card, "ī��� ���� �Ͻðڽ��ϱ�?",
                  "���� Ȯ��", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.CLOSED_OPTION) {
                // �� �ƴϿ� ���� ���� ���̾�α� â�� ���� ���
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ���� ������ ���
               }
                   
               else {
                  // �ƴϿ��� ������ ���
               }
                   
         }
      });
      
      //�������� ���� �� �ƴϿ� ��ư �׼� ������
      pay_coupon.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_coupon, "�������� ���� �Ͻðڽ��ϱ�?",
                  "���� Ȯ��", JOptionPane.YES_NO_OPTION);

               if (result == JOptionPane.CLOSED_OPTION) {
                // �� �ƴϿ� ���� ���� ���̾�α� â�� ���� ���
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ���� ������ ���
               }
                   
               else {
                  // �ƴϿ��� ������ ���
               }
                   
         }
      });
      
      
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setBounds(250, 50, 1000, 650);
      frame.setVisible(true);
   }

}