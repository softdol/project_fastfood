package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		SET_IDX				= rs.getInt("SET_IDX");;
	}
	
	
	
	public void Order_list() {
		
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
	
	
}
