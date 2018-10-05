package com.dto;
 public class HerbDto {
	String id;
	String herbname;
	String[] properties;
	String[] warning;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHerbname() {
		return herbname;
	}
	public void setHerbname(String herbname) {
		this.herbname = herbname;
	}
	public String[] getProperties() {
		return properties;
	}
	public void setProperties(String[] properties) {
		this.properties = properties;
	}
	public String[] getWarning() {
		return warning;
	}
	public void setWarning(String[] warning) {
		this.warning = warning;
	}
	
}
