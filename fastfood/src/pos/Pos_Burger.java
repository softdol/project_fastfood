package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import manager.component.ManagerCP;
import manager.sales.Pos_PaymentPageSe;
import pos.ActionListener.SubCateActionListener;

public class Pos_Burger extends JFrame {
	
	JTable table;
	Label saleslabel2;
	Label totallabel2;
	

	
	MenuListPanel item;
	public ArrayList<Order> orderlist;
	DefaultTableModel dfTable;
	Object[] orderF;
	Object qty;
	Pos_Burger main;
	int sum;
	class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	    	   String item = (String)event.getItem();
	    	   String selQ = String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
	    	   
	    	   if(!item.equals(selQ)) {
	    		   orderlist.get(table.getSelectedRow()).setTotalPrice(Integer.parseInt(item));
	    		   setOrderlist();
	    	   }
	       }
	    }
	}
	
	public void clearList() {
		orderlist = new ArrayList<>();
		dfTable.setRowCount(0);
		sum = 0;
		saleslabel2.setText("0");
		totallabel2.setText("0");
	}
	
	public void setOrderlist( ) {
		// 테이블 초기화 꼭 넣어두기! 
		
		dfTable.setRowCount(0);
		sum = 0;
		
		for(Order o : orderlist) {
			System.out.println(o.getMenu_name() + " " + o.getOrder_quantity() + " " + o.getOrder_price() + " " + o.getOrder_price_total() + " ");
		
			// 총합계 
			
			orderF[0] = o.getMenu_name();
	        orderF[1] = o.getOrder_quantity();
	        orderF[2] = o.getOrder_price();
	        orderF[3] = o.getOrder_price_total();
	        dfTable.addRow(orderF);
	       
	        sum += o.getOrder_price_total();
	        
	         
		};
		
		saleslabel2.setText(ManagerCP.viewWon(sum));
		totallabel2.setText(ManagerCP.viewWon(sum));
		
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
		
		
		
		JPanel order_number = new JPanel();
		JLabel order_index = new JLabel("  < 주문표 > ");
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
			{"", "", "", ""},
			{"", "", "", ""}
		};	
		
	
		dfTable = new DefaultTableModel(columns, 0);
		table = new JTable(dfTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일 선택
		
		table.setPreferredScrollableViewportSize(new Dimension(400,250));
		table.setFillsViewportHeight(true);
		
		order_table.add(new JScrollPane(table));
		
		TableColumn comm = table.getColumnModel().getColumn(1);
		
		JComboBox<String> jcCount = new JComboBox<>();
		for(int i = 1; i < 100; i++) {
			jcCount.addItem(String.valueOf(i));
		}
		jcCount.addItemListener(new ItemChangeListener());
		
		comm.setCellEditor(new DefaultCellEditor(jcCount));
		
		// 판매액
		Label saleslabel= new Label();
	    
	    saleslabel.setText("      판매액");
	    saleslabel.setBackground(new Color(0x00769E));
	    saleslabel.setForeground(Color.white);
	    saleslabel.setBounds(0,358,180, 40);
	    saleslabel.setFont(new Font("맑은 고딕", Font.BOLD,20));
	     

	     
	     //할인액
	    Label discountlabel= new Label();
	     
	    discountlabel.setText("      할인액"); 
	    discountlabel.setBackground(new Color(0x00769E));
	    discountlabel.setForeground(Color.white);
	    discountlabel.setBounds(0,398,180, 40);
	    discountlabel.setFont(new Font("맑은 고딕", Font.BOLD,20));
	     

	     
	     //합계
	    Label totallabel= new Label();
	    totallabel.setText("      합계");	     
	    totallabel.setBackground(new Color(0x00769E));
	    totallabel.setForeground(Color.white);
	    totallabel.setBounds(0,438,180, 40);
	    totallabel.setFont(new Font("맑은 고딕", Font.BOLD,20));
	     
	     //----------------------------------------------------
	     //판매액값 들어가는 라벨
	    saleslabel2= new Label();
	      
	    saleslabel2.setText(String.valueOf(sum));
	    saleslabel2.setBackground(new Color(0xCCFFFF));
	    saleslabel2.setBounds(180,358,180, 40);
	    saleslabel2.setFont(new Font("맑은 고딕", Font.BOLD,25));
	    
	     
	     //할인액값 들어가는 라벨
	     Label discountlabel2= new Label();	     
	     discountlabel2.setText("0 "); 
	     discountlabel2.setBackground(new Color(0xCCFFFF));
	     discountlabel2.setBounds(180,398,180, 40);
	     discountlabel2.setFont(new Font("맑은 고딕", Font.BOLD,25));
	     
	     
	     //합계값 들어가는 라벨
	     totallabel2= new Label();
	     totallabel2.setText(String.valueOf(sum));	     
	     totallabel2.setBackground(new Color(0xCCFFFF));
	     totallabel2.setBounds(180,438,180, 40);
	     totallabel2.setFont(new Font("맑은 고딕", Font.BOLD,25));

		
		
		JButton minus = new JButton("한줄 취소");
		minus.setBounds(865,170,100,50);
		minus.addActionListener(new ActionListener() {
			
				@Override
			public void actionPerformed(ActionEvent e) {
				JButton minus = (JButton)e.getSource();
				//DefaultTableModel m = (DefaultTableModel)table.getModel();
				if (table.getSelectedRow() == -1) {
					
					JOptionPane.showMessageDialog(null, "행을 클릭해주세요");
					return;
				}
				//m.removeRow(table.getSelectedRow());
				orderlist.remove(table.getSelectedRow());
				setOrderlist();
			}
		});
		
		JButton all_minus = new JButton("전체 취소");
		all_minus.setBounds(865,245,100,50);
		all_minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JButton all_minus = (JButton)e.getSource();
				
				dfTable.setRowCount(0);
				orderlist.removeAll(orderlist);
				saleslabel2.setText("0");
				totallabel2.setText("0");
	
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
		order.add(saleslabel);
		order.add(discountlabel);
		order.add(totallabel);
		order.add(saleslabel2);
		order.add(discountlabel2);
		order.add(totallabel2);
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