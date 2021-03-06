package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;

public class Pos_TakeOut_PaymentPage extends JFrame {
//    Connection con = null;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    private void connect() {
//  	  try {
//  		  Class.forName("oracle.jdbc.driver.OracleDriver");
//  		  String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//  		  
//  		  con = DriverManager.getConnection(url, "fastfood", "fastfood!@");
//  		  System.out.println();
//  	  } catch(Exception e) {
//  		  System.out.println("????");
//  	  }
//    }
//    
//   public void select() {
//	   try {
//		   String sql = "select * from payment_list";
//		   pstmt = con.prepareStatement(sql);
//		   rs = pstmt.executeQuery();
//		   
//		   while(rs.next()) {
//			   String paymenttype = rs.getString("paymenttype");
//			   String payment_idx = rs.getString("payment_idx");
//			   String payment_price = rs.getString("payment_price");
//			   String order_idx = rs.getString("order_idx");
//			   
//			   Object data[] = {paymenttype, payment_idx, payment_price, order_idx};
//			   frame.addRow(data);
//			   
//		   }
//		   
//	   }catch(Exception e) {
//		   System.out.println("????");
//	   }
//   }
   public static void main(String[] args) {
      
   
      
      JFrame frame = new JFrame("????â");

      Font fontsize60 = new Font("???? ????", Font.PLAIN, 60);
      Font fontsize20 = new Font("???? ????", Font.PLAIN, 20);

      JLabel label = new JLabel("<Take-out>");
      label.setFont(fontsize60);
      frame.add(label);
      label.setBounds(80, 10, 350, 100);

      JButton orderaddBtn = new JButton("?߰??ֹ?");
      orderaddBtn.setFont(fontsize20);
      orderaddBtn.setBounds(70, 120, 150, 100);
      frame.add(orderaddBtn);

      JButton ordercancelBtn = new JButton("??ü????");
      ordercancelBtn.setFont(fontsize20);
      ordercancelBtn.setBounds(250, 120, 150, 100);
      frame.add(ordercancelBtn);

      JButton pay_card = new JButton("ī??????");
      pay_card.setFont(fontsize20);
      pay_card.setBounds(70, 230, 330, 100);
      frame.add(pay_card);

      JButton pay_cash = new JButton("???ݰ???");
      pay_cash.setFont(fontsize20);
      pay_cash.setBounds(70, 340, 330, 100);
      frame.add(pay_cash);

      JButton pay_coupon = new JButton("????????");
      pay_coupon.setFont(fontsize20);
      pay_coupon.setBounds(70, 450, 330, 100);
      frame.add(pay_coupon);
      
      
      // ?ֹ? ??ȣ
      Label orderlabel= new Label();
      
      orderlabel.setText("                 ?ֹ???ȣ");
      orderlabel.setBackground(new Color(0x00769E));
      orderlabel.setForeground(Color.white);
      orderlabel.setFont(fontsize20);
     orderlabel.setBounds(600, 115, 300, 40);
     
     frame.add(orderlabel);
     
     //?Ǹž?
      Label saleslabel= new Label();
      
      saleslabel.setText("      ?Ǹž?");
      saleslabel.setBackground(new Color(0x00769E));
      saleslabel.setForeground(Color.white);
      saleslabel.setFont(fontsize20);
      saleslabel.setBounds(600, 350, 140, 40);
     
     frame.add(saleslabel);
     
     //???ξ?
     Label discountlabel= new Label();
     
     discountlabel.setText("      ???ξ?"); 
     discountlabel.setBackground(new Color(0x00769E));
      discountlabel.setForeground(Color.white);
      discountlabel.setFont(fontsize20);
      discountlabel.setBounds(600, 390, 140, 40);
     
     frame.add(discountlabel);
     
     //?հ?
     Label totallabel= new Label();
     totallabel.setText("        ?հ?");
     
     totallabel.setBackground(new Color(0x00769E));
     totallabel.setForeground(Color.white);
     totallabel.setFont(fontsize20);
     totallabel.setBounds(600, 430, 140, 40);
     
     frame.add(totallabel);
     //----------------------------------------------------
     //?Ǹžװ? ????? ????
      Label saleslabel2= new Label();
      
      saleslabel2.setText("      ");
      saleslabel2.setBackground(new Color(0xCCFFFF));
      saleslabel2.setForeground(Color.white);
      saleslabel2.setFont(fontsize20);
      saleslabel2.setBounds(740, 350, 160, 40);
     
     frame.add(saleslabel2);
     
     //???ξװ? ????? ????
     Label discountlabel2= new Label();
     
     discountlabel2.setText("      "); 
     discountlabel2.setBackground(new Color(0xCCFFFF));
      discountlabel2.setForeground(Color.white);
      discountlabel2.setFont(fontsize20);
      discountlabel2.setBounds(740, 390, 160, 40);
     
     frame.add(discountlabel2);
     
     //?հ谪 ????? ????
     Label totallabel2= new Label();
     totallabel2.setText("       ");
     //
     totallabel2.setBackground(new Color(0xCCFFFF));
     totallabel2.setForeground(Color.white);
     totallabel2.setFont(fontsize20);
     totallabel2.setBounds(740, 430, 160, 40);
     
     frame.add(totallabel2);

       
  // ?ֹ? ???? ???? ????(?׽?Ʈ??)
  		ArrayList<Order> orderlist = new ArrayList<>();				
  		ArrayList<PsList> psList = new ArrayList<>();
  		String sql = "select * from menu";
  		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
  		for (int i = 0; i < 10; i++) {
  			int cnt = (int) (Math.random() * 10) + 1;
  			int price = (int) (Math.random() * 5) + 1;
  			price *= 1000;
  			orderlist.add(new Order(menuList.get((int)(Math.random() * menuList.size())), cnt, (int)(Math.random() * 2)));
  		}
      // ?޴? ???? ?ܰ? ?ݾ? ???̺?
//      String[][] rowData = {
//            {"  ?޴?", "  ????", "  ?ܰ?", "  ?ݾ?"},
//            {"", "", "", ""},
//            {"", "", "", ""},
//            {"", "", "", ""},
//            {"", "", "", ""},
//      };
      String[][] rowData = new String[orderlist.size()][4];
      
//      for(int i = 0; i < orderlist.size(); i++) {
//         rowData[i][0] = orderlist.get(i).getMenu();
//         rowData[i][1] = orderlist.get(i).getMenunum().toString();
//         rowData[i][2] = orderlist.get(i).getPrice().toString();
//         rowData[i][3] = orderlist.get(i).getSumprice().toString();
//               
//      }
      
      String[] columnNames = {"Menu Name", "Quantity", "UnitPrice", "Price"};
      
      JTable table = new JTable(rowData, columnNames);
      
      JScrollPane scrollPane = new JScrollPane(table);
      
      table.setRowHeight(40);
      table.setFont(fontsize20);
      scrollPane.setBounds(600, 150, 300, 200);
      
      frame.add(scrollPane);
      

      
      //???????? ???? ?? ?ƴϿ? ??ư ?׼? ??????
      pay_cash.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_cash, "???????? ???? ?Ͻðڽ??ϱ??",
                  "???? Ȯ??", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.CLOSED_OPTION) {
                // ?? ?ƴϿ? ???? ???? ???̾??α? â?? ???? ????
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ???? ?????? ????
               }
                   
               else {
                  // ?ƴϿ??? ?????? ????
               }
                   
         }
      });
      
    //ī???? ???? ?? ?ƴϿ? ??ư ?׼? ??????
      pay_card.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_card, "ī???? ???? ?Ͻðڽ??ϱ??",
                  "???? Ȯ??", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.CLOSED_OPTION) {
                // ?? ?ƴϿ? ???? ???? ???̾??α? â?? ???? ????
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ???? ?????? ????
               }
                   
               else {
                  // ?ƴϿ??? ?????? ????
               }
                   
         }
      });
      
      //???????? ???? ?? ?ƴϿ? ??ư ?׼? ??????
      pay_coupon.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(pay_coupon, "???????? ???? ?Ͻðڽ??ϱ??",
                  "???? Ȯ??", JOptionPane.YES_NO_OPTION);

               if (result == JOptionPane.CLOSED_OPTION) {
                // ?? ?ƴϿ? ???? ???? ???̾??α? â?? ???? ????
                  
               }
                   
               else if (result == JOptionPane.YES_OPTION) {
                  // ???? ?????? ????
               }
                   
               else {
                  // ?ƴϿ??? ?????? ????
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
