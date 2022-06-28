package kioske.pherkad0602.action;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import kioske.pherkad0602.ui.MainPanel;
import manager.ManagerMain;

public class CategoryAction implements ActionListener{

	private MainPanel main;
	private JPanel Jpanel;
	
	public CategoryAction(MainPanel main, JPanel mainPanel) {
		this.main = main;
		this.Jpanel = mainPanel;
	}
	
	@Override

	  public void actionPerformed(ActionEvent e)
	    {	
			
	        JButton b = (JButton)e.getSource();//선택된 버튼을 알아낸다.
	       
	        if(b.getText().equals("홈")) {
	        	System.out.println("홈");
	        } else if(b.getText().equals("햄버거")) {
				main.cardLayoutManager.show(Jpanel, "menu1");
	        	System.out.println("햄버거");
	        } else if (b.getText().equals("사이드")) {
	        	System.out.println("사이드");
	        } else if(b.getText().equals("음료")) {
	        	System.out.println("음료");
	        } else if(b.getText().equals("디저트")) {
	        	System.out.println("디저트");
	        }
	           
	    }
}
