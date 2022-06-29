package kioske.pherkad0602.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EventDatabase {
	
	private Integer EVENT_PAGE_NUMBER;
	private String BIG_EVENT_PAGE;
	private String SMALL_EVENT_PAGE;
	private Integer MENU_IDX;
	
	
	public EventDatabase(ResultSet rs) throws SQLException{
		this.EVENT_PAGE_NUMBER = rs.getInt(1);
		this.BIG_EVENT_PAGE = rs.getString(2);
		this.SMALL_EVENT_PAGE = rs.getString(3);
		this.MENU_IDX = rs.getInt(4);
		
	}


	public Integer getEVENT_PAGE_NUMBER() {
		return EVENT_PAGE_NUMBER;
	}


	public void setEVENT_PAGE_NUMBER(Integer eVENT_PAGE_NUMBER) {
		EVENT_PAGE_NUMBER = eVENT_PAGE_NUMBER;
	}


	public String getBIG_EVENT_PAGE() {
		return BIG_EVENT_PAGE;
	}


	public void setBIG_EVENT_PAGE(String bIG_EVENT_PAGE) {
		BIG_EVENT_PAGE = bIG_EVENT_PAGE;
	}


	public String getSMALL_EVENT_PAGE() {
		return SMALL_EVENT_PAGE;
	}


	public void setSMALL_EVENT_PAGE(String sMALL_EVENT_PAGE) {
		SMALL_EVENT_PAGE = sMALL_EVENT_PAGE;
	}


	public Integer getMENU_IDX() {
		return MENU_IDX;
	}


	public void setMENU_IDX(Integer mENU_IDX) {
		MENU_IDX = mENU_IDX;
	}

	
}	
