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
	private String member_user_flag;   
	private Date member_in_date;
	private boolean login;
	
	public Member(ResultSet rs) throws SQLException {				
		this.member_idx			= rs.getInt(1);
		this.store_idx 			= rs.getInt(2);
		this.member_id			= rs.getString(3);
		this.member_name 		= rs.getString(4);
		this.member_pass 		= rs.getString(5);		
		this.member_user_flag	= rs.getString(6);
		this.member_in_date		= rs.getDate(7);
		
		if(member_user_flag.equals("Y")) {
			login = true;
		}
	}
	
	public Integer getMember_idx() {
		return member_idx;
	}

	public Integer getStore_idx() {
		return store_idx;
	}

	public String getMember_pass() {
		return member_pass;
	}

	public String getMember_user_flag() {
		return member_user_flag;
	}

	public Date getMember_in_date() {
		return member_in_date;
	}

	public Member() {
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public String getMember_name() {
		return member_name;
	}
	
	public boolean getLogin() {
		return login;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", member_id, member_name);
	}
}
