package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventPage {
	private Integer event_page_number;
	private String big_event_page;
	private String small_event_page;
	
	public EventPage(int event_page_number, String big_event_page, String small_event_page) {
		this.event_page_number = event_page_number;
		this.big_event_page = big_event_page;
		this.small_event_page = small_event_page;
	}
	
	public EventPage(ResultSet rs) throws SQLException{
		event_page_number = rs.getInt("event_page_number");
		big_event_page	  = rs.getString("big_event_page");
		small_event_page  = rs.getString("small_event_page");
	}
	
	public Integer getEvent_page_number() {
		return event_page_number;
	}
	
	public String getBig_event_page() {
		return big_event_page;
	}
	
	public String getSmall_event_page() {
		return small_event_page;
	}
	
	public void setEvent_page_number(Integer event_page_number) {
		this.event_page_number = event_page_number;
	}
	
	public void setBig_event_page(String big_event_page) {
		this.big_event_page = big_event_page;
	}
	
	public void setSmall_event_page(String small_event_page) {
		this.small_event_page = small_event_page;
	}
}
