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
		// ���̺� �ʱ�ȭ �� �־�α�! 
		
		dfTable.setRowCount(0);
		sum = 0;
		
		for(Order o : orderlist) {
			System.out.println(o.getMenu_name() + " " + o.getOrder_quantity() + " " + o.getOrder_price() + " " + o.getOrder_price_total() + " ");
		
			// ���հ� 
			
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
		super("���� ������");
		this.main = this;
		orderlist = new ArrayList<>();
		orderF = new Object[4];

		
		JPanel menu = new JPanel();
		JPanel order = new JPanel();
		
		LayoutManager manager = new GridLayout(8,5,1,1);
		
			
		
		// ī�װ��� db ���ؼ� �ҷ��� ���� 
		String[] bigcate = { "BURGER","DRINK","SIDE","DESSERT", "SET", "", "" };
		
		
		// �ֹ���ȣ â �г�
		order.setLayout(null);
		order.setBounds(20, 100, 360, 480);		
	
		
		// ������ �г�	
		item = new MenuListPanel(1,this);
		
		
		// �޴� ī�װ� �г�	
		menu.setLayout(null);
		menu.setLocation(10,0);
		menu.setSize(850, 120);
		menu.setBackground(null);
		
		//ArrayList<Category> cateList =
		//sql = "select * from meun_category ";
		
		// ī�װ� ��ư �߰� 
		for (int i = 0; i < 5; ++i) {
			JButton bigMenu = new JButton(bigcate[i]);
			//idx =i + 1; 
			bigMenu.addActionListener(new SubCateActionListener(this, i + 1));
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
		logoBtn.setBounds(860,20,120,130);
		logoBtn.setBorder(new LineBorder(Color .white));
		
		
		
		JPanel order_number = new JPanel();
		JLabel order_index = new JLabel("  < �ֹ�ǥ > ");
		// �ֹ���ȣ db �ε����� ���ؼ� ������ ���� 
		
		order_number.setBackground(new Color(0x00769E));
		order_number.setBounds(0,0,400,85);
			
		order_index.setBounds(80,0, 400,100 );
		order_index.setFont(new Font("���� ���", Font.BOLD,30));
		order_index.setForeground(Color.white);

	
		
		JPanel order_table = new JPanel();
		order_table.setBounds(0,80,400,475);
				
		String[] columns = new String[] {"�޴�", "����", "�ܰ�", "�ݾ�"};
		Object[][] data  = new Object[][] {
			{"", "", "", ""},
			{"", "", "", ""}
		};	
		
	
		dfTable = new DefaultTableModel(columns, 0);
		table = new JTable(dfTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ���� ����
		
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
		
		// �Ǹž�
		Label saleslabel= new Label();
	    
	    saleslabel.setText("      �Ǹž�");
	    saleslabel.setBackground(new Color(0x00769E));
	    saleslabel.setForeground(Color.white);
	    saleslabel.setBounds(0,358,180, 40);
	    saleslabel.setFont(new Font("���� ���", Font.BOLD,20));
	     

	     
	     //���ξ�
	    Label discountlabel= new Label();
	     
	    discountlabel.setText("      ���ξ�"); 
	    discountlabel.setBackground(new Color(0x00769E));
	    discountlabel.setForeground(Color.white);
	    discountlabel.setBounds(0,398,180, 40);
	    discountlabel.setFont(new Font("���� ���", Font.BOLD,20));
	     

	     
	     //�հ�
	    Label totallabel= new Label();
	    totallabel.setText("      �հ�");	     
	    totallabel.setBackground(new Color(0x00769E));
	    totallabel.setForeground(Color.white);
	    totallabel.setBounds(0,438,180, 40);
	    totallabel.setFont(new Font("���� ���", Font.BOLD,20));
	     
	     //----------------------------------------------------
	     //�Ǹžװ� ���� ��
	    saleslabel2= new Label();
	      
	    saleslabel2.setText(String.valueOf(sum));
	    saleslabel2.setBackground(new Color(0xCCFFFF));
	    saleslabel2.setBounds(180,358,180, 40);
	    saleslabel2.setFont(new Font("���� ���", Font.BOLD,25));
	    
	     
	     //���ξװ� ���� ��
	     Label discountlabel2= new Label();	     
	     discountlabel2.setText("0 "); 
	     discountlabel2.setBackground(new Color(0xCCFFFF));
	     discountlabel2.setBounds(180,398,180, 40);
	     discountlabel2.setFont(new Font("���� ���", Font.BOLD,25));
	     
	     
	     //�հ谪 ���� ��
	     totallabel2= new Label();
	     totallabel2.setText(String.valueOf(sum));	     
	     totallabel2.setBackground(new Color(0xCCFFFF));
	     totallabel2.setBounds(180,438,180, 40);
	     totallabel2.setFont(new Font("���� ���", Font.BOLD,25));

		
		
		JButton minus = new JButton("���� ���");
		minus.setBounds(865,170,100,50);
		minus.addActionListener(new ActionListener() {
			
				@Override
			public void actionPerformed(ActionEvent e) {
				JButton minus = (JButton)e.getSource();
				//DefaultTableModel m = (DefaultTableModel)table.getModel();
				if (table.getSelectedRow() == -1) {
					
					JOptionPane.showMessageDialog(null, "���� Ŭ�����ּ���");
					return;
				}
				//m.removeRow(table.getSelectedRow());
				orderlist.remove(table.getSelectedRow());
				setOrderlist();
			}
		});
		
		JButton all_minus = new JButton("��ü ���");
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