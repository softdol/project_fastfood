package pos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.manager.Menu;

public class Order {
	private Integer order_idx;    
	private Integer menu_idx;    
	private Integer order_state;    
	private Integer order_price;    
	private Integer order_quantity;    
	private Integer order_price_total;    
	private Date order_mod_date;         
	private String menu_name; 
	private Date order_in_date;
	private Integer set_idx;
	private Integer payment_idx;
	
	public Order(ResultSet rs) throws SQLException {
		this.order_idx			= rs.getInt(1);    
		this.menu_idx			= rs.getInt(2);   
		this.order_state		= rs.getInt(3);    
		this.order_price		= rs.getInt(4);
		this.order_quantity		= rs.getInt(5);
		this.order_price_total	= rs.getInt(6);
		this.order_mod_date		= rs.getDate(7);
		this.menu_name			= rs.getString(8);
		this.order_in_date		= rs.getDate(9);
		this.set_idx			= rs.getInt(10);
		this.payment_idx		= rs.getInt(10);

	}
	
	public void setTotalPrice(int order_quantity) {
		this.order_quantity = order_quantity;
		this.order_price_total = this.order_quantity * order_price;
	}
	
	/**
	 * 주문 정보
	 * @param m	메뉴 정보
	 * @param order_quantity 수량
	 * @param set_idx 셋트 번호
	 */
	public Order(Menu m, int order_quantity, int set_idx) {
		this.order_idx = 0;    
		this.menu_idx = m.getMenu_idx();   
		this.order_state = 0;    
		this.order_price = m.getMenu_price();
		this.order_quantity = order_quantity;
		this.order_price_total = m.getMenu_price() * order_quantity;
		//this.order_mod_date = rs.getDate(0);
		this.menu_name = m.getMenu_name();
		//this.order_in_date = rs.getDate(0);
		this.set_idx = set_idx;
	}

	public Integer getOrder_idx() {
		return order_idx;
	}

	public Integer getMenu_idx() {
		return menu_idx;
	}

	public Integer getOrder_state() {
		return order_state;
	}

	public Integer getOrder_price() {
		return order_price;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public Integer getOrder_price_total() {
		return order_price_total;
	}

	public Date getOrder_mod_date() {
		return order_mod_date;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public Date getOrder_in_date() {
		return order_in_date;
	}

	public Integer getSet_idx() {
		return set_idx;
	}
	
	

}
