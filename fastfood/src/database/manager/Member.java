package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member {
	
	private Integer member_idx;
	private Integer store_idx;
	private String member_id;
	private String member_name;
	private String member_pass; 
	  
	private String MEMBER_USE_FLAG;   
	private Date MEMBER_IN_DATE;
	
	public Member(ResultSet rs) throws SQLException {
				
		this.member_idx			= rs.getInt(1);
		this.store_idx 			= rs.getInt(2);
		this.member_id			= rs.getString(3);
		this.member_name 		= rs.getString(4);
		this.member_pass 		= rs.getString(5);		
		this.MEMBER_USE_FLAG	= rs.getString(6);
		this.MEMBER_IN_DATE		= rs.getDate(7);
		
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public String getMember_name() {
		return member_name;
	}
}
