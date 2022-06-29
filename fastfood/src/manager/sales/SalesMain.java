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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Calculate;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.SalesMActionListener;
import manager.component.ManagerCP;

public class SalesMain extends JPanel {
	
	ManagerMain main;
	int iDay;
	
	Calendar cal;
	JPanel jpCalendar;
	SalesTopCalendar topCalendar;
	ArrayList<JPanel> dayPanel = new ArrayList<>();
	Calculate selCalculate = new Calculate();
	
	DateFormat format = new SimpleDateFormat("yyyy-MM");
	DateFormat formatTime = new SimpleDateFormat("HH : mm");
	DateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd");
	
	public void selDay(Calculate c, int idx) {
		this.iDay = idx;
		this.selCalculate = c;
		for(int i = 0; i < dayPanel.size(); i++) {
			if(i == idx - 1) {
				dayPanel.get(i).setBorder(new LineBorder(Color.RED, 3));
			}else {
				dayPanel.get(i).setBorder(new LineBorder(Color.BLACK));
			}
		}
		topCalendar.btnOpen.setEnabled(false);
		topCalendar.btnClose.setEnabled(false);
		topCalendar.btnOpenC.setEnabled(false);
		topCalendar.btnCloseC.setEnabled(false);
		
		if(c.getCalculate_in_date() == null) {			
			topCalendar.btnOpen.setEnabled(true);
		}else {
			topCalendar.btnOpenC.setEnabled(true);
		}
		if(c.getCalculate_out_date() == null) {
			if(c.getCalculate_in_date() != null) {
				topCalendar.btnClose.setEnabled(true);
				topCalendar.btnOpen.setEnabled(false);
			}
		}else {
			topCalendar.btnCloseC.setEnabled(true);
		}		
	}
	
	public void setOpenClose(String sCate) {
		
		Calendar setCal = cal;
		
		setCal.set(Calendar.DATE, iDay);
				
		String openDate = formatAll.format(setCal.getTime());
		String closeDate = formatAll.format(setCal.getTime());
		String sql = "";
		ArrayList<PsList> psList = new ArrayList<>();
		
		switch(sCate) {
		case "O":	//오픈 등록
			// 오픈일로 된 날이 없으면
			if(selCalculate.getCalculate_in_date() == null) {
				if(ManagerCP.viewConfirm(openDate + "일을 오픈 하시겠습니까?", "오픈 등록")) {
					sql = "insert into calculate (CALCULATE_IDX, CALCULATE_IN_DATE, CALCULATE_IN_ID)";
					sql += " values(CALCULATE_IDX_SEQ.nextval, ?, ?)";
					
					psList = new ArrayList<>();
					psList.add(new PsList('D', openDate));
					psList.add(new PsList('S', main.mInfo.getMember_id()));
					if (OjdbcConnection.insert(sql, psList)) {
						ManagerCP.viewSuccess(openDate + "일 오픈이 등록 되었습니다.", "오픈 등록");
						viewMonSale();
					} else {
						ManagerCP.viewError("오픈 등록 실패", "실패");
					}
				}
			}
			break;
		case "C":	//마감 등록
			// 오픈일로 된 날이 있으면
			if(selCalculate.getCalculate_in_date() != null) {
				if(ManagerCP.viewConfirm(closeDate + "일을 마감 하시겠습니까?", "마감 등록")) {
					sql = "update calculate";
					sql += " set calculate_out_date = ?";
					sql += " , calculate_out_id = ?";
					sql += " , calculate_close = 'Y'";
					sql += " , calculate_total_price = (select NVL(sum(PAYMENT_PRICE),0) from payment_list"; 
					sql += " where TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') = ?)";
					sql += " where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
					
					psList = new ArrayList<>();
					psList.add(new PsList('D', closeDate));
					psList.add(new PsList('S', main.mInfo.getMember_id()));
					psList.add(new PsList('S', closeDate));
					psList.add(new PsList('S', closeDate));
					
					if (OjdbcConnection.insert(sql, psList)) {
						ManagerCP.viewSuccess(openDate + "일 오픈이 등록 되었습니다.", "오픈 등록");
						viewMonSale();
					} else {
						ManagerCP.viewError("오픈 등록 실패", "실패");
					}
				}
			}else {
				ManagerCP.viewError("오픈일이 등록 되어 있지 않습니다.", "등록 에러");
			}
			break;
		case "OC":	//오픈 취소
			// 오픈일로 된 날이 있으면
			if(selCalculate.getCalculate_in_date() != null) {
				if(ManagerCP.viewConfirm(openDate + "일의 오픈을 취소 하시겠습니까?", "오픈 등록 취소")) {
					sql = "delete from calculate";
					sql += " where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
					
					psList = new ArrayList<>();
					psList.add(new PsList('S', openDate));
					if (OjdbcConnection.insert(sql, psList)) {
						ManagerCP.viewSuccess(openDate + "일의 오픈이 취소 되었습니다.", "오픈 취소");
						viewMonSale();
					} else {
						ManagerCP.viewError("오픈 등록 취소 실패", "실패");
					}
					
				}
			}else{
				ManagerCP.viewError("오픈일이 등록 되어 있지 않습니다.", "등록 에러");
			}
			break;
		case "CC":	//마감 취소
			// 마감일로 된 날이 있으면
			if(selCalculate.getCalculate_out_date() != null) {
				if(ManagerCP.viewConfirm(openDate + "일의 마감을 해지 하시겠습니까?", "마감 등록 해지")) {
					sql = "update calculate set CALCULATE_OUT_DATE = null";
					sql += " , CALCULATE_OUT_ID = ?";
					sql += " , CALCULATE_CLOSE = 'N'";					
					sql += " , CALCULATE_TOTAL_PRICE = 0";
					sql += " where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
					
					psList = new ArrayList<>();
					
					psList.add(new PsList('S', main.mInfo.getMember_id()));
					psList.add(new PsList('S', openDate));
					if (OjdbcConnection.insert(sql, psList)) {
						ManagerCP.viewSuccess(openDate + "일의 마감이 해지 되었습니다.", "마감 해지");
						viewMonSale();
					} else {
						ManagerCP.viewError("마감 해지 실패", "실패");
					}
				}
			}else{
				ManagerCP.viewError("마감일이 등록 되어 있지 않습니다.", "등록 에러");
			}
			break;
		}		
	}
	
	public SalesMain(ManagerMain main) {
		
		this.main = main;
		main.setSize(885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		
		topCalendar = new SalesTopCalendar(this);
		
		cal = Calendar.getInstance();
		
		add(topCalendar);
		
		JPanel jpDayofweek = new JPanel();
		jpDayofweek.setBounds(0, topCalendar.getY() + topCalendar.getHeight(), getWidth(), 30);
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
		dayPanel = new ArrayList<>();
		
		topCalendar.jlViewDate.setText(format.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1; //그 주의 요일 반환 (일:1 ~ 토:7)
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH) + week;
		
		String sqlSel = "select * from calculate";
		sqlSel +=  " where TO_CHAR(calculate_in_date, 'yyyy-mm') = ? order by calculate_in_date";
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('S', format.format(cal.getTime())));		
		ArrayList<Calculate> calculateListAll = new ArrayList<>();
		ArrayList<Calculate> calculateList = ReturnModel.selCalculateMonth(sqlSel, psList);
		//int listMax = calculateList.size();
		Calendar allCal = cal;
		for(int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			
			allCal.set(Calendar.DATE, i + 1);
			String orgDate = formatAll.format(allCal.getTime());
			boolean chkDate = true;
			
			for(Calculate c: calculateList) {
				if(orgDate.equals(formatAll.format(c.getCalculate_in_date()))) {
					calculateListAll.add(c);
					chkDate = false;
					break;
				}
			}
			
			if(chkDate) {
				calculateListAll.add(new Calculate());
			}
		}

				
		for(int i = 1; i <= 42; i++) {
			
			JPanel jpDay = new JPanel();
			jpDay.setLayout(null);
			jpDay.setBorder(new LineBorder(Color.BLACK));
			int chkDay = i - week;
			if(i > week && i <= endDay) {
				dayPanel.add(jpDay);
				
				jpDay.setBackground(Color.WHITE);
				
				JLabel jlDayNum = new JLabel(String.valueOf(chkDay));
				if(i % 7 == 0) {
					jlDayNum.setForeground(Color.BLUE);
				}else if(i % 7 == 1) {
					jlDayNum.setForeground(Color.RED);
				}
				jlDayNum.setFont(new Font("고딕체", Font.BOLD, 14));
				jlDayNum.setBounds(5,0, 100, 20);
				jpDay.add(jlDayNum);
				
				Calculate c = calculateListAll.get(chkDay - 1);				
				if(chkDay == cal.getInstance().get(Calendar.DATE)) {					
					selDay(c, chkDay);
				}
				//클릭 이벤트
				jpDay.addMouseListener(new SalesMActionListener(this, c, chkDay));
				String openDate = "오픈 : ";
				String closeDate = "마감 : ";
				String dayPrice = "매출 : ";
				if(c.getCalculate_in_date() != null) {
					openDate += formatTime.format(c.getCalculate_in_date());
				}
				JLabel jlOpen = new JLabel(openDate);
				jlOpen.setBounds(jlDayNum.getX(),jlDayNum.getY() + jlDayNum.getHeight(), 100, 20);
				
				if(c.getCalculate_out_date() != null) {
					closeDate += formatTime.format(c.getCalculate_out_date());
				}
				JLabel jlEnd = new JLabel(closeDate);
				jlEnd.setBounds(jlDayNum.getX(),jlOpen.getY() + jlOpen.getHeight(), 100, 20);
				
				if(c.getCalculate_total_price() != null) {
					dayPrice += ManagerCP.viewWon(c.getCalculate_total_price()) + "원";
				}
				JLabel jlSale = new JLabel(dayPrice);
				jlSale.setBounds(jlDayNum.getX(),jlEnd.getY() + jlEnd.getHeight(), 140, 20);
				
				jpDay.add(jlOpen);
				jpDay.add(jlEnd);
				jpDay.add(jlSale);
								
			}
			
			jpCalendar.add(jpDay);
		}
		
	}

}












