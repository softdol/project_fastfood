package kioske.pherkad0602.ui;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

public class test {
	public static void main(String[] args) {
	
			
		
		String sql = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = 1";

		System.out.println(SubMenuDatabase.subMenuNameArray(sql)); 
	}

}
