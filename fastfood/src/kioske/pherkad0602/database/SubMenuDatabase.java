package kioske.pherkad0602.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import kioske.pherkad0602.ui.ojdbcConnection;

public class SubMenuDatabase {
	private Integer MENU_SUBCATEGORY_IDX;
	private String MENU_SUBCATEGORY_NAME;
	private Integer MENU_CATEGORY_IDX;
	private Date MENU_SUBCATEGORY_IN_DATE;
	
	
	public SubMenuDatabase(ResultSet rs) throws SQLException{
		MENU_SUBCATEGORY_IDX = rs.getInt(1);
		MENU_SUBCATEGORY_NAME = rs.getString(2);
		MENU_CATEGORY_IDX  = rs.getInt(3);
		MENU_SUBCATEGORY_IN_DATE = rs.getDate(4);
	}
	
	

	
	public Integer getMENU_SUBCATEGORY_IDX() {
		return MENU_SUBCATEGORY_IDX;
	}

	public String getMENU_SUBCATEGORY_NAME() {
		return MENU_SUBCATEGORY_NAME;
	}

	public Integer getMENU_CATEGORY_IDX() {
		return MENU_CATEGORY_IDX;
	}

	public Date getMENU_SUBCATEGORY_IN_DATE() {
		return MENU_SUBCATEGORY_IN_DATE;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %s", MENU_SUBCATEGORY_IDX,MENU_SUBCATEGORY_NAME);
	}
}