package manager.sales;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.OjdbcConnection;
import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.component.ManagerCP;
import pos.Order;

public class Pos_PaymentPageSe extends JFrame {
	
	ArrayList<Order> orderlist;
	long sumPrice;
	public Pos_PaymentPageSe(ArrayList<Order> orderlist, char orderType) {
		this.orderlist = orderlist;
		
		String[] str = { "��", "�ƴϿ�" };
		setTitle("����â");

		Font fontsize60 = new Font("���� ���", Font.PLAIN, 60);
		Font fontsize20 = new Font("���� ���", Font.PLAIN, 20);

		String orderTitle = "<Take-out>";
		
		if(orderType == 'E') {
			orderTitle = "<Eat - IN>";
		}
		
		JLabel label = new JLabel(orderTitle);
		label.setFont(fontsize60);
		label.setBounds(80, 10, 350, 100);
		add(label);		

		JButton orderaddBtn = new JButton("�߰��ֹ�");
		orderaddBtn.setFont(fontsize20);
		orderaddBtn.setBounds(70, 120, 150, 100);
		add(orderaddBtn);

		JButton ordercancelBtn = new JButton("��ü���");
		ordercancelBtn.setFont(fontsize20);
		ordercancelBtn.setBounds(250, 120, 150, 100);
		add(ordercancelBtn);

		JButton pay_card = new JButton("ī�����");
		pay_card.setFont(fontsize20);
		pay_card.setBounds(70, 230, 330, 100);
		add(pay_card);

		JButton pay_cash = new JButton("���ݰ���");
		pay_cash.setFont(fontsize20);
		pay_cash.setBounds(70, 340, 330, 100);
		add(pay_cash);

		JButton pay_coupon = new JButton("��������");
		pay_coupon.setFont(fontsize20);
		pay_coupon.setBounds(70, 450, 330, 100);
		add(pay_coupon);

		// �ֹ� ��ȣ
		Label orderlabel = new Label();

		orderlabel.setText("                 �ֹ���ȣ");
		orderlabel.setBackground(new Color(0x00769E));
		orderlabel.setForeground(Color.white);
		orderlabel.setFont(fontsize20);
		orderlabel.setBounds(600, 115, 300, 40);

		//add(orderlabel);
		
		String[][] rowData = new String[orderlist.size()][4];
		sumPrice = 0;

		for (int i = 0; i < orderlist.size(); i++) {
			rowData[i][0] = orderlist.get(i).getMenu_name();
			rowData[i][1] = ManagerCP.viewWon(orderlist.get(i).getOrder_quantity());
			rowData[i][2] = ManagerCP.viewWon(orderlist.get(i).getOrder_price());
			rowData[i][3] = ManagerCP.viewWon(orderlist.get(i).getOrder_price_total());
			sumPrice += orderlist.get(i).getOrder_price_total();
		}

		String[] columnNames = { "�޴�", "����", "�ܰ�", "�ݾ�" };

		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);

		table.setRowHeight(40);
		table.setFont(fontsize20);
		scrollPane.setBounds(450, orderaddBtn.getY(), 500, 200);

		add(scrollPane);
		

		// �Ǹž�
		Label saleslabel = new Label();

		saleslabel.setText("      �Ǹž�");
		saleslabel.setBackground(new Color(0x00769E));
		saleslabel.setForeground(Color.white);
		saleslabel.setFont(fontsize20);
		saleslabel.setBounds(650, scrollPane.getY() + scrollPane.getHeight(), 140, 40);

		add(saleslabel);
		
		// �Ǹžװ� ���� ��
		JLabel saleslabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		saleslabel2.setOpaque(true);
		saleslabel2.setBackground(new Color(0xCCFFFF));
		saleslabel2.setForeground(Color.black);
		saleslabel2.setFont(fontsize20);
		saleslabel2.setBounds(saleslabel.getX() + saleslabel.getWidth(), saleslabel.getY(), 160, 40);

		add(saleslabel2);

		// ���ξ�
		Label discountlabel = new Label();

		discountlabel.setText("      ���ξ�");
		discountlabel.setBackground(new Color(0x00769E));
		discountlabel.setForeground(Color.white);
		discountlabel.setFont(fontsize20);
		discountlabel.setBounds(saleslabel.getX(), saleslabel.getY() + saleslabel.getHeight(), 140, 40);

		add(discountlabel);
		
		// ���ξװ� ���� ��
		JLabel discountlabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		discountlabel2.setOpaque(true);
		discountlabel2.setBackground(new Color(0xCCFFFF));
		discountlabel2.setForeground(Color.black);
		discountlabel2.setFont(fontsize20);
		discountlabel2.setBounds(saleslabel2.getX(), discountlabel.getY(), 160, 40);

		add(discountlabel2);

		// �հ�
		Label totallabel = new Label();
		totallabel.setText("        �հ�");

		totallabel.setBackground(new Color(0x00769E));
		totallabel.setForeground(Color.white);
		totallabel.setFont(fontsize20);
		totallabel.setBounds(saleslabel.getX(), discountlabel.getY() + discountlabel.getHeight(), 140, 40);

		add(totallabel);
		// ----------------------------------------------------
		
		// �հ谪 ���� ��
		JLabel totallabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		totallabel2.setOpaque(true);
		totallabel2.setBackground(new Color(0xCCFFFF));
		totallabel2.setForeground(Color.black);
		totallabel2.setFont(fontsize20);
		totallabel2.setBounds(saleslabel2.getX(), totallabel.getY(), 160, 40);

		add(totallabel2);		
		
		

		// �������� ���� �� �ƴϿ� ��ư �׼� ������
		pay_cash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actPayment('P');
			}
		});

		// ī��� ���� �� �ƴϿ� ��ư �׼� ������
		pay_card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actPayment('S');
			}
		});

		// �������� ���� �� �ƴϿ� ��ư �׼� ������
		pay_coupon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actPayment('B');
			}
		});

		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(250, 50, 1000, 650);
		setVisible(true);

	}
	
	public void actPayment(char pType) {
		String sPtype = "";
		switch(pType){
			case 'P':
				sPtype = "��������";
				break;
			
			case 'S':
				sPtype = "ī���";
				break;
				
			case 'B':
				sPtype = "��������";
				break;
		}
		
		int result = JOptionPane.showConfirmDialog(null, sPtype + " ���� �Ͻðڽ��ϱ�?", "���� Ȯ��",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			// ���� ������ ���			
			String sql = "insert into payment_list(PAYMENT_IDX, PAYMENT_TYPE, PAYMENT_CASH_RECEIPTS, PAYMENT_PRICE, PAYMENT_DATE)";
				sql += " values(PAYMENT_LIST_SEQ.nextval, ?, 'N', ?, sysdate)";
			ArrayList<PsList> psList = new ArrayList<>();
			psList.add(new PsList('S', String.valueOf(pType)));
			psList.add(new PsList('I', String.valueOf(sumPrice)));
			long lIdx = 0;
			
			if ((lIdx = ReturnModel.selLastIndex(sql, psList)) > 0) {				
				for(Order o : orderlist) {
					
					sql = "insert into order_list(ORDER_IDX, MENU_IDX, ORDER_STATE, ORDER_PRICE";
	                sql +=" ,ORDER_QUANTITY, ORDER_PRICE_TOTAL ";
					sql +=" ,MENU_NAME, ORDER_IN_DATE, SET_IDX, PAYMENT_IDX)";
					sql +=" values(ORDER_IDX_SEQ.nextval, ?, 0, ?";
					sql +=" , ?, ?";
					sql +=" , ?, sysdate, ?, ?)";
					
					psList = new ArrayList<>();
					psList.add(new PsList('I', o.getMenu_idx().toString()));
					psList.add(new PsList('I', o.getOrder_price().toString()));
					psList.add(new PsList('I', o.getOrder_quantity().toString()));
					psList.add(new PsList('I', o.getOrder_price_total().toString()));
					psList.add(new PsList('S', o.getMenu_name().toString()));
					psList.add(new PsList('I', o.getSet_idx().toString()));
					psList.add(new PsList('L', String.valueOf(lIdx)));
					
					if(!OjdbcConnection.insert(sql, psList)) {
						ManagerCP.viewError("���� ����", "����");
						return;
					}
				}
				ManagerCP.viewSuccess("������ �Ϸ� �Ǿ����ϴ�.", "���� �Ϸ�");
				dispose();
				
			} else {
				ManagerCP.viewError("���� ����", "����");
			}		
		}else {
			System.out.println("���� ��� : " + pType);
		}
	}
	
	public static void main(String[] args) {
		
		// �ֹ� ��� ���� ����(�׽�Ʈ��)
		ArrayList<Order> orderlist = new ArrayList<>();				
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu";
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
		for (int i = 0; i < 5; i++) {
			int cnt = (int) (Math.random() * 3) + 1;
			orderlist.add(new Order(menuList.get((int)(Math.random() * menuList.size())), cnt, (int)(Math.random() * 2)));
		}
		
		// �ֹ� ��� �Ѱ� �޾Ƽ� ȣ���ϴ� �κ�
		new Pos_PaymentPageSe(orderlist, 'C');
	}
}
