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
		
		BarMenuTitle menuAll = new BarMenuTitle("�޴�");
		
		BarMenuSubTitle menuTitle = new BarMenuSubTitle("��ǰ����");		
		BarMenuSubItem menuList = new BarMenuSubItem("��ǰ���");		
		BarMenuSubItem menuInsert = new BarMenuSubItem("��ǰ���");
		BarMenuSubItem menuSetList = new BarMenuSubItem("��Ʈ�޴����");
		BarMenuSubItem menuSetInsert = new BarMenuSubItem("��Ʈ�޴����");
		//menuItem = new JMenuItem(���޴��׸�1��, KeyEvent.VK_T); ->Ű���� ����Ű ���� ����
//		System.out.println(menuTitle.getMenuComponentCount());
//		System.out.println(menuTitle.getItem(1).getText());
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		menuTitle.add(menuSetList);
		menuTitle.add(menuSetInsert);
		
		for(int i = 0; i < menuTitle.getMenuComponentCount(); i++) {
			menuTitle.getItem(i).addActionListener(barAction);
		}
		
		BarMenuSubTitle salesTitle = new BarMenuSubTitle("������ȸ");
		BarMenuSubItem salesMonth = new BarMenuSubItem("�� ������ȸ");
		BarMenuSubItem salesYear = new BarMenuSubItem("�� ������ȸ");
		salesMonth.addActionListener(barAction);
		salesYear.addActionListener(barAction);
		salesTitle.add(salesMonth);
		salesTitle.add(salesYear);
		
		BarMenuSubItem calculateTitle = new BarMenuSubItem("����");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("�������");
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
		
		JButton menuBanner = new JButton("              �ΰ� �̹���");
		menuBanner.setEnabled(false);
		JButton menuOrder = new JButton("�ֹ�����");
		JButton menuOpenClose = new JButton("���¸���");
		JButton menuExit = new JButton("�ݱ�");
		
		menuOpenClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(main.menuMainPanel.jpMainMiddle.getComponent(0).getClass().getSimpleName().equals("SalesMain")) {
					ManagerCP.viewSuccess("�ϴ� ���� �޷¿��� �Է��� �ּ���.", "Ȯ��");
					return;
				}
				
				Calendar cal = Calendar.getInstance();
				DateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd");
				String thisDate = formatAll.format(cal.getTime());
				
				String sql = "select * from calculate where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('S', thisDate));
				
				if(ReturnModel.selConfirm(sql, psList)) {
					if(ManagerCP.viewConfirm(thisDate + "�� ���� ��� �Ͻðڽ��ϱ�?", "���� ���")) {
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
							ManagerCP.viewSuccess(thisDate + "�� ������ ��� �Ǿ����ϴ�.", "���� ���");
						} else {
							ManagerCP.viewError("���� ��� ����", "����");
						}
					}
				}else {
					if(ManagerCP.viewConfirm(thisDate + "�� ���� ��� �Ͻðڽ��ϱ�?", "���� ���")) {

						sql = "insert into calculate (CALCULATE_IDX, CALCULATE_IN_DATE, CALCULATE_IN_ID)";
						sql += " values(CALCULATE_IDX_SEQ.nextval, ?, ?)";
						
						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "�� ������ ��� �Ǿ����ϴ�.", "���� ���");
						} else {
							ManagerCP.viewError("���� ��� ����", "����");
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
					ManagerCP.viewError("�ϴ� ���� �޷¿��� �������� �մϴ�.", "�ȳ�");
					return;
				}
				
				Calendar cal = Calendar.getInstance();
				DateFormat formatAll = new SimpleDateFormat("yyyy-MM-dd");
				String thisDate = formatAll.format(cal.getTime());
				
				String sql = "select * from calculate where TO_CHAR(calculate_in_date, 'yyyy-mm-dd') = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('S', thisDate));
				
				if(ReturnModel.selConfirm(sql, psList)) {	// �������� ������
					
					sql = "select * from calculate where TO_CHAR(calculate_out_date, 'yyyy-mm-dd') = ?";
					psList = new ArrayList<>();
					psList.add(new PsList('S', thisDate));
					
					if(ReturnModel.selConfirm(sql, psList)) {	// �������� ������
						ManagerCP.viewError("�̹� ���� �Ǿ����ϴ�.", "����");
						return;
					}
					
					if(ManagerCP.viewConfirm(thisDate + "���� ���� �Ͻðڽ��ϱ�?", "���� ���")) {
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
							ManagerCP.viewSuccess(thisDate + "�� ������ ��� �Ǿ����ϴ�.", "���� ���");
							//
						} else {
							ManagerCP.viewError("���� ��� ����", "����");
						}						
					}
				}else {	// �������� ������
					if(ManagerCP.viewConfirm(thisDate + "���� ���� �Ͻðڽ��ϱ�?", "���� ���")) {
						sql = "insert into calculate (CALCULATE_IDX, CALCULATE_IN_DATE, CALCULATE_IN_ID)";
						sql += " values(CALCULATE_IDX_SEQ.nextval, ?, ?)";

						psList = new ArrayList<>();
						psList.add(new PsList('D', thisDate));
						psList.add(new PsList('S', main.mInfo.getMember_id()));
						if (OjdbcConnection.insert(sql, psList)) {
							ManagerCP.viewSuccess(thisDate + "�� ������ ��� �Ǿ����ϴ�.", "���� ���");							
						} else {
							ManagerCP.viewError("���� ��� ����", "����");
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
