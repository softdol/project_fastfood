package kioske.pherkad0602.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.manager.Category;
import database.manager.ReturnModel;
import database.model.PsList;
import kioske.pherkad0602.database.SubMenuDatabase;

public class MainPanel extends JPanel{
	public CardLayout cardLayoutManager = new CardLayout();
	//public static JPanel mainPanel = new JPanel();

	public MainPanel() {
		
		EmptyBorder border = new EmptyBorder(getInsets());
		

		ArrayList<Category> cataList = ReturnModel.categoryList();
		
		
		//ArrayList name = SubMenuDatabase.subMenuNameArray(sql);
		//ArrayList cateIdx = SubMenuDatabase.menuCategoryIdxArray(sql); 
		
		HomePanel home = new HomePanel();		
		//add("home",home.HomePanel());
		JPanel jp = new JPanel();
		
		for(int i = 0; i < cataList.size() ; i++) {
			//System.out.println(sList.get(i));
//			String j = String.valueOf(cateIdx.get(i));
			//System.out.println(cataList.get(i).getMenu_category_idx() + " : " + cataList.get(i).getMenu_category_name());
			
			String sql = "SELECT * FROM Menu_subcategory where menu_category_IDX = ?";
			
			ArrayList<SubMenuDatabase> sList = new ArrayList<>();
			ArrayList<PsList> psList = new ArrayList<>();
			psList.add(new PsList('I', String.valueOf(cataList.get(i).getMenu_category_idx())));
//			System.out.println();
			sList = ReturnModel.selSubCateList(sql, psList);
			
			MenuPanel menu = new MenuPanel(sList);
			add(menu,"menu" + i);
			for(SubMenuDatabase s : sList) {
				System.out.println(s);
			}
//			System.out.println();
			
//			
//			String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = " + i;
//			String sql2 = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = " + i;
//	
			
		}
		setLayout(cardLayoutManager);
		jp.setBounds(0, 0, 684, 800);
		jp.setBackground(Color.black);
		//add(jp);
		cardLayoutManager.show(this, "menu3");
		setBounds(200, 0, 684, 800);
		
		setBackground(Color.white);
		setBorder(border);
		
		//return mainPanel;
	}
	
//	public static void main(String[] args) {
//		new
//	}
//	
	
}
