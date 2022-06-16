package database.model;

public class PsList {
	private char type;
	private String val;
	
	public PsList(char type, String val) {
		this.type = type;
		this.val = val;				
	}
	
	public char getType() {
		return type;
	}
	
	public String getVal() {
		return val;
	}
}
