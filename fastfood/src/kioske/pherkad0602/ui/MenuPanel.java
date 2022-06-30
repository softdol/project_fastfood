package kioske.pherkad0602.ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;

import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.database.SubMenuDatabase;

public class MenuPanel extends JPanel{
	
	HomeMenuKiosk hMain;
	
	public MenuPanel(HomeMenuKiosk hMain, int i, ArrayList<SubMenuDatabase> subCateList, String subTitle, Main_JFrame frame){
		EmptyBorder border = new EmptyBorder(getInsets());
		this.hMain = hMain;

		// 서브카테고리
		SubMenuPanel sub = new SubMenuPanel(subCateList, hMain);
		add(sub);
		
		// 서브 카테고리 타이틀
		MenuNamePanel mName = new MenuNamePanel(subTitle);
		add(mName);
		
		// 아래 목록
		ArrayList<PsList> psList2 = new ArrayList<>();

		
		psList2.add(new PsList('I', String.valueOf(i)));
		ArrayList<MenuDatabase> menuList = ReturnModel.selMenuList1("SELECT * FROM Menu WHERE Menu_subcategory_IDX = ? ", psList2);
		MainMenuPanel main = new MainMenuPanel(menuList, hMain, frame);
		add(main);
		
		setBounds(200, 0, 884, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);

	}



}
