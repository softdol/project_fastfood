package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import database.manager.ReturnModel;
import database.model.PsList;
import manager.component.ManagerCP;

public class OrderPanel extends JPanel {
	public JTable table;
	public Label saleslabel2;
	public Label totallabel2;
	public DefaultTableModel dfTable;
	Pos_Burger main;
	JComboBox<String> dateSubList;
	int sum;
	
	public void viewOrderlist(ArrayList<Order> orderList) {
		// ���̺� �ʱ�ȭ �� �־�α�!

		dfTable.setRowCount(0);
		sum = 0;

		for (Order o : orderList) {
			// ���հ�
			Object[] orderN =new Object[4];
			orderN[0] = o.getMenu_name();
			orderN[1] = o.getOrder_quantity();
			orderN[2] = o.getOrder_price();
			orderN[3] = o.getOrder_price_total();
			dfTable.addRow(orderN);

			sum += o.getOrder_price_total();

		}

		saleslabel2.setText(ManagerCP.viewWon(sum));
		totallabel2.setText(ManagerCP.viewWon(sum));

	}
	
	

	public OrderPanel(Pos_Burger main) {
		this.main = main;

		// �ֹ���ȣ â �г�
		setLayout(null);
		setBounds(0, 0, 360, 480);
		setBackground(Color.black);

		JPanel order_number = new JPanel();
		JLabel order_index = new JLabel("  < �ֹ�Ȯ�� > ", 0);
		// �ֹ���ȣ db �ε����� ���ؼ� ������ ����

		order_number.setBackground(new Color(0x00769E));
		order_number.setBounds(0, 0, 360, 85);

		order_index.setBounds(0, 0, 360, 40);
		order_index.setFont(new Font("���� ���", Font.BOLD, 30));
		order_index.setForeground(Color.white);
		
		
		JComboBox<String> dateList = new JComboBox<>();
		dateList.addItem("--��¥--");
		String sqlSelList = "select TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') from payment_list group by TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') order by TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') desc";
		ArrayList<PsList> psList = new ArrayList<>();
		ArrayList<String> paymentDateList = ReturnModel.selStringList(sqlSelList, psList);
		//System.out.println(paymentDateList.size());
		
		for (String s : paymentDateList) {
			dateList.addItem(s);
		}
		
		dateList.setBounds(10, order_index.getY() + order_index.getHeight() + 5, 100, 35);
		add(dateList);
		
		dateSubList = new JComboBox<>();
		dateSubList.addItem("--�ֹ� ��ȣ--");
		
		dateSubList.setBounds(dateList.getX() + dateList.getWidth() + 10, dateList.getY(), 100, 35);
		add(dateSubList);
		
		dateList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox thisCb = (JComboBox)e.getSource();
				if(thisCb.getSelectedIndex() != 0) {
					String seldate = thisCb.getSelectedItem().toString();
					//System.out.println(seldate);
					dateSubList.removeAllItems();
					String sql = "select PAYMENT_IDX from payment_list where TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') = ?";
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('S', seldate));
					ArrayList<String> paymentIdxList = ReturnModel.selStringList(sql, psList);					
					dateSubList.addItem("--�ֹ� ��ȣ--");
					for(String s : paymentIdxList) {
						dateSubList.addItem(s);
					}
				}
			}
		});
		
		dateSubList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				JComboBox<String> thisCb = (JComboBox<String>)e.getSource();
				if(thisCb.getSelectedItem() != null) {
					if(thisCb.getSelectedIndex() != 0) {
					String selIdx = thisCb.getSelectedItem().toString();
					String sql = "select * from order_list where PAYMENT_IDX = ?";
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('I', selIdx));
					
					ArrayList<Order> orderList = ReturnModel.selOrderList(sql, psList);
					
					viewOrderlist(orderList);
					}
				}
			}
		});

		//JPanel order_table = new JPanel();
		//order_table.setBounds(0, 80, 360, 50);
		String[] columns = new String[] { "�޴�", "����", "�ܰ�", "�ݾ�" };
		Object[][] data = new Object[][] { { "", "", "", "" }, { "", "", "", "" } };

		dfTable = new DefaultTableModel(columns, 0);
		table = new JTable(dfTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ���� ����

		table.setPreferredScrollableViewportSize(new Dimension(400, 250));
		table.setFillsViewportHeight(true);

		JScrollPane scPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scPane.getVerticalScrollBar().setUnitIncrement(16);		
		scPane.setBounds(0, 85, 360, 274);
		add(scPane);

		// �Ǹž�
		Label saleslabel = new Label();

		saleslabel.setText("      �Ǹž�");
		saleslabel.setBackground(new Color(0x00769E));
		saleslabel.setForeground(Color.white);
		saleslabel.setBounds(0, 358, 180, 40);
		saleslabel.setFont(new Font("���� ���", Font.BOLD, 20));

		// ���ξ�
		Label discountlabel = new Label();

		discountlabel.setText("      ���ξ�");
		discountlabel.setBackground(new Color(0x00769E));
		discountlabel.setForeground(Color.white);
		discountlabel.setBounds(0, 398, 180, 40);
		discountlabel.setFont(new Font("���� ���", Font.BOLD, 20));

		// �հ�
		Label totallabel = new Label();
		totallabel.setText("      �հ�");
		totallabel.setBackground(new Color(0x00769E));
		totallabel.setForeground(Color.white);
		totallabel.setBounds(0, 438, 180, 40);
		totallabel.setFont(new Font("���� ���", Font.BOLD, 20));

		// ----------------------------------------------------
		// �Ǹžװ� ���� ��
		saleslabel2 = new Label("0");

		// saleslabel2.setText(String.valueOf(sum));
		saleslabel2.setBackground(new Color(0xCCFFFF));
		saleslabel2.setBounds(180, 358, 180, 40);
		saleslabel2.setFont(new Font("���� ���", Font.BOLD, 25));

		// ���ξװ� ���� ��
		Label discountlabel2 = new Label("0");
		discountlabel2.setBackground(new Color(0xCCFFFF));
		discountlabel2.setBounds(180, 398, 180, 40);
		discountlabel2.setFont(new Font("���� ���", Font.BOLD, 25));

		// �հ谪 ���� ��
		totallabel2 = new Label("0");
		// totallabel2.setText(String.valueOf(sum));
		totallabel2.setBackground(new Color(0xCCFFFF));
		totallabel2.setBounds(180, 438, 180, 40);
		totallabel2.setFont(new Font("���� ���", Font.BOLD, 25));

		add(saleslabel);
		add(discountlabel);
		add(totallabel);
		add(saleslabel2);
		add(discountlabel2);
		add(totallabel2);
		add(order_index);
		add(order_number);
		//add(order_table);

	}
}