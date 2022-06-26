package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {
	
	private Integer MENU_IDX;
	private Integer MENU_CATEGORY_IDX;
	private String IMG_BIG_PATH;
	private String MENU_NAME;
	private Integer MENU_PRICE;
	private Integer MENU_SALE;
	private String MENU_USE_FLAG;
	private String MENU_IN_DATE;
	private String MENU_IN_ID;
	private String MENU_MOD_DATE;
	private String MENU_MOD_ID;

	public Menu(int MENU_IDX, int MENU_CATEGORY_IDX, String IMG_BIG_PATH, String MENU_NAME, int MENU_PRICE,
				int MENU_SALE, String MENU_USE_FLAG, String MENU_IN_DATE, String MENU_IN_ID, String MENU_MOD_DATE,
				String MENU_MOD_ID) {
		this.MENU_IDX = MENU_IDX;
		this.MENU_CATEGORY_IDX = MENU_CATEGORY_IDX;
		this.IMG_BIG_PATH = IMG_BIG_PATH;
		this.MENU_NAME = MENU_NAME;
		this.MENU_PRICE = MENU_PRICE;
		this.MENU_SALE = MENU_SALE;
		this.MENU_USE_FLAG = MENU_USE_FLAG;
		this.MENU_IN_DATE = MENU_IN_DATE;
		this.MENU_IN_ID = MENU_IN_ID;
		this.MENU_MOD_DATE = MENU_MOD_DATE;
		this.MENU_MOD_ID = MENU_MOD_ID;
	}
	
	public Menu(ResultSet rs) throws SQLException {
		MENU_IDX = rs.getInt(1);
		MENU_CATEGORY_IDX = rs.getInt("MENU_CATEGORY_IDX");
		IMG_BIG_PATH = rs.getNString("IMG_BIG_PATH");
		MENU_NAME = rs.getNString("MENU_NAME");
		MENU_PRICE = rs.getInt("MENU_PRICE");
		MENU_SALE = rs.getInt("MENU_SALE");
		MENU_USE_FLAG = rs.getNString("MENU_USE_FLAG");
		MENU_IN_DATE = rs.getNString("MENU_IN_DATE");
		MENU_IN_ID = rs.getNString("MENU_IN_ID");
		MENU_MOD_DATE = rs.getNString("MENU_MOD_DATE");
		MENU_MOD_ID = rs.getNString("MENU_MOD_ID");
	}

	public Integer getMENU_IDX() {
		return MENU_IDX;
	}

	public void setMENU_IDX(Integer mENU_IDX) {
		MENU_IDX = mENU_IDX;
	}

	public Integer getMENU_CATEGORY_IDX() {
		return MENU_CATEGORY_IDX;
	}

	public void setMENU_CATEGORY_IDX(Integer mENU_CATEGORY_IDX) {
		MENU_CATEGORY_IDX = mENU_CATEGORY_IDX;
	}

	public String getIMG_BIG_PATH() {
		return IMG_BIG_PATH;
	}

	public void setIMG_BIG_PATH(String iMG_BIG_PATH) {
		IMG_BIG_PATH = iMG_BIG_PATH;
	}

	public String getMENU_NAME() {
		return MENU_NAME;
	}

	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}

	public Integer getMENU_PRICE() {
		return MENU_PRICE;
	}

	public void setMENU_PRICE(Integer mENU_PRICE) {
		MENU_PRICE = mENU_PRICE;
	}

	public Integer getMENU_SALE() {
		return MENU_SALE;
	}

	public void setMENU_SALE(Integer mENU_SALE) {
		MENU_SALE = mENU_SALE;
	}

	public String getMENU_USE_FLAG() {
		return MENU_USE_FLAG;
	}

	public void setMENU_USE_FLAG(String mENU_USE_FLAG) {
		MENU_USE_FLAG = mENU_USE_FLAG;
	}

	public String getMENU_IN_DATE() {
		return MENU_IN_DATE;
	}

	public void setMENU_IN_DATE(String mENU_IN_DATE) {
		MENU_IN_DATE = mENU_IN_DATE;
	}

	public String getMENU_IN_ID() {
		return MENU_IN_ID;
	}

	public void setMENU_IN_ID(String mENU_IN_ID) {
		MENU_IN_ID = mENU_IN_ID;
	}

	public String getMENU_MOD_DATE() {
		return MENU_MOD_DATE;
	}

	public void setMENU_MOD_DATE(String mENU_MOD_DATE) {
		MENU_MOD_DATE = mENU_MOD_DATE;
	}

	public String getMENU_MOD_ID() {
		return MENU_MOD_ID;
	}

	public void setMENU_MOD_ID(String mENU_MOD_ID) {
		MENU_MOD_ID = mENU_MOD_ID;
	}
	
	
}






























