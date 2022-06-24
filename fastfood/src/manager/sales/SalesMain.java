package manager.sales;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import database.manager.Calculate;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.SaleActionListener;
import manager.component.ManagerCP;

public class SalesMain extends JPanel {
	
	ManagerMain main;
	
	Calendar cal;
	JPanel jpCalendar;
	//JLabel jlViewDate;
	SalesTopCalendar topCalendar;
	
	public SalesMain(ManagerMain main) {
		
		this.main = main;
		main.setSize(885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		
		SalesTopCalendar topCalendar = new SalesTopCalendar(this);
		
		cal = Calendar.getInstance();
		
		add(topCalendar);
		
		JPanel jpDayofweek = new JPanel();
		jpDayofweek.setBounds(0, topCalendar.getY() + topCalendar.getHeight(), getWidth(), 30);
		jpDayofweek.setLayout(new GridLayout(1,7));
		JButton btn1 = new JButton("�Ͽ���");
		JButton btn2 = new JButton("������");
		JButton btn3 = new JButton("ȭ����");
		JButton btn4 = new JButton("������");
		JButton btn5 = new JButton("�����");
		JButton btn6 = new JButton("�ݿ���");
		JButton btn7 = new JButton("�����");
		jpDayofweek.add(btn1);
		jpDayofweek.add(btn2);
		jpDayofweek.add(btn3);
		jpDayofweek.add(btn4);
		jpDayofweek.add(btn5);
		jpDayofweek.add(btn6);
		jpDayofweek.add(btn7);
		
		add(jpDayofweek);
				
		jpCalendar = new JPanel();
		jpCalendar.setBounds(0, jpDayofweek.getY() + jpDayofweek.getHeight(), getWidth(), 620);
		jpCalendar.setLayout(new GridLayout(6,7));
		
		add(jpCalendar);
		
		viewMonSale();
	}
	
	public void chgCalendar(String strEvene) {
		switch (strEvene) {
			case "NM":
				cal.add(Calendar.MONTH, +1);
				break;
			case "NY":
				cal.add(Calendar.YEAR, +1);
				break;
			case "PM":
				cal.add(Calendar.MONTH, -1);
				break;
			case "PY":
				cal.add(Calendar.YEAR, -1);
				break;
			case "N":
				cal = Calendar.getInstance();
				break;
		}
		viewMonSale();
	}
	
	public void viewMonSale() {
		ManagerCP.reFresh(jpCalendar);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		DateFormat formatTime = new SimpleDateFormat("HH : mm");
		
		System.out.println(format.format(cal.getTime()));
		
		String sqlSel = "select * from calculate";
			sqlSel +=  " where calculate_in_date >= ? order by calculate_in_date";
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('D', String.valueOf(format.format(cal.getTime()))));		
		ArrayList<Calculate> calculateList = ReturnModel.selCalculateMonth(sqlSel, psList);
		
		topCalendar.jlViewDate.setText(format.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH�� 1�� ���� (���� ù��)
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1; //�� ���� ���� ��ȯ (��:1 ~ ��:7)
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) + week;
		int listMax = calculateList.size();
		
		for(int i = 1; i <= 42; i++) {
			
			JPanel jpDay = new JPanel();
			jpDay.setLayout(null);
			jpDay.setBorder(new LineBorder(Color.BLACK));
			int chkDay = i - week;
			if(i > week && i <= endDay) {
				jpDay.setBackground(Color.WHITE);
				JLabel jlDayNum = new JLabel(String.valueOf(chkDay));
				if(i % 7 == 0) {
					jlDayNum.setForeground(Color.BLUE);
				}else if(i % 7 == 1) {
					jlDayNum.setForeground(Color.RED);
				}
				jlDayNum.setFont(new Font("���ü", Font.BOLD, 14));
				jlDayNum.setBounds(5,0, 100, 20);
				jpDay.add(jlDayNum);
				if(chkDay < listMax) {
					Calculate c = calculateList.get(chkDay);
					JLabel jlOpen = new JLabel("����: " + formatTime.format(c.getCalculate_in_date()));
					jlOpen.setBounds(jlDayNum.getX(),jlDayNum.getY() + jlDayNum.getHeight(), 100, 20);
					
					JLabel jlEnd = new JLabel("����: " + formatTime.format(c.getCalculate_out_date()));
					jlEnd.setBounds(jlDayNum.getX(),jlOpen.getY() + jlOpen.getHeight(), 100, 20);
					
					JLabel jlSale = new JLabel("����: " + ManagerCP.viewWon(c.getCalculate_total_price()) + "��");
					jlSale.setBounds(jlDayNum.getX(),jlEnd.getY() + jlEnd.getHeight(), 140, 20);
					
					jpDay.add(jlOpen);
					jpDay.add(jlEnd);
					jpDay.add(jlSale);
				}				
			}
			
			jpCalendar.add(jpDay);
		}
		
	}

}












