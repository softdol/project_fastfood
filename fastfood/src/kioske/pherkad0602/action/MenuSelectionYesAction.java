package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kioske.pherkad0602.HomeMenuKiosk;

public class MenuSelectionYesAction implements ActionListener{
	
	HomeMenuKiosk hMain;

	public MenuSelectionYesAction(HomeMenuKiosk hMain) {
		this.hMain = hMain;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		JButton performedButton = (JButton)e.getSource();
		String name = performedButton.getName();
		
		if(name != null ) {
			
		} else {
			
			
		}
		
	
		checkFrame.dispose();
		
		
		
	}

}
