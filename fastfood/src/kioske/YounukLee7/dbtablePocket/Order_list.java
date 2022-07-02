package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

import kioske.pherkad0602.database.MenuDatabase;

public class Order_list {
	
	private Integer ORDER_IDX;
	private Integer MENU_IDX;
	private Integer ORDER_STATE;
	private Integer ORDER_PRICE;
	private Integer ORDER_QUANTITY;
	private Integer ORDER_PRICE_TOTAL;
	private String ORDER_MOD_DATE;
	private String MENU_NAME;
	private String ORDER_IN_DATE;
	private Integer SET_IDX;
	private String img_path;
	public Integer getMENU_SALE() {
		return MENU_SALE;
	}


	public void setMENU_SALE(Integer mENU_SALE) {
		MENU_SALE = mENU_SALE;
	}


	public void setORDER_IDX(Integer oRDER_IDX) {
		ORDER_IDX = oRDER_IDX;
	}


	public void setMENU_IDX(Integer mENU_IDX) {
		MENU_IDX = mENU_IDX;
	}


	public void setORDER_STATE(Integer oRDER_STATE) {
		ORDER_STATE = oRDER_STATE;
	}


	public void setORDER_PRICE(Integer oRDER_PRICE) {
		ORDER_PRICE = oRDER_PRICE;
	}


	public void setORDER_QUANTITY(Integer oRDER_QUANTITY) {
		ORDER_QUANTITY = oRDER_QUANTITY;
	}


	public void setORDER_PRICE_TOTAL(Integer oRDER_PRICE_TOTAL) {
		ORDER_PRICE_TOTAL = oRDER_PRICE_TOTAL;
	}


	public void setORDER_MOD_DATE(String oRDER_MOD_DATE) {
		ORDER_MOD_DATE = oRDER_MOD_DATE;
	}


	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}


	public void setORDER_IN_DATE(String oRDER_IN_DATE) {
		ORDER_IN_DATE = oRDER_IN_DATE;
	}


	public void setSET_IDX(Integer sET_IDX) {
		SET_IDX = sET_IDX;
	}

	private Integer MENU_SALE;
	
	public Order_list(ResultSet rs) throws SQLException {
		ORDER_IDX			= rs.getInt("ORDER_IDX");
		MENU_IDX			= rs.getInt("MENU_IDX");
		ORDER_STATE			= rs.getInt("ORDER_STATE");
		ORDER_PRICE			= rs.getInt("ORDER_PRICE");
		ORDER_QUANTITY		= rs.getInt("ORDER_QUANTITY");
		ORDER_PRICE_TOTAL	= rs.getInt("ORDER_PRICE_TOTAL");
		ORDER_MOD_DATE		= rs.getString("ORDER_MOD_DATE");
		MENU_NAME			= rs.getString("MENU_NAME");
		ORDER_IN_DATE		= rs.getString("ORDER_IN_DATE");
		SET_IDX				= rs.getInt("SET_IDX");
		MENU_SALE			= rs.getInt("MENU_SALE");
	}
	
	
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	public String getImg_path() {
		return img_path;
	}
	
	public Order_list(Menu m, int cnt, int set_idx) {
		this.MENU_IDX			= m.getMENU_IDX();
		this.ORDER_STATE		= 0;
		this.ORDER_PRICE		= m.getMENU_PRICE();
		this.ORDER_QUANTITY		= cnt;
		this.ORDER_PRICE_TOTAL	= m.getMENU_PRICE() * cnt;		
		this.MENU_NAME			= m.getMENU_NAME();
		this.SET_IDX			= set_idx;
	}

	public Order_list(database.manager.Menu m, int cnt, int set_idx) {
		// TODO Auto-generated constructor stub
		this.MENU_IDX			= m.getMenu_idx();
		this.ORDER_STATE		= 0;
		this.ORDER_PRICE		= m.getMenu_price();
		this.ORDER_QUANTITY		= cnt;
		this.ORDER_PRICE_TOTAL	= m.getMenu_price() * cnt;		
		this.MENU_NAME			= m.getMenu_name();
		this.SET_IDX			= set_idx;
		this.img_path			= m.getImg_big_path();
		this.MENU_SALE			= m.getMenu_sale();
	}
	
	public Order_list(MenuDatabase m, int cnt, int set_idx) {
		// TODO Auto-generated constructor stub
		this.MENU_IDX			= m.getMenu_idx();
		this.ORDER_STATE		= 0;
		this.ORDER_PRICE		= m.getMenu_price();
		this.ORDER_QUANTITY		= cnt;
		this.ORDER_PRICE_TOTAL	= m.getMenu_price() * cnt;		
		this.MENU_NAME			= m.getMenu_name();
		this.SET_IDX			= set_idx;
		this.img_path			= m.getImg_big_path();
		this.MENU_SALE			= m.getMenu_sale();

	}


	public Integer getORDER_IDX() {
		return ORDER_IDX;
	}

	public Integer getMENU_IDX() {
		return MENU_IDX;
	}

	public Integer getORDER_STATE() {
		return ORDER_STATE;
	}

	public Integer getORDER_PRICE() {
		return ORDER_PRICE;
	}

	public Integer getORDER_QUANTITY() {
		return ORDER_QUANTITY;
	}

	public Integer getORDER_PRICE_TOTAL() {
		return ORDER_PRICE_TOTAL;
	}

	public String getORDER_MOD_DATE() {
		return ORDER_MOD_DATE;
	}

	public String getMENU_NAME() {
		return MENU_NAME;
	}

	public String getORDER_IN_DATE() {
		return ORDER_IN_DATE;
	}

	public Integer getSET_IDX() {
		return SET_IDX;
	}
	
	public Integer getMenu_sale() {
		return MENU_SALE;
	}
	
	
}
