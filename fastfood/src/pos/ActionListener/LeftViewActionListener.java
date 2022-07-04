package pos.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pos.Pos_Burger;

public class LeftViewActionListener implements ActionListener {
	Pos_Burger main;
	int idx;
	
	public LeftViewActionListener(Pos_Burger main, int idx) {
		this.main = main;
		this.idx = idx;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.viewLeftList(idx);
	}

}
