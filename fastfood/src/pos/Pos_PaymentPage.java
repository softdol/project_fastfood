package pos;

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

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;

public class Pos_PaymentPage extends JFrame {
	public Pos_PaymentPage(ArrayList<Order> orderlist) {

		String[] str = { "��", "�ƴϿ�" };
		setTitle("����â");

		Font fontsize60 = new Font("���� ���", Font.PLAIN, 60);
		Font fontsize20 = new Font("���� ���", Font.PLAIN, 20);

		JLabel label = new JLabel("<Take-out>");
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

		add(orderlabel);

		// �Ǹž�
		Label saleslabel = new Label();

		saleslabel.setText("      �Ǹž�");
		saleslabel.setBackground(new Color(0x00769E));
		saleslabel.setForeground(Color.white);
		saleslabel.setFont(fontsize20);
		saleslabel.setBounds(600, 350, 140, 40);

		add(saleslabel);

		// ���ξ�
		Label discountlabel = new Label();

		discountlabel.setText("      ���ξ�");
		discountlabel.setBackground(new Color(0x00769E));
		discountlabel.setForeground(Color.white);
		discountlabel.setFont(fontsize20);
		discountlabel.setBounds(600, 390, 140, 40);

		add(discountlabel);

		// �հ�
		Label totallabel = new Label();
		totallabel.setText("        �հ�");

		totallabel.setBackground(new Color(0x00769E));
		totallabel.setForeground(Color.white);
		totallabel.setFont(fontsize20);
		totallabel.setBounds(600, 430, 140, 40);

		add(totallabel);
		// ----------------------------------------------------
		// �Ǹžװ� ���� ��
		Label saleslabel2 = new Label();

		saleslabel2.setText("      ");
		saleslabel2.setBackground(new Color(0xCCFFFF));
		saleslabel2.setForeground(Color.white);
		saleslabel2.setFont(fontsize20);
		saleslabel2.setBounds(740, 350, 160, 40);

		add(saleslabel2);

		// ���ξװ� ���� ��
		Label discountlabel2 = new Label();

		discountlabel2.setText("      ");
		discountlabel2.setBackground(new Color(0xCCFFFF));
		discountlabel2.setForeground(Color.white);
		discountlabel2.setFont(fontsize20);
		discountlabel2.setBounds(740, 390, 160, 40);

		add(discountlabel2);

		// �հ谪 ���� ��
		Label totallabel2 = new Label();
		totallabel2.setText("       ");
		//
		totallabel2.setBackground(new Color(0xCCFFFF));
		totallabel2.setForeground(Color.white);
		totallabel2.setFont(fontsize20);
		totallabel2.setBounds(740, 430, 160, 40);

		add(totallabel2);		

		String[][] rowData = new String[orderlist.size()][4];

//		for (int i = 0; i < orderlist.size(); i++) {
//			rowData[i][0] = orderlist.get(i).getMenu();
//			rowData[i][1] = orderlist.get(i).getMenunum().toString();
//			rowData[i][2] = orderlist.get(i).getPrice().toString();
//			rowData[i][3] = orderlist.get(i).getSumprice().toString();
//		}

		String[] columnNames = { "Menu Name", "Quantity", "UnitPrice", "Price" };

		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);

		table.setRowHeight(40);
		table.setFont(fontsize20);
		scrollPane.setBounds(600, 150, 300, 200);

		add(scrollPane);

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
				actPayment('C');
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
			case 'C':
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
			System.out.println("���� �Ϸ� : " + pType);
		}else {
			// �ƴϿ��� ������ ���
			// �� �ƴϿ� ���� ���� ���̾�α� â�� ���� ���
			System.out.println("���� ��� : " + pType);
		}
	}
	
	public static void main(String[] args) {
		
		// �ֹ� ��� ���� ����(�׽�Ʈ��)
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
		
		// �ֹ� ��� �Ѱ� �޾Ƽ� ȣ���ϴ� �κ�
		new Pos_PaymentPage(orderlist);
	}
}
