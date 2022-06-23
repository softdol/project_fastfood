package manager.sales;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import manager.ManagerMain;

public class SalesMain extends JPanel {
	
	ManagerMain main;
	
	public SalesMain(ManagerMain main) {
		
		this.main = main;
		
		setLayout(null);
		setBounds(0,0,765,726);
		setBorder(new LineBorder(Color.BLACK));
		
		JPanel jpSelCalendar = new JPanel();
		jpSelCalendar.setBounds(0, 5, getWidth(), 50);
		jpSelCalendar.setBorder(new LineBorder(Color.GREEN));
		
		add(jpSelCalendar);
		
		JPanel jpDayofweek = new JPanel();
		jpDayofweek.setBounds(0, jpSelCalendar.getY() + jpSelCalendar.getHeight(), getWidth(), 50);
		jpDayofweek.setBorder(new LineBorder(Color.RED));
		
		add(jpDayofweek);
				
		JPanel jpCalendar = new JPanel();
		jpCalendar.setBounds(0, jpDayofweek.getY() + jpDayofweek.getHeight(), getWidth(), 620);
		jpCalendar.setBorder(new LineBorder(Color.BLUE));
		jpCalendar.setLayout(new GridLayout(5,7));
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
		//cal.add(Calendar.DAY_OF_MONTH,4);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1; //그 주의 요일 반환 (일:1 ~ 토:7)
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) + week;
		
		System.out.println(week);
		
		for(int i = 1; i <= 35; i++) {
			
			JPanel jpDay = new JPanel();
			jpDay.setLayout(null);
			jpDay.setBorder(new LineBorder(Color.BLACK));
//			JButton btnDay = new JButton();
			if(i > week && i <= endDay) {
//				btnDay.setText(String.valueOf(i - week));
				jpDay.setBackground(Color.WHITE);
				JLabel jlOpen = new JLabel("오픈: 06:10");
				jlOpen.setBounds(0,0, 100, 20);
				
				JLabel jlEnd = new JLabel("마감: 06:10");
				jlEnd.setBounds(0,20, 100, 20);
				
				JLabel jlSale = new JLabel("매출: 12,152,100원");
				jlSale.setBounds(0,40, 140, 20);
				
				jpDay.add(jlOpen);
				jpDay.add(jlEnd);
				jpDay.add(jlSale);
			}
			
			jpCalendar.add(jpDay);
		}
		
		add(jpCalendar);
	}

}












