package kioske.pherkad0602.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDatabase {
	
	private Integer menu_idx;  
	
	public Integer getMenu_idx() {
		return menu_idx;
	}

	public void setMenu_idx(Integer menu_idx) {
		this.menu_idx = menu_idx;
	}

	public OrderDatabase(ResultSet rs) throws SQLException {
		this.menu_idx = rs.getInt(1);    
	
	}
	
	
}
