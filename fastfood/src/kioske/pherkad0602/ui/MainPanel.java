package kioske.pherkad0602.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.manager.Category;
import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.database.SubMenuDatabase;

public class MainPanel extends JPanel{
	public CardLayout cardLayoutManager = new CardLayout();
	HomeMenuKiosk hMain;
	public MainPanel(HomeMenuKiosk hMain, Main_JFrame frame) {
		this.hMain = hMain;
		
		EmptyBorder border = new EmptyBorder(getInsets());
		
		ArrayList<Category> cataList = ReturnModel.categoryList();
		
		setLayout(cardLayoutManager);
		
		HomePanel home = new HomePanel(hMain, frame);		
		add("Ȩ",home);
		
		for(int j = 0; j < cataList.size() ; j++) {
			ArrayList<PsList> psList = new ArrayList<>();
			psList.add(new PsList('I', String.valueOf(cataList.get(j).getMenu_category_idx())));
			ArrayList<SubMenuDatabase> subCateList = ReturnModel.subCateList("select * from menu_subcategory where MENU_CATEGORY_IDX = ?", psList);
			for(int i = 0; i < subCateList.size() ; i++) {
				MenuPanel menu = new MenuPanel(hMain, subCateList.get(i).getMENU_SUBCATEGORY_IDX(), subCateList, subCateList.get(i).getMENU_SUBCATEGORY_NAME(), frame);
				add(subCateList.get(i).getMENU_SUBCATEGORY_NAME(), menu);
			}
		}
		

		cardLayoutManager.show(this, "menu3");
		setBounds(200, 0, 684, 800);
		
		setBackground(Color.white);
		setBorder(border);
		
	
	}
	

	
}
