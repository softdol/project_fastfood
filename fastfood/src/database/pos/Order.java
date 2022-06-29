package database.pos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
	private Integer ORDER_IDX;   
	private Integer SET_IDX; 
	private Integer MENU_IDX;  
	private Integer ORDER_STATE;   
	private Integer ORDER_PRICE;
	private String ORDER_TYPE;
	private Date ORDER_IN_DATE;    
	private Date ORDER_MOD_DATE;     
	private String ORDER_MOD_ID;
	
	public Order(ResultSet rs) throws SQLException {
		this.ORDER_IDX = rs.getInt(1);   
		this.SET_IDX = rs.getInt(2); 
		this.MENU_IDX = rs.getInt(3);   
		this.ORDER_STATE = rs.getInt(4);    
		this.ORDER_PRICE = rs.getInt(5);
		this.ORDER_TYPE = rs.getString(6);
		this.ORDER_IN_DATE = rs.getDate(7);    
		this.ORDER_MOD_DATE = rs.getDate(8);     
		this.ORDER_MOD_ID = rs.getString(9);
	}

	public Integer getORDER_IDX() {
		return ORDER_IDX;
	}

	public Integer getSET_IDX() {
		return SET_IDX;
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

	public String getORDER_TYPE() {
		return ORDER_TYPE;
	}

	public Date getORDER_IN_DATE() {
		return ORDER_IN_DATE;
	}

	public Date getORDER_MOD_DATE() {
		return ORDER_MOD_DATE;
	}

	public String getORDER_MOD_ID() {
		return ORDER_MOD_ID;
	}
	
}
