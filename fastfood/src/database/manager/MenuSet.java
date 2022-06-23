package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuSet {
	
	private Integer set_idx;    
	private String set_name; 
	private Integer set_sale;    
	private String set_use_flag;  
	private Date set_in_date;         
	private String set_in_id; 
	private Date set_mod_date;         
	private String set_mod_id;         
	private Integer set_price;    
	private String set_img_path;
	private Integer set_rep;
	
	public MenuSet(ResultSet rs) throws SQLException {
		
		this.set_idx 		= rs.getInt(1);    
		this.set_name 		= rs.getString(2);
		this.set_sale 		= rs.getInt(3);
		this.set_use_flag 	= rs.getString(4);
		this.set_in_date 	= rs.getDate(5);
		this.set_in_id 		= rs.getString(6);
		this.set_mod_date 	= rs.getDate(7);
		this.set_mod_id 	= rs.getString(8);
		this.set_price 		= rs.getInt(9);
		this.set_img_path 	= rs.getString(10);
		this.set_rep 	= rs.getInt(11);
		
	}

	public Integer getSet_idx() {
		return set_idx;
	}

	public String getSet_name() {
		return set_name;
	}

	public Integer getSet_sale() {
		return set_sale;
	}

	public String getSet_use_flag() {
		return set_use_flag;
	}

	public Date getSet_in_date() {
		return set_in_date;
	}

	public String getSet_in_id() {
		return set_in_id;
	}

	public Date getSet_mod_date() {
		return set_mod_date;
	}

	public String getSet_mod_id() {
		return set_mod_id;
	}

	public Integer getSet_price() {
		return set_price;
	}

	public String getSet_img_path() {
		return set_img_path;
	}

	public Integer getSet_rep() {
		return set_rep;
	}
	
}
