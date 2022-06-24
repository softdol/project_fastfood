package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Store {
	
	private Integer store_idx;     
	private String store_name;  
	private String store_business_number;  
	private String store_address; 
	private String store_ceo;  
	private String store_phone;  
	private Date store_in_date;
	
	public Store(ResultSet rs) throws SQLException {
		this.store_idx = rs.getInt(1);     
		this.store_name = rs.getString(2);
		this.store_business_number = rs.getString(3);
		this.store_address = rs.getString(4);
		this.store_ceo = rs.getString(5);
		this.store_phone = rs.getString(6);
		this.store_in_date = rs.getDate(7);
	}
//???
	public Integer getStore_idx() {
		return store_idx;
	}

	public String getStore_name() {
		return store_name;
	}

	public String getStore_business_number() {
		return store_business_number;
	}

	public String getStore_address() {
		return store_address;
	}

	public String getStore_ceo() {
		return store_ceo;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public Date getStore_in_date() {
		return store_in_date;
	}

}
