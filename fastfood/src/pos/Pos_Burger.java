package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;

public class Pos_Burger extends JFrame {


   
   Pos_Burger() {
      super("���� ������");
      
      JPanel menu = new JPanel();
      JPanel order = new JPanel();
      JPanel item = new JPanel();
      
      
      
      
   
      
      
      String[] bigcate = { "BURGER","SET","HOT","SALE", "SIDE", "DRINK", "DESSERT" };
      
      // �޴� ī�װ� �г�   
      menu.setLayout(null);
      menu.setLocation(10,0);
      menu.setSize(850, 120);
      menu.setBackground(null);
      
      
      // �ֹ���ȣ â �г�
      order.setLayout(null);
      order.setBounds(20, 100, 360, 480);      
   
      
      
   
      
      ArrayList<String> burger = new ArrayList<>();
      JButton itemBtn;
      
      
      
      String sql = "SELECT menu_name FROM menu WHERE menu_category_idx = ?"; 
      ArrayList<PsList> psList = new ArrayList<>();
      psList.add(new PsList('I', String.valueOf(1)));
      
      ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
      
      /*
     try (
            Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
         
         ) {
         
            pstmt.setInt(1, 1);
            
            try(
                  ResultSet rs = pstmt.executeQuery()) {
                  
            
                     while (rs.next()) {
                        burger.add(rs.getString("menu_name"));
                        System.out.println(rs.getString("menu_name"));
                     }
                     
                     for( int i = 0; i < burger.size(); ++i ) {
                        itemBtn = new JButton(burger.get(i));
                        
                        itemBtn.setBounds(i * 150,100, 130, 50);
                        
                        item.add(itemBtn);
                     }
//                     
//                     // ��ư �߰� 
//                 	 for(int i=0;i<itemBtn.length;i++) {
//                 		final int index =i;
//                 		itemBtn[i].addActionListener(new ActionListener() {
//               			@Override
//               			public void actionPerformed(ActionEvent e) {
//               				JButton MBtn = (JButton)e.getSource();
//               				DefaultTableModel m = (DefaultTableModel)table.getModel();
//               				m.addRow(new Object[]{menu[index],count,price[index]});
//               			}
//               		});
//               	}
            }
            
            
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      */
      
      
      int a = burger.size();
      
      int b = (a/3) + 1;
      
      LayoutManager manager = new GridLayout(b, 3, 10, 3);
      
      // ������ �г�
      item.setLayout(manager);
      item.setBackground(new Color(0xD9EDDF));
      item.setBounds(400,120,455,460);
            
      
      
      
      // ī�װ� ��ư �߰� 
      for (int i = 0; i < bigcate.length; ++i) {
         JButton bigMenu = new JButton(bigcate[i]);
         bigMenu.setFont(new Font("Kristen ITC", Font.BOLD,18));
         bigMenu.setForeground(new Color(0x2F4858)); // �۲� �� ����
         bigMenu.setBorder(new LineBorder(Color .white)); // �ܰ��� ����
         bigMenu.setBackground(new Color(0xD9EDDF)); // ���� 
         bigMenu.setBounds(8+(40*(i*3)),30 ,120,60);
         menu.add(bigMenu);
         
      }   
      
         
      
      // ������ �̹��� �߰�
      String managerPath = "pos_image/managerBtn.png";
      Image managerImage = new ImageIcon(managerPath).getImage();
      
      // ������ ��ư �߰�
      JButton managerBtn = new JButton(new ImageIcon(managerImage.getScaledInstance(100, 100, managerImage.SCALE_SMOOTH)));
      managerBtn.setBounds(865,480,100,100);
      
      // �ΰ� �̹��� �߰� 
      String logoPath = "pos_image/logo.png";
      Image logoImage = new ImageIcon(logoPath).getImage();
      
      // �ΰ� ��ư �߰� 
      JButton logoBtn = new JButton(new ImageIcon(logoImage.getScaledInstance(120, 130, logoImage.SCALE_SMOOTH)));
      logoBtn.setBounds   (860,20,120,130);
      logoBtn.setBorder(new LineBorder(Color .white));
      
       
      OrderIndex lastnumber = new OrderIndex();
      
      JPanel order_number = new JPanel();
      JLabel order_index = new JLabel("< �ֹ� > ");
      

//      
//      order_index.setText(order_number2);
//       
      
      
      
      order_number.setBackground(new Color(0x00769E));
      order_number.setBounds(0,0,400,85);
         
      order_index.setBounds(80,0, 400,100 );
      order_index.setFont(new Font("���� ���", Font.BOLD,30));
      order_index.setForeground(Color.white);

   
      
      JPanel order_table = new JPanel();
      order_table.setBounds(0,80,400,475);
            
      String[] columns = new String[] {"�޴�", "����", "�ܰ�", "�ݾ�"};
      Object[][] data = {{"�𷰽�����","1","1000","2000"}};
      
      JTable table = new JTable(data,columns);
      table.setPreferredScrollableViewportSize(new Dimension(400,250));

      
      table.setFillsViewportHeight(true);
      
      order_table.add(new JScrollPane(table));
      
      

// 	for(int i=0;i<burger.length; i++) {
// 		final int index =i;
//		itemBtn[i].addActionListener(new ActionListener() {
//			@Override
//				JButton itemBtn = (JButton)e.getSource();
// 				DefaultTableModel m = (DefaultTableModel)table.getModel();
//  				table.addRow(new Object[]{menu[index],count,price[index],count*price[index]});
// 			}
//  		});
//   });
     
      JButton minus = new JButton("�ϳ� ���");
      minus.setBounds(865,170,100,50);
      
//  	//�������
//		minus.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton minus = (JButton)e.getSource();
//				DefaultTableModel m = (DefaultTableModel)table.getModel();
//				
//				m.removeRow(table.getSelectedRow());
//			}
//		});
      
      JButton all_minus = new JButton("��ü ���");
      all_minus.setBounds(865,245,100,50);   
      
//  	  all_minus.addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton all_minus = (JButton)e.getSource();
//			DefaultTableModel m = (DefaultTableModel)table.getModel();
//			
//			m.setRowCount(0);
//			// ������ ���� ���ϱ�setText(String.valueOf(""));
//		}
//	});
//      
      JButton in = new JButton("Eat - IN ");
      in.setBounds(865,320,100,50);
      
//      in.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton MBtn = (JButton)e.getSource();
//				int rowCont = table.getRowCount();
//				int sum =0;
//				for(int i=0;i<rowCont;i++) {
//					sum += (int)table.getValueAt(i, 2);
//				}
//				tf.setText(String.valueOf(" �� �ݾ� : "+sum));
//				tf.setFont(new Font("�������", Font.BOLD, 40));
//			}
//		});
      
      JButton out = new JButton("Take - Out");
      out.setBounds(865,400,100,50);
      
//    out.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton MBtn = (JButton)e.getSource();
//				int rowCont = table.getRowCount();
//				int sum =0;
//				for(int i=0;i<rowCont;i++) {
//					sum += (int)table.getValueAt(i, 2);
//				}
//				tf.setText(String.valueOf(" �� �ݾ� : "+sum));
//				tf.setFont(new Font("�������", Font.BOLD, 40));
//			}
//		});
      
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
      order.add(order_index);
      order.add(order_number);
      order.add(order_table);
      
      


      
      getContentPane().setBackground(Color.white);
      setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setBounds(250, 50, 1000, 650);
       setVisible(true);
         
      
   }
   
      

   
//   



   public static void main(String[] args) {
      new Pos_Burger();
   }
}