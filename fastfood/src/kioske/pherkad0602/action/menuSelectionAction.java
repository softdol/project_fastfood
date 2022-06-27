package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kioske.pherkad0602.ui.OrderCheck;

public class menuSelectionAction implements ActionListener{
	
	public void actionPerformed(ActionEvent e)
    {
     
        new OrderCheck();
        }
           
 }
	

