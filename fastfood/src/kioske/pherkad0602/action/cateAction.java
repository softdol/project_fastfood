package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import kioske.pherkad0602.ui.HomePanel;

public class cateAction implements ActionListener{


	
	
	@Override

	  public void actionPerformed(ActionEvent e)
	    {	
			
	        JButton b = (JButton)e.getSource();//���õ� ��ư�� �˾Ƴ���.
	       
	        
	        if(b.getText().equals("Ȩ")) {
	        	System.out.println("Ȩ");
	        } else if(b.getText().equals("�ܹ���")) {
	        	
	        	System.out.println("�ܹ���");
	        } else if (b.getText().equals("���̵�")) {
	        	System.out.println("���̵�");
	        } else if(b.getText().equals("����")) {
	        	System.out.println("����");
	        } else if(b.getText().equals("����Ʈ")) {
	        	System.out.println("����Ʈ");
	        }
	           
	    }
}
