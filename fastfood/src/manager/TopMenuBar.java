package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import database.OjdbcConnection;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.actionlistener.BarActionListener;
import manager.component.ManagerCP;
import manager.component.bar.BarMenuSubItem;
import manager.component.bar.BarMenuSubTitle;
import manager.component.bar.BarMenuTitle;

public class TopMenuBar extends JMenuBar {
	
	ManagerMain main;
	
	public TopMenuBar(ManagerMain main) {
		
		this.main = main;
		
		BarActionListener barAction = new BarActionListener(main);		
		
		BarMenuTitle menuAll = new BarMenuTitle("메뉴");
		
		BarMenuSubTitle menuTitle = new BarMenuSubTitle("상품관리");		
		BarMenuSubItem menuList = new BarMenuSubItem("상품목록");		
		BarMenuSubItem menuInsert = new BarMenuSubItem("상품등록");
		BarMenuSubItem menuSetList = new BarMenuSubItem("세트메뉴목록");
		BarMenuSubItem menuSetInsert = new BarMenuSubItem("세트메뉴등록");
		//menuItem = new JMenuItem(“메뉴항목1”, KeyEvent.VK_T); ->키보드 단축키 설정 가능
//		System.out.println(menuTitle.getMenuComponentCount());
//		System.out.println(menuTitle.getItem(1).getText());
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		menuTitle.add(menuSetList);
		menuTitle.add(menuSetInsert);
		
		for(int i = 0; i < menuTitle.getMenuComponentCount(); i++) {
			menuTitle.getItem(i).addActionListener(barAction);
		}
		
		BarMenuSubTitle salesTitle = new BarMenuSubTitle("매출조회");
		BarMenuSubItem salesMonth = new BarMenuSubItem("월 매출조회");
		BarMenuSubItem salesYear = new BarMenuSubItem("년 매출조회");
		salesMonth.addActionListener(barAction);
		salesYear.addActionListener(barAction);
		salesTitle.add(salesMonth);
		salesTitle.add(salesYear);
		
		BarMenuSubItem calculateTitle = new BarMenuSubItem("정산");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("매장관리");
		memberTitle.addActionListener(barAction);
		
		//openItem.addActionListener(new OpenActionListener());
		menuAll.add(menuTitle);
		menuAll.add(salesTitle);
		//menuAll.add(calculateTitle);
		menuAll.add(memberTitle);
		
		add(menuAll, LEFT_ALIGNMENT);
		
		JPanel jpSpace = new JPanel();
		//jpSpace.setBorder(new LineBorder(Color.red));
		
		add(jpSpace);
		
		JButton menuBanner = new JButton("              로고 이미지");
		menuBanner.setEnabled(false);
		JButton menuOrder = new JButton("주문관리");
		JButton menuOpenClose = new JButton("오픈마감");
		JButton menuExit = new JButton("닫기");
		
		menuOpenClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(main.menuMainPanel.jpMainMiddle.getComponent(0).getClass().getSimpleName().equals("SalesMain")) {
					ManagerCP.viewSuccess("하단 매출 달력에서 입력해 주세요.", "확인");
					return;
				}
				
				Calendar cal = Calendar.getInstance();
				DateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd");
				String thisDate = formatAll.format(cal.getTime());
				
				String sql = "select * from calculate where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('S', thisDate));
				
				if(ReturnModel.selConfirm(sql, psList)) {
					if(ManagerCP.viewConfirm(thisDate + "일 마감 등록 하시겠습니까?", "마감 등록")) {
						sql = "update calculate";
						sql += " set calculate_out_date = ?";
						sql += " , calculate_out_id = ?";
						sql += " , calculate_close = 'Y'";
						sql += " , calculate_total_price = (select NVL(sum(PAYMENT_PRICE),0) from payment_list"; 
						sql += " where TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') = ?)";
						sql += " where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
						
						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						psList.add(new PsList('S', thisDate));
						psList.add(new PsList('S', thisDate));
						
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "일 마감이 등록 되었습니다.", "마감 등록");
						} else {
							ManagerCP.viewError("마감 등록 실패", "실패");
						}
					}
				}else {
					if(ManagerCP.viewConfirm(thisDate + "일 오픈 등록 하시겠습니까?", "오픈 등록")) {

						sql = "insert into calculate (CALCULATE_IDX, CALCULATE_IN_DATE, CALCULATE_IN_ID)";
						sql += " values(CALCULATE_IDX_SEQ.nextval, ?, ?)";
						
						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "일 오픈이 등록 되었습니다.", "오픈 등록");
						} else {
							ManagerCP.viewError("오픈 등록 실패", "실패");
						}
					}
				}
				
			}
		});
		
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuOpenClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(main.menuMainPanel.jpMainMiddle.getComponent(0).getClass().getSimpleName().equals("SalesMain")) {
					ManagerCP.viewError("하단 매출 달력에서 수정가능 합니다.", "안내");
					return;
				}
				
				Calendar cal = Calendar.getInstance();
				DateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd");
				String thisDate = formatAll.format(cal.getTime());
				
				String sql = "select * from calculate where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('S', thisDate));
				
				if(ReturnModel.selConfirm(sql, psList)) {	// 오픈일이 있으면
					
					sql = "select * from calculate where TO_CHAR(calculate_out_date, 'yyyy-mm-dd') = ?";
					psList = new ArrayList<>();
					psList.add(new PsList('S', thisDate));
					
					if(ReturnModel.selConfirm(sql, psList)) {	// 마감일이 있으면
						ManagerCP.viewError("이미 마감 되었습니다.", "실패");
						return;
					}
					
					if(ManagerCP.viewConfirm(thisDate + "일을 마감 하시겠습니까?", "마감 등록")) {
						sql = "update calculate";
						sql += " set calculate_out_date = ?";
						sql += " , calculate_out_id = ?";
						sql += " , calculate_close = 'Y'";
						sql += " , calculate_total_price = (select NVL(sum(PAYMENT_PRICE),0) from payment_list"; 
						sql += " where TO_CHAR(PAYMENT_DATE, 'yyyy-mm-dd') = ?)";
						sql += " where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
						
						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						psList.add(new PsList('S', thisDate));
						psList.add(new PsList('S', thisDate));
						
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "일 마감이 등록 되었습니다.", "마감 등록");
							//
						} else {
							ManagerCP.viewError("마감 등록 실패", "실패");
						}						
					}
				}else {	// 오픈일이 없으면
					if(ManagerCP.viewConfirm(thisDate + "일을 오픈 하시겠습니까?", "오픈 등록")) {
						sql = "insert into calculate (CALCULATE_IDX, CALCULATE_IN_DATE, CALCULATE_IN_ID)";
						sql += " values(CALCULATE_IDX_SEQ.nextval, ?, ?)";

						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "일 오픈이 등록 되었습니다.", "오픈 등록");							
						} else {
							ManagerCP.viewError("오픈 등록 실패", "실패");
						}
					}
				}
			}
		});
		
		add(menuBanner);
		//add(menuOrder);
		add(menuOpenClose);
		add(menuExit, RIGHT_ALIGNMENT);
		
	}

}
