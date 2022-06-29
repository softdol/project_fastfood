package kioske.pherkad0602.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SetDatabase {
	
	private Integer SET_IDX;
	private String SET_NAME;
	private Integer SET_SALE;
	private String SET_USE_FLAG;
	private Date MENU_SUBCATEGORY_IN_DATE;
	private String SET_IN_ID;
	private Date SET_MOD_DATE;
	private String SET_MOD_ID;
	private Integer SET_PRICE;
	private String SET_IMG_PATH;
	private Integer MENU_IDX;
	
	
	public SetDatabase(ResultSet rs) throws SQLException{
		SET_IDX = rs.getInt(1);
		SET_NAME = rs.getString(2);
		SET_SALE  = rs.getInt(3);
		SET_USE_FLAG = rs.getString(4);
		MENU_SUBCATEGORY_IN_DATE = rs.getDate(5);
		SET_IN_ID = rs.getString(6);
		SET_MOD_DATE = rs.getDate(7);
		SET_MOD_ID = rs.getString(8);
		SET_PRICE = rs.getInt(9);
		SET_IMG_PATH = rs.getString(10);
		MENU_IDX = rs.getInt(11);
		
	}


	public Integer getSET_IDX() {
		return SET_IDX;
	}


	public void setSET_IDX(Integer sET_IDX) {
		SET_IDX = sET_IDX;
	}


	public String getSET_NAME() {
		return SET_NAME;
	}


	public void setSET_NAME(String sET_NAME) {
		SET_NAME = sET_NAME;
	}


	public Integer getSET_SALE() {
		return SET_SALE;
	}


	public void setSET_SALE(Integer sET_SALE) {
		SET_SALE = sET_SALE;
	}


	public String getSET_USE_FLAG() {
		return SET_USE_FLAG;
	}


	public void setSET_USE_FLAG(String sET_USE_FLAG) {
		SET_USE_FLAG = sET_USE_FLAG;
	}


	public Date getMENU_SUBCATEGORY_IN_DATE() {
		return MENU_SUBCATEGORY_IN_DATE;
	}


	public void setMENU_SUBCATEGORY_IN_DATE(Date mENU_SUBCATEGORY_IN_DATE) {
		MENU_SUBCATEGORY_IN_DATE = mENU_SUBCATEGORY_IN_DATE;
	}


	public String getSET_IN_ID() {
		return SET_IN_ID;
	}


	public void setSET_IN_ID(String sET_IN_ID) {
		SET_IN_ID = sET_IN_ID;
	}


	public Date getSET_MOD_DATE() {
		return SET_MOD_DATE;
	}


	public void setSET_MOD_DATE(Date sET_MOD_DATE) {
		SET_MOD_DATE = sET_MOD_DATE;
	}


	public String getSET_MOD_ID() {
		return SET_MOD_ID;
	}


	public void setSET_MOD_ID(String sET_MOD_ID) {
		SET_MOD_ID = sET_MOD_ID;
	}


	public Integer getSET_PRICE() {
		return SET_PRICE;
	}


	public void setSET_PRICE(Integer sET_PRICE) {
		SET_PRICE = sET_PRICE;
	}


	public String getSET_IMG_PATH() {
		return SET_IMG_PATH;
	}


	public void setSET_IMG_PATH(String sET_IMG_PATH) {
		SET_IMG_PATH = sET_IMG_PATH;
	}


	public Integer getMENU_IDX() {
		return MENU_IDX;
	}


	public void setMENU_IDX(Integer mENU_IDX) {
		MENU_IDX = mENU_IDX;
	}
	
	
}
