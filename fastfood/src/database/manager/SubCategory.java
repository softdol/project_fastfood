package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategory {

	private Integer menu_subcategory_idx;    
	private String menu_subcategory_name; 
	private Integer menu_category_idx;    
	private Date menu_subcategory_in_date;  
	
	
	public SubCategory(ResultSet rs) throws SQLException {
		this.menu_subcategory_idx 		= rs.getInt(1);    
		this.menu_subcategory_name		= rs.getString(2);
		this.menu_category_idx			= rs.getInt(3);    
		this.menu_subcategory_in_date	= rs.getDate(4);  
	}


	public Integer getMenu_subcategory_idx() {
		return menu_subcategory_idx;
	}


	public String getMenu_subcategory_name() {
		return menu_subcategory_name;
	}


	public Integer getMenu_category_idx() {
		return menu_category_idx;
	}


	public Date getMenu_subcategory_in_date() {
		return menu_subcategory_in_date;
	}
	
	
	
}
