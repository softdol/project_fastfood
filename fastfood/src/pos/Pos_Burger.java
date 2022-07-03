package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import manager.component.ManagerCP;
import manager.sales.Pos_PaymentPageSe;
import pos.ActionListener.SubCateActionListener;

public class Pos_Burger extends JFrame {
      
   MenuListPanel item;
   public ArrayList<Order> orderlist;
   Object[] orderF;
   Object qty;
   Pos_Burger main;
   int sum;
   
   OrderListPanel orderTable;
   
   
   public void clearList() {
      orderlist = new ArrayList<>();
      orderTable.dfTable.setRowCount(0);
      sum = 0;
      orderTable.saleslabel2.setText("0");
      orderTable.totallabel2.setText("0");
   }
   
   public void setOrderlist( ) {
      // 테이블 초기화 꼭 넣어두기! 
      
      orderTable.dfTable.setRowCount(0);
      sum = 0;
      int count = 1;
      
      for(Order o : orderlist) {
         System.out.println(o.getMenu_name() + " " + o.getOrder_quantity() + " " + o.getOrder_price() + " " + o.getOrder_price_total() + " ");
         
         
         // 총합계 
          
         
           orderF[0] = o.getMenu_name();
           orderF[1] = o.getOrder_quantity();
           orderF[2] = o.getOrder_price();
           orderF[3] = o.getOrder_price_total();
           orderTable.dfTable.addRow(orderF);
           sum += o.getOrder_price_total();
           
            
      };
      
      orderTable.saleslabel2.setText(ManagerCP.viewWon(sum));
      orderTable.totallabel2.setText(ManagerCP.viewWon(sum));
      
   }
   

   
   public void viewMenuList(int iCate) {
      System.out.println(iCate);
      item.removeAll();      
      item.revalidate();
      item.repaint();
      item.add(new MenuListPanel(iCate,this));
   }
   

   
   
   public Pos_Burger() {
      super("메인 포스기");
      this.main = this;
      orderlist = new ArrayList<>();
      orderF = new Object[4];

      
      JPanel menu = new JPanel();
      JPanel order = new JPanel();
      
      LayoutManager manager = new GridLayout(8,5,1,1);
      
         
      
      // 카테고리도 db 통해서 불러올 예정 
      String[] bigcate = { "BURGER","DRINK","SIDE","DESSERT", "SET", "", "" };
      
      
      // 주문번호 창 패널
      order.setLayout(null);
      order.setBounds(20, 100, 360, 480);      
   
      
      // 아이템 패널   
      item = new MenuListPanel(1,this);
      
      
      // 메뉴 카테고리 패널   
      menu.setLayout(null);
      menu.setLocation(10,0);
      menu.setSize(850, 120);
      menu.setBackground(null);
      
      //ArrayList<Category> cateList =
      //sql = "select * from meun_category ";
      
      // 카테고리 버튼 추가 
      for (int i = 0; i < 5; ++i) {
         JButton bigMenu = new JButton(bigcate[i]);
         //idx =i + 1; 
         bigMenu.addActionListener(new SubCateActionListener(this, i + 1));
         bigMenu.setFont(new Font("Kristen ITC", Font.BOLD,18));
         bigMenu.setForeground(new Color(0x2F4858)); // 글꼴 색 변경
         bigMenu.setBorder(new LineBorder(Color .white)); // 외곽선 변경
         bigMenu.setBackground(new Color(0xD9EDDF)); // 배경색 
         bigMenu.setBounds(8+(40*(i*3)),30 ,120,60);
         menu.add(bigMenu);
         
      }
      
      
      
      // 관리자 이미지 추가
      String managerPath = "pos_image/managerBtn.png";
      Image managerImage = new ImageIcon(managerPath).getImage();
      
      // 관리자 버튼 추가
      JButton managerBtn = new JButton(new ImageIcon(managerImage.getScaledInstance(100, 100, managerImage.SCALE_SMOOTH)));
      managerBtn.setBounds(865,480,100,100);
      
      // 로고 이미지 추가 
      String logoPath = "pos_image/logo.png";
      Image logoImage = new ImageIcon(logoPath).getImage();
      
      // 로고 버튼 추가 
      JButton logoBtn = new JButton(new ImageIcon(logoImage.getScaledInstance(120, 130, logoImage.SCALE_SMOOTH)));
      logoBtn.setBounds(860,20,120,130);
      logoBtn.setBorder(new LineBorder(Color .white));
      
      
      //JPanel jpOrder = new JPanel();
      //jpOrder.setLayout(null);
      //jpOrder.setBounds(0, 0, 360, 480);
      orderTable = new OrderListPanel(this);
      
      //jpOrder.add(orderTable);
      //add(jpOrder);
      add(orderTable);
      
      JButton minus = new JButton("한줄 취소");
      minus.setBounds(865,170,100,50);
      minus.addActionListener(new ActionListener() {
         
            @Override
         public void actionPerformed(ActionEvent e) {
            JButton minus = (JButton)e.getSource();
            //DefaultTableModel m = (DefaultTableModel)table.getModel();
            if (orderTable.table.getSelectedRow() == -1) {
               
               JOptionPane.showMessageDialog(null, "행을 클릭해주세요");
               return;
            }
            //m.removeRow(table.getSelectedRow());
            orderlist.remove(orderTable.table.getSelectedRow());
            setOrderlist();
         }
      });
      
      JButton all_minus = new JButton("전체 취소");
      all_minus.setBounds(865,245,100,50);
      all_minus.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            //JButton all_minus = (JButton)e.getSource();
            
            orderTable.dfTable.setRowCount(0);
            orderlist.removeAll(orderlist);
            orderTable.saleslabel2.setText("0");
            orderTable.totallabel2.setText("0");
   
         }
      });
      
      JButton in = new JButton("Eat - IN ");
      in.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new Pos_PaymentPageSe(orderlist, 'E',main);
               //new Pos_PaymentPageSe(orderlist, 'T');
            
         }
      });
      in.setBounds(865,320,100,50);
      
      JButton out = new JButton("Take - Out");
      out.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            new Pos_PaymentPageSe(orderlist, 'T',main);
            
         }
      });
      out.setBounds(865,400,100,50);
      
      
      JScrollPane scPane = new JScrollPane(item, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       scPane.getVerticalScrollBar().setUnitIncrement(16);
         
       scPane.setBounds(400,120,455,460);
            
       
   
      
      
      
      add(menu);
      add(order);
      add(managerBtn);
      //add(item);
      add(minus);
      add(all_minus);
      add(in);
      add(out);
      add(logoBtn);
      add(scPane);
      



      
      getContentPane().setBackground(Color.white);
      setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setBounds(250, 50, 1000, 650);
       setVisible(true);
         
      
   }
   
      

   



   public static void main(String[] args) {
      new Pos_Burger();
   }
}