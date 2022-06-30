
package pos.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pos.Pos_Burger;

public class SubCateActionListener implements ActionListener {
	Pos_Burger main;
	int iCate;
	
	public SubCateActionListener(Pos_Burger main, int iCate) {
		this.main = main;
		this.iCate = iCate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.viewMenuList(iCate);
	}

}
