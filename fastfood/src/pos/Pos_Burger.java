package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Pos_Burger extends JFrame {


	
	Pos_Burger() {
		super("메인 포스기");
		
		JPanel menu = new JPanel();
		JPanel order = new JPanel();
		JPanel item = new JPanel();
		
		
		LayoutManager manager = new GridLayout(8,5,1,1);
		
			
		
		// 카테고리도 db 통해서 불러올 예정 
		String[] bigcate = { "BURGER","SET","HOT","SALE", "SIDE", "DRINK", "DESSERT" };
		
		// 메뉴 카테고리 패널	
		menu.setLayout(null);
		menu.setLocation(10,0);
		menu.setSize(850, 120);
		menu.setBackground(null);
		
		
		// 주문번호 창 패널
		order.setLayout(null);
		order.setBounds(20, 100, 360, 480);		
	
		
		// 아이템 패널
		item.setLayout(manager);
		item.setBackground(new Color(0xD9EDDF));
		item.setBounds(400,120,455,460);
		
		for (int i = 0; i < 30; ++i) {
			JButton itemBtn = new JButton();
			itemBtn.setBounds(10, 10, 10, 10);
			itemBtn.setText("버거이름" + i);
			item.add(itemBtn);	
				
		}
		
		
		// 카테고리 버튼 추가 
		for (int i = 0; i < bigcate.length; ++i) {
			JButton bigMenu = new JButton(bigcate[i]);
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
		
		
		
		JPanel order_number = new JPanel();
		JLabel order_index = new JLabel("< 주문 번호 > ");
		// 주문번호 db 인덱스를 통해서 가져올 예정 
		
		order_number.setBackground(new Color(0x00769E));
		order_number.setBounds(0,0,400,85);
			
		order_index.setBounds(80,0, 400,100 );
		order_index.setFont(new Font("맑은 고딕", Font.BOLD,30));
		order_index.setForeground(Color.white);

	
		
		JPanel order_table = new JPanel();
		order_table.setBounds(0,80,400,475);
				
		String[] columns = new String[] {"메뉴", "수량", "단가", "금액"};
		Object[][] data  = new Object[][] {
			{"디럭스버거", "1", "5000", "5000"},
			{"상하이버거", "2", "10000", "20000"}
		};
		
		JTable table = new JTable(data,columns);
		table.setPreferredScrollableViewportSize(new Dimension(400,250));

		
		table.setFillsViewportHeight(true);
		
		order_table.add(new JScrollPane(table));
		
		JButton minus = new JButton("하나 취소");
		minus.setBounds(865,170,100,50);
		
		JButton all_minus = new JButton("전체 취소");
		all_minus.setBounds(865,245,100,50);
		
		JButton in = new JButton("Eat - IN ");
		in.setBounds(865,320,100,50);
		
		JButton out = new JButton("Take - Out");
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
	
		

	



	public static void main(String[] args) {
		new Pos_Burger();
	}
}
