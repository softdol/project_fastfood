package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dual {

	private String dummy;
	
	public Dual(ResultSet rs) throws SQLException{
		dummy = rs.getString("dummy");
	}
	
	public String getDummy() {
		return dummy;
	}
	
}
