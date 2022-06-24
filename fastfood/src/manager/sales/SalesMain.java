package manager.sales;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import manager.ManagerMain;
import manager.actionlistener.SaleActionListener;
import manager.component.ManagerCP;

public class SalesMain extends JPanel {
	
	ManagerMain main;
	
	Calendar cal;
	JPanel jpCalendar;
	JLabel jlViewDate;
	
	public SalesMain(ManagerMain main) {
		
		this.main = main;
		//main.setBounds(200,150,885,786);
		main.setSize(885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		//setBorder(new LineBorder(Color.BLACK));
		
		cal = Calendar.getInstance();
		
		JPanel jpSelCalendar = new JPanel();
		jpSelCalendar.setLayout(null);
		jpSelCalendar.setBounds(0, 5, getWidth(), 50);
		//jpSelCalendar.setBorder(new LineBorder(Color.GREEN));
		JButton btnPrevY = new JButton("<<");
		btnPrevY.setBounds(20, 5, 50, 40);
		btnPrevY.addActionListener(new SaleActionListener(this, "PY"));
		JButton btnPrevM = new JButton("<");		
		btnPrevM.setBounds(btnPrevY.getX() + btnPrevY.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnPrevM.addActionListener(new SaleActionListener(this, "PM"));
		jlViewDate = new JLabel("", 0);
		jlViewDate.setBounds(btnPrevM.getX() + btnPrevM.getWidth() + 5, btnPrevY.getY(), 120, 40);
		jlViewDate.setOpaque(true);
		jlViewDate.setBackground(Color.white);
		jlViewDate.setFont(new Font("고딕체", Font.BOLD, 20));
		JButton btnNextM = new JButton(">");
		btnNextM.setBounds(jlViewDate.getX() + jlViewDate.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnNextM.addActionListener(new SaleActionListener(this, "NM"));
		JButton btnNextY = new JButton(">>");
		btnNextY.setBounds(btnNextM.getX() + btnNextM.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnNextY.addActionListener(new SaleActionListener(this, "NY"));
		
		JButton btnNow = new JButton("이번달");
		btnNow.setBounds(btnNextY.getX() + btnNextY.getWidth() + 5, btnPrevY.getY(), 80, 40);
		btnNow.addActionListener(new SaleActionListener(this, "N"));
		
		
		jpSelCalendar.add(btnPrevY);
		jpSelCalendar.add(btnPrevM);
		jpSelCalendar.add(jlViewDate);
		jpSelCalendar.add(btnNextM);
		jpSelCalendar.add(btnNextY);
		jpSelCalendar.add(btnNow);

		// 오픈 마감 오픈취소 마감해지
		JButton btnOpen = new JButton("오픈");
		btnOpen.setBounds(btnNextY.getX() + btnNextY.getWidth() + 180, btnPrevY.getY(), 60, 40);
		JButton btnClose = new JButton("마감");
		btnClose.setBounds(btnOpen.getX() + btnOpen.getWidth() + 5, btnPrevY.getY(), 60, 40);
		JButton btnOpenC = new JButton("오픈취소");
		btnOpenC.setBounds(btnClose.getX() + btnClose.getWidth() + 5, btnPrevY.getY(), 90, 40);
		JButton btnCloseC = new JButton("마감해지");
		btnCloseC.setBounds(btnOpenC.getX() + btnOpenC.getWidth() + 5, btnPrevY.getY(), 90, 40);

		jpSelCalendar.add(btnOpen);
		jpSelCalendar.add(btnClose);
		jpSelCalendar.add(btnOpenC);
		jpSelCalendar.add(btnCloseC);
		
		add(jpSelCalendar);
		
		JPanel jpDayofweek = new JPanel();
		jpDayofweek.setBounds(0, jpSelCalendar.getY() + jpSelCalendar.getHeight(), getWidth(), 30);
		jpDayofweek.setLayout(new GridLayout(1,7));
		JButton btn1 = new JButton("일요일");
		JButton btn2 = new JButton("월요일");
		JButton btn3 = new JButton("화요일");
		JButton btn4 = new JButton("수요일");
		JButton btn5 = new JButton("목요일");
		JButton btn6 = new JButton("금요일");
		JButton btn7 = new JButton("토요일");
		jpDayofweek.add(btn1);
		jpDayofweek.add(btn2);
		jpDayofweek.add(btn3);
		jpDayofweek.add(btn4);
		jpDayofweek.add(btn5);
		jpDayofweek.add(btn6);
		jpDayofweek.add(btn7);
		
		//jpDayofweek.setBorder(new LineBorder(Color.RED));
		
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
			case "N":
				cal = Calendar.getInstance();
				break;
		}
		viewMonSale();
	}
	
	public void viewMonSale() {
		ManagerCP.reFresh(jpCalendar);	
		
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		
		jlViewDate.setText(format.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1; //그 주의 요일 반환 (일:1 ~ 토:7)
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) + week;
		
		for(int i = 1; i <= 42; i++) {
			
			JPanel jpDay = new JPanel();
			jpDay.setLayout(null);
			jpDay.setBorder(new LineBorder(Color.BLACK));
			if(i > week && i <= endDay) {
				jpDay.setBackground(Color.WHITE);
				JLabel jlDayNum = new JLabel(String.valueOf(i - week));
				if(i % 7 == 0) {
					jlDayNum.setForeground(Color.BLUE);
				}else if(i % 7 == 1) {
					jlDayNum.setForeground(Color.RED);
				}
				jlDayNum.setFont(new Font("고딕체", Font.BOLD, 14));
				jlDayNum.setBounds(5,0, 100, 20);
				
				JLabel jlOpen = new JLabel("오픈: 06:10");
				jlOpen.setBounds(jlDayNum.getX(),jlDayNum.getY() + jlDayNum.getHeight(), 100, 20);
				
				JLabel jlEnd = new JLabel("마감: 06:10");
				jlEnd.setBounds(jlDayNum.getX(),jlOpen.getY() + jlOpen.getHeight(), 100, 20);
				
				JLabel jlSale = new JLabel("매출: 12,152,100원");
				jlSale.setBounds(jlDayNum.getX(),jlEnd.getY() + jlEnd.getHeight(), 140, 20);
				
				jpDay.add(jlDayNum);
				jpDay.add(jlOpen);
				jpDay.add(jlEnd);
				jpDay.add(jlSale);
			}
			
			jpCalendar.add(jpDay);
		}
		
	}

}












