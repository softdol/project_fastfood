package kioske.pherkad0602.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.manager.Category;
import database.model.PsList;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.database.SubMenuDatabase;

public class MainPanel extends JPanel{
	public CardLayout cardLayoutManager = new CardLayout();
	HomeMenuKiosk hMain;
	public MainPanel(HomeMenuKiosk hMain) {
		this.hMain = hMain;
		
		EmptyBorder border = new EmptyBorder(getInsets());
		
		
		
		ArrayList<Category> cataList = ReturnModel.categoryList();
		ArrayList<SubMenuDatabase> subCateList = ReturnModel.subCateList("select * from menu_subcategory");
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList("select*from Menu");

		
		setLayout(cardLayoutManager);
		
		int a= 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		for(int i = 0; i < subCateList.size() ; i++) {
			
			String sql1 = "SELECT * FROM Menu_subcategory where menu_category_IDX = ?";
			String sql2 = "SELECT * FROM Menu WHERE Menu_subcategory_IDX = ? ";
			
			
			if(subCateList.get(i).getMENU_CATEGORY_IDX().equals(1)) {
				ArrayList<SubMenuDatabase> sList1 = new ArrayList<>();
				ArrayList<MenuDatabase> sList2 = new ArrayList<>();
				
				ArrayList<PsList> psList1 = new ArrayList<>();
				ArrayList<PsList> psList2 = new ArrayList<>();

				psList1.add(new PsList('I', "1"));
				sList1 = ReturnModel.selSubCateList(sql1, psList1);
				
				psList2.add(new PsList('I', String.valueOf(i)));
				sList2 = ReturnModel.selMenuList1(sql2, psList2);
				
				MenuPanel menu = new MenuPanel(sList1, sList2, hMain, a);
				add(subCateList.get(i).getMENU_SUBCATEGORY_NAME(), menu);
				a++;
				System.out.println(psList1);
			} else if (subCateList.get(i).getMENU_CATEGORY_IDX().equals(2)) {
				ArrayList<SubMenuDatabase> sList1 = new ArrayList<>();
				ArrayList<MenuDatabase> sList2 = new ArrayList<>();
				
				ArrayList<PsList> psList1 = new ArrayList<>();
				ArrayList<PsList> psList2 = new ArrayList<>();

				
				psList1.add(new PsList('I', "2"));
				sList1 = ReturnModel.selSubCateList(sql1, psList1);
				
				psList2.add(new PsList('I', String.valueOf(i)));
				sList2 = ReturnModel.selMenuList1(sql2, psList2);
				
				MenuPanel menu = new MenuPanel(sList1, sList2,hMain, b);
				add(subCateList.get(i).getMENU_SUBCATEGORY_NAME() , menu);
				b++;
				System.out.println(psList1);		
			} else if (subCateList.get(i).getMENU_CATEGORY_IDX().equals(3)) {
				ArrayList<SubMenuDatabase> sList1 = new ArrayList<>();
				ArrayList<MenuDatabase> sList2 = new ArrayList<>();
				
				ArrayList<PsList> psList1 = new ArrayList<>();
				ArrayList<PsList> psList2 = new ArrayList<>();

				
				psList1.add(new PsList('I', "3"));
				sList1 = ReturnModel.selSubCateList(sql1, psList1);
				
				psList2.add(new PsList('I', String.valueOf(i)));
				sList2 = ReturnModel.selMenuList1(sql2, psList2);
				
				MenuPanel menu = new MenuPanel(sList1, sList2,hMain, c);
				add(subCateList.get(i).getMENU_SUBCATEGORY_NAME(), menu);
				c++;
				System.out.println(psList1);		
			} else if (subCateList.get(i).getMENU_CATEGORY_IDX().equals(4)) {
				ArrayList<SubMenuDatabase> sList1 = new ArrayList<>();
				ArrayList<MenuDatabase> sList2 = new ArrayList<>();
				
				ArrayList<PsList> psList1 = new ArrayList<>();
				ArrayList<PsList> psList2 = new ArrayList<>();

				
				psList1.add(new PsList('I', "4"));
				sList1 = ReturnModel.selSubCateList(sql1, psList1);
				
				psList2.add(new PsList('I', String.valueOf(i)));
				sList2 = ReturnModel.selMenuList1(sql2, psList2);
				
				MenuPanel menu = new MenuPanel(sList1, sList2,hMain, d);
				add(subCateList.get(i).getMENU_SUBCATEGORY_NAME() , menu);
				d++;
				System.out.println(psList1);		
			}
		}
		HomePanel home = new HomePanel();		
		add("Ȩ",home);
		cardLayoutManager.show(this, "menu3");
		setBounds(200, 0, 684, 800);
		
		setBackground(Color.white);
		setBorder(border);
		
	
	}
	

	
}
