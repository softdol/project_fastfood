package manager.menu;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import database.manager.Member;
import manager.ManagerMain;

public class MenuMainPanel extends JPanel{
	
	MenuInsertPanel menuIns;
	MenuList		menuList;
	public Member mInfo;
	
	public void viewUpImg(String path) {
		ImageIcon icon = new ImageIcon(path);
		menuIns.txtImgPath.setText(path);
		
		Image img = icon.getImage();
		//System.out.println("img path : " + menuIns.txtImgPath.getText());
		Image cimg = img.getScaledInstance(menuIns.lblImg.getWidth(),menuIns.lblImg.getHeight(),img.SCALE_SMOOTH);		
		menuIns.lblImg.setIcon(new ImageIcon(cimg));
	}
	
	public MenuMainPanel(Member mInfo) {
		setLayout(null);
		setBounds(0,0,1185,730);
		
		this.mInfo = mInfo;
		// 상품 등록
		//menuIns = new MenuInsertPanel(this);
		//add(menuIns);
		
		// 상품 목록
		menuList = new MenuList(this);
		add(menuList);
		
	}
	
	

}
