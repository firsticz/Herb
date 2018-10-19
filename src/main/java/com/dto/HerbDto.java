package com.dto;

import org.bson.types.ObjectId;

public class HerbDto {
	String id;
	String _id;
	String idherb;
	String herbname;
	String[] properties;
	String[] warning;
	public ObjectId getId() {
		return new ObjectId(id);
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
	public ObjectId get_id() {
		return new ObjectId(_id);
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getIdherb() {
		return idherb;
	}
	public void setIdherb(String idherb) {
		this.idherb = idherb;
	}
	
	
}
