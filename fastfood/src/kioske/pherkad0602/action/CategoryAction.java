package kioske.pherkad0602.action;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.ui.MainPanel;
import manager.ManagerMain;

public class CategoryAction implements ActionListener{

	//private MainPanel main;
	//private JPanel Jpanel;
	HomeMenuKiosk hMain;
	int iCate;
	
	public CategoryAction(HomeMenuKiosk hMain, int iCate) {
		this.hMain = hMain;
		this.iCate = iCate;
//		this.Jpanel = mainPanel;
	}
	
	@Override

	  public void actionPerformed(ActionEvent e)
	    {	
			hMain.viewMenu(iCate);
//	        JButton b = (JButton)e.getSource();//���õ� ��ư�� �˾Ƴ���.
//	       
//	        if(b.getText().equals("Ȩ")) {
//	        	System.out.println("Ȩ");
//	        } else if(b.getText().equals("�ܹ���")) {
//				main.cardLayoutManager.show(Jpanel, "menu1");
//	        	System.out.println("�ܹ���");
//	        } else if (b.getText().equals("���̵�")) {
//	        	System.out.println("���̵�");
//	        } else if(b.getText().equals("����")) {
//	        	System.out.println("����");
//	        } else if(b.getText().equals("����Ʈ")) {
//	        	System.out.println("����Ʈ");
//	        }
	           
	    }
}
