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
		
		String[] str = { "예", "아니오" };
		setTitle("결제창");

		Font fontsize60 = new Font("맑은 고딕", Font.PLAIN, 60);
		Font fontsize20 = new Font("맑은 고딕", Font.PLAIN, 20);

		String orderTitle = "<Take-out>";
		
		if(orderType == 'E') {
			orderTitle = "<Eat - IN>";
		}
		
		JLabel label = new JLabel(orderTitle);
		label.setFont(fontsize60);
		label.setBounds(80, 10, 350, 100);
		add(label);		

		JButton orderaddBtn = new JButton("추가주문");
		orderaddBtn.setFont(fontsize20);
		orderaddBtn.setBounds(70, 120, 150, 100);
		add(orderaddBtn);

		JButton ordercancelBtn = new JButton("전체취소");
		ordercancelBtn.setFont(fontsize20);
		ordercancelBtn.setBounds(250, 120, 150, 100);
		add(ordercancelBtn);

		JButton pay_card = new JButton("카드결제");
		pay_card.setFont(fontsize20);
		pay_card.setBounds(70, 230, 330, 100);
		add(pay_card);

		JButton pay_cash = new JButton("현금결제");
		pay_cash.setFont(fontsize20);
		pay_cash.setBounds(70, 340, 330, 100);
		add(pay_cash);

		JButton pay_coupon = new JButton("쿠폰결제");
		pay_coupon.setFont(fontsize20);
		pay_coupon.setBounds(70, 450, 330, 100);
		add(pay_coupon);

		// 주문 번호
		Label orderlabel = new Label();

		orderlabel.setText("                 주문번호");
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

		String[] columnNames = { "메뉴", "수량", "단가", "금액" };

		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);

		table.setRowHeight(40);
		table.setFont(fontsize20);
		scrollPane.setBounds(450, orderaddBtn.getY(), 500, 200);

		add(scrollPane);
		

		// 판매액
		Label saleslabel = new Label();

		saleslabel.setText("      판매액");
		saleslabel.setBackground(new Color(0x00769E));
		saleslabel.setForeground(Color.white);
		saleslabel.setFont(fontsize20);
		saleslabel.setBounds(650, scrollPane.getY() + scrollPane.getHeight(), 140, 40);

		add(saleslabel);
		
		// 판매액값 들어가는 라벨
		JLabel saleslabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		saleslabel2.setOpaque(true);
		saleslabel2.setBackground(new Color(0xCCFFFF));
		saleslabel2.setForeground(Color.black);
		saleslabel2.setFont(fontsize20);
		saleslabel2.setBounds(saleslabel.getX() + saleslabel.getWidth(), saleslabel.getY(), 160, 40);

		add(saleslabel2);

		// 할인액
		Label discountlabel = new Label();

		discountlabel.setText("      할인액");
		discountlabel.setBackground(new Color(0x00769E));
		discountlabel.setForeground(Color.white);
		discountlabel.setFont(fontsize20);
		discountlabel.setBounds(saleslabel.getX(), saleslabel.getY() + saleslabel.getHeight(), 140, 40);

		add(discountlabel);
		
		// 할인액값 들어가는 라벨
		JLabel discountlabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		discountlabel2.setOpaque(true);
		discountlabel2.setBackground(new Color(0xCCFFFF));
		discountlabel2.setForeground(Color.black);
		discountlabel2.setFont(fontsize20);
		discountlabel2.setBounds(saleslabel2.getX(), discountlabel.getY(), 160, 40);

		add(discountlabel2);

		// 합계
		Label totallabel = new Label();
		totallabel.setText("        합계");

		totallabel.setBackground(new Color(0x00769E));
		totallabel.setForeground(Color.white);
		totallabel.setFont(fontsize20);
		totallabel.setBounds(saleslabel.getX(), discountlabel.getY() + discountlabel.getHeight(), 140, 40);

		add(totallabel);
		// ----------------------------------------------------
		
		// 합계값 들어가는 라벨
		JLabel totallabel2 = new JLabel(ManagerCP.viewWon(sumPrice), 0);
		totallabel2.setOpaque(true);
		totallabel2.setBackground(new Color(0xCCFFFF));
		totallabel2.setForeground(Color.black);
		totallabel2.setFont(fontsize20);
		totallabel2.setBounds(saleslabel2.getX(), totallabel.getY(), 160, 40);

		add(totallabel2);		
		
		

		// 현금으로 결제 예 아니오 버튼 액션 리스너
		pay_cash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actPayment('P');
			}
		});

		// 카드로 결제 예 아니오 버튼 액션 리스너
		pay_card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actPayment('S');
			}
		});

		// 쿠폰으로 결제 예 아니오 버튼 액션 리스너
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
				sPtype = "현금으로";
				break;
			
			case 'S':
				sPtype = "카드로";
				break;
				
			case 'B':
				sPtype = "쿠폰으로";
				break;
		}
		
		int result = JOptionPane.showConfirmDialog(null, sPtype + " 결제 하시겠습니까?", "결제 확인",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			// 예를 선택한 경우			
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
						ManagerCP.viewError("결제 실패", "실패");
						return;
					}
				}
				ManagerCP.viewSuccess("결제가 완료 되었습니다.", "결제 완료");
				dispose();
				
			} else {
				ManagerCP.viewError("결제 실패", "실패");
			}		
		}else {
			System.out.println("결제 취소 : " + pType);
		}
	}
	
	public static void main(String[] args) {
		
		// 주문 목록 랜덤 생성(테스트용)
		ArrayList<Order> orderlist = new ArrayList<>();				
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu";
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
		for (int i = 0; i < 5; i++) {
			int cnt = (int) (Math.random() * 3) + 1;
			orderlist.add(new Order(menuList.get((int)(Math.random() * menuList.size())), cnt, (int)(Math.random() * 2)));
		}
		
		// 주문 목록 넘겨 받아서 호출하는 부분
		new Pos_PaymentPageSe(orderlist, 'C');
	}
}
