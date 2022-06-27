package manager.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Category;
import database.manager.Menu;
import database.manager.MenuSet;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ImgUpActionListener;
import manager.actionlistener.SetDelActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MenuSetModify extends JPanel {

	public JLabel lblImg;
	public JTextField txtImgPath;
	ManagerMain main;
	
	JPanel jpSetList;
	ArrayList<Menu> menuList;
	ArrayList<Menu> setMenuList;
	ArrayList<Menu> repList;
	
	JComboBox<String> bottomTitleCate;
	JComboBox<String> bottomTitleInfo;
	ArrayList<Category> cataList;
	MenuSet menuInfo;
	boolean chgSetList = false;
	
	public MenuSetModify(ManagerMain main, int idx) {
		this.main = main;
		main.setSize(585,780);
		
		setLayout(null);
		setBounds(0,0,565,730);
		//setBorder(new LineBorder(Color.BLACK));
		
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu_set where set_idx = ?";
		psList.add(new PsList('I', String.valueOf(idx)));
		
		menuInfo = ReturnModel.selMenuSet(sql, psList);
		
		if(menuInfo == null) {
			System.out.println("세트 정보가 없습니다.");
			//main.viewPanel("세트메뉴목록");
			return;
		}
		
		LabelTitle lblTitle = new LabelTitle("세트 상품 수정");		
		add(lblTitle);
	
		LabelSub lblName = new LabelSub("메뉴명", lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20);
		LabelSub lblPrice = new LabelSub("가격", lblName.getX(), lblName.getY() + lblName.getHeight() + 20);
		LabelSub lblSale = new LabelSub("할인율", lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20);
		LabelSub lblRep = new LabelSub("대표메뉴", lblSale.getX(), lblSale.getY() + lblSale.getHeight() + 20, 100, 40);
		add(lblName);
		add(lblPrice);
		add(lblSale);
		add(lblRep);
		
		TextFieldSub txtName = new TextFieldSub(menuInfo.getSet_name(), lblName.getX() + lblName.getWidth() + 20, lblName.getY());
		TextFieldSub txtPrice = new TextFieldSub(String.valueOf(menuInfo.getSet_price()), txtName.getX(), lblPrice.getY());
		TextFieldSub txtSale = new TextFieldSub(String.valueOf(menuInfo.getSet_sale()), txtName.getX(), lblSale.getY());
		JComboBox cbRep = new JComboBox();
		
		String sqlRep = "select * from menu where MENU_CATEGORY_IDX = ?";
		repList = new ArrayList<>();
		
		psList = new ArrayList<>();
		psList.add(new PsList('I',"1"));
		
		repList = ReturnModel.selMenuList(sqlRep, psList);
	
		cbRep.setBounds(txtName.getX(),lblRep.getY(),160,40);
		cbRep.addItem("----------대표메뉴----------");
		for(int i = 0; i < repList.size(); i++) {
			cbRep.addItem(repList.get(i).getMenu_name() + "("+ repList.get(i).getMenu_price()  +")");
			if(repList.get(i).getMenu_idx() == menuInfo.getSet_rep()) {
				cbRep.setSelectedIndex(i+1);
			}
		}
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		add(cbRep);
		//JComboBox
		
		//System.out.println(menuInfo.getSet_rep());
		
		lblImg = new JLabel(new ImageIcon(ManagerCP.imgResize(menuInfo.getSet_img_path(),180,160)));
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, txtName.getY() , 180, 160);
		
		//lblImg.pic
		
		JButton btnImg = new JButton("이미지 찾기");
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("정보 수정 ↑");
		btnInsert.setFont(new Font("고딕체", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, btnImg.getY() + btnImg.getHeight() + 40 , 120, 40);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean inputChk = true;
				
				if(txtName.getText().trim().length() == 0) {					
					ManagerCP.viewError("메뉴명을 입력해 주세요.","입력오류");
					txtName.requestFocus();
					inputChk = false;
					return;
				}
				if(txtPrice.getText().trim().length() == 0) {
					ManagerCP.viewError("가격을 입력해 주세요.","입력오류");
					txtPrice.requestFocus();
					inputChk = false;
					return;
				}
				if(txtSale.getText().trim().length() == 0) {
					ManagerCP.viewError("할인율을 입력해 주세요.","입력오류");
					txtSale.requestFocus();
					inputChk = false;
					return;
				}
				if(cbRep.getSelectedIndex() == 0) {
					ManagerCP.viewError("대표 메뉴를 선택해 주세요.","입력오류");
					cbRep.requestFocus();
					inputChk = false;
					return;		
				}
				
				if(!main.mInfo.getLogin()) {
					ManagerCP.viewError("담당자 정보가 없습니다.","로그인 오류");
					inputChk = false;
					return;
				}
				
				
				if(inputChk) {
					ArrayList<PsList> psList = new ArrayList<>();
					
					String[] fileName = txtImgPath.getText().split("\\.");
					String fileExt = "";
					String filePath = "imgSetUpload";
					
					if(fileName.length > 1) {
						fileExt = System.currentTimeMillis() + "." + fileName[1];
						ManagerCP.fileSave(new File(txtImgPath.getText()), filePath,fileExt);
						
						File delFile = new File(menuInfo.getSet_img_path());
						
						if(delFile.exists()) {
							delFile.delete();
						}
						
						psList.add(new PsList('S',filePath + "\\" + fileExt));
					}else {
						psList.add(new PsList('S',menuInfo.getSet_img_path()));
					}
					
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',main.mInfo.getMember_id()));					
					psList.add(new PsList('I',repList.get(cbRep.getSelectedIndex()-1).getMenu_idx().toString()));
					psList.add(new PsList('I',String.valueOf(menuInfo.getSet_idx())));
					
					String sqi_menuUpt = "update menu_set";
							sqi_menuUpt += " set SET_IMG_PATH = ?";
							sqi_menuUpt += " ,SET_NAME = ?";
							sqi_menuUpt += " ,SET_PRICE = ?";
							sqi_menuUpt += " ,SET_SALE = ?";
							sqi_menuUpt += " ,SET_MOD_DATE = sysdate";
							sqi_menuUpt += " ,SET_MOD_ID = ?";
							sqi_menuUpt += " ,SET_REP = ?";
							sqi_menuUpt += " where SET_IDX = ?";
		
					if(OjdbcConnection.insert(sqi_menuUpt, psList)) {
						ManagerCP.viewSuccess("상품이 수정 되었습니다.","상품수정");
						main.viewPanel("세트메뉴목록");
					}else{
						ManagerCP.viewError("상품 등록에 실패했습니다.","실패");
					};
					
				}
			}
		});
		
		JButton btnSetList = new JButton("목록 보기");
		btnSetList.setFont(new Font("고딕체", Font.BOLD, 14));
		btnSetList.setBounds(btnInsert.getX() + btnInsert.getWidth() + 20, btnInsert.getY() , 100, 40);
		btnSetList.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				main.viewPanel("세트메뉴목록");
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		
		add(btnImg);
		add(lblImg);
		add(txtImgPath);
		
		add(btnInsert);
		add(btnSetList);
		
		
		JButton btnListInsert = new JButton("세트 메뉴 수정 ↓");
		btnListInsert.setFont(new Font("고딕체", Font.BOLD, 14));
		btnListInsert.setBounds(btnSetList.getX() + btnSetList.getWidth() + 50, btnSetList.getY(), 150, 40);
		btnListInsert.addActionListener(new SetDelActionListener(this, 0, 'I'));
		
		add(btnListInsert);
		// 세트 메뉴 단품 추가 부분
		// 배열로 저장해서 전체 불러오면 셋팅하는 식을 바꿔야 할거 같음
		
		JPanel jpTopTitle = new JPanel();
		
		JLabel topTitleCate = new JLabel("카테고리",0);
		JLabel topTitleInfo = new JLabel("메뉴정보",0);
		JLabel topTitleBtn = new JLabel("추가/삭제", 0);
		
		jpTopTitle.setLayout(null);
		
		jpTopTitle.setBounds(0, btnSetList.getY() + btnSetList.getHeight() + 20, 565, 40);
		//jpTopTitle.setBackground(Color.GREEN);
		
		topTitleCate.setBounds(0, 0, 160, 40);
		//topTitleCate.setBorder(new LineBorder(Color.red));
		topTitleInfo.setBounds(180, 0, 230, 40);
		//topTitleInfo.setBorder(new LineBorder(Color.red));
		topTitleBtn.setBounds(430, 0, 110, 40);
		//topTitleBtn.setBorder(new LineBorder(Color.red));
		
		jpTopTitle.add(topTitleCate);
		jpTopTitle.add(topTitleInfo);
		jpTopTitle.add(topTitleBtn);
		
		add(jpTopTitle);
		
		jpSetList = new JPanel();
		jpSetList.setLayout(null);
		jpSetList.setPreferredSize(new Dimension(565, 0));
		jpSetList.setBackground(Color.WHITE);
		
		JScrollPane scPane = new JScrollPane(jpSetList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scPane.getVerticalScrollBar().setUnitIncrement(16);		
		scPane.setBounds(0, jpTopTitle.getY() + jpTopTitle.getHeight(), 565, 180);
		
		add(scPane);
		
		
		JPanel jpBottomInput = new JPanel();
		
		cataList = ReturnModel.categoryList();
		
		bottomTitleCate = new JComboBox();
		bottomTitleInfo = new JComboBox();
		bottomTitleInfo.addItem("--메뉴--");
		
		bottomTitleCate.addItem("--대분류--");
		for(Category c : cataList) {
			bottomTitleCate.addItem(c.getMenu_category_name());
		}
		bottomTitleCate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox thisCb = (JComboBox)e.getSource();
				if(thisCb.getSelectedIndex() != 0) {
					int selNum = cataList.get(thisCb.getSelectedIndex()-1).getMenu_category_idx();
					bottomTitleInfo.removeAllItems();
					String sqlMenu = "select * from menu where MENU_CATEGORY_IDX = ?";
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('I', String.valueOf(selNum)));
					menuList = ReturnModel.selMenuList(sqlMenu, psList);
					
					bottomTitleInfo.addItem("--메뉴--");
					for(Menu m : menuList) {
						bottomTitleInfo.addItem(m.getMenu_name() + "("+m.getMenu_price()+")");
					}
				}
			}
		});
		
		setMenuList = new ArrayList<>();
		String sqlSetMenuList = "select m.* from menu m ";
				sqlSetMenuList += " INNER JOIN menu_set_list s on m.menu_idx = s.menu_idx";
				sqlSetMenuList += "  where s.set_idx = ?";
		psList = new ArrayList<>();
		psList.add(new PsList('I', menuInfo.getSet_idx().toString()));
		setMenuList = ReturnModel.selMenuList(sqlSetMenuList, psList);
		
		setView();
		
		JButton bottomTitleBtn = new JButton("추가");
		bottomTitleBtn.addActionListener(new SetDelActionListener(this, 0, 'P'));
		
		jpBottomInput.setLayout(null);
		
		jpBottomInput.setBounds(0, scPane.getY() + scPane.getHeight(), 565, 40);
		//jpBottomInput.setBackground(Color.GREEN);
		
		bottomTitleCate.setBounds(0, 0, 160, 40);
		//bottomTitleCate.setBorder(new LineBorder(Color.red));
		bottomTitleInfo.setBounds(180, 0, 230, 40);
		//bottomTitleInfo.setBorder(new LineBorder(Color.red));
		bottomTitleBtn.setBounds(430, 0, 110, 40);
		//bottomTitleBtn.setBorder(new LineBorder(Color.red));
		
		jpBottomInput.add(bottomTitleCate);
		jpBottomInput.add(bottomTitleInfo);
		jpBottomInput.add(bottomTitleBtn);
		
		add(jpBottomInput);
	}
	
	public void addSetMenu() {
		int menuIdx = bottomTitleInfo.getSelectedIndex()-1;
		if(menuIdx >= 0) {
			setMenuList.add(menuList.get(menuIdx));
			setView();
			chgSetList = true;
		}else {
			ManagerCP.viewError("메뉴를 선택해 주세요.", "선택에러");
		}
	}
	
	public void delSetMenu(int idx) {		
		setMenuList.remove(idx);		
		setView();
		chgSetList = true;
	}
	
	public void setView() {
		ManagerCP.reFresh(jpSetList);
		int listCount = setMenuList.size();
		jpSetList.setPreferredSize(new Dimension(565, listCount * 45 + 45));
		
		for(int i = 0; i < listCount; i++) {
			Menu m = setMenuList.get(i);
			JPanel tempJp = new JPanel();
			
			tempJp.setLayout(null);				
			tempJp.setBounds(0, 45 * i, 560, 40);
			//tempJp.setBorder(new LineBorder(Color.RED));
			
			JLabel tempCate = new JLabel(getCateName(m.getMenu_category()), 0); 
			JLabel tempInfo = new JLabel(m.getMenu_name() + "("+m.getMenu_price()+")", 0);
			JButton tempBtn = new JButton("삭제");
			
			tempCate.setBounds(0, 0, 160, 40);
			//tempCate.setBorder(new LineBorder(Color.red));
			tempInfo.setBounds(180, 0, 230, 40);
			//tempInfo.setBorder(new LineBorder(Color.red));
			tempBtn.setBounds(430, 0, 110, 40);
			//tempBtn.setBorder(new LineBorder(Color.red));
			
			tempJp.add(tempCate);
			tempJp.add(tempInfo);
			tempJp.add(tempBtn);
			
			tempBtn.addActionListener(new SetDelActionListener(this, i, 'D'));
			
			jpSetList.add(tempJp);
		}
		
		jpSetList.revalidate();
		jpSetList.repaint();
	}
	
	public String getCateName(int cateIdx) {
		for(Category c : cataList) {
			if (c.getMenu_category_idx() == cateIdx) {
				return c.getMenu_category_name();
			}
		}
		return null;
	}
	
	public void insSetMenu() {
		
		if(!chgSetList) {
			ManagerCP.viewError("변동 내용이 없습니다.", "에러");
			return;
		}
		
		System.out.println(menuInfo.getSet_idx());
		String sIdx = menuInfo.getSet_idx().toString();
		int setListCnt = setMenuList.size();
		if(setListCnt > 0) {
			// 전부 삭제
			ArrayList<PsList> psList = new ArrayList<>();
			psList.add(new PsList('I', sIdx));
			OjdbcConnection.insert("delete from menu_set_list where set_idx = ?", psList);			
			
			// 전부 추가
			for(Menu m :setMenuList) {
				String sqlSetList = "insert into menu_set_list(LIST_IDX, SET_IDX, MENU_IDX, LIST_IN_DATE, LIST_IN_ID)";
						sqlSetList += "values(MENU_SET_LIST_IDX_SEQ.nextval, ?, ?, sysdate, ?)";
				psList = new ArrayList<>();
				psList.add(new PsList('I', sIdx));
				psList.add(new PsList('I', m.getMenu_idx().toString()));
				psList.add(new PsList('S', main.mInfo.getMember_id()));
				OjdbcConnection.insert(sqlSetList, psList);
			}
			chgSetList = false;
			ManagerCP.viewSuccess("메뉴가 수정 되었습니다.", "성공");			
		}else {
			ManagerCP.viewError("추가된 메뉴가 없습니다.", "에러");
		}
	}
}









