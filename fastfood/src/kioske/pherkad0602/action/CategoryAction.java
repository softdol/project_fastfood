package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kioske.pherkad0602.HomeMenuKiosk;

public class CategoryAction implements ActionListener{

	HomeMenuKiosk hMain;
	int iCate;
	
	public CategoryAction(HomeMenuKiosk hMain) {
		this.hMain = hMain;
		this.iCate = iCate;

	}
	
	@Override

	  public void actionPerformed(ActionEvent e)
	    {	
			JButton performedButton = (JButton)e.getSource();
		
			String name = performedButton.getName();
			hMain.viewMenu(name);
	           
	    }
}
