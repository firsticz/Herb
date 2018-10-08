package com.dto;

import org.bson.types.ObjectId;

public class SymptomGroupDto {
	
	public String id;
	public String SymtomGroupName;
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymtomGroupName() {
		return SymtomGroupName;
	}
	public void setSymtomGroupName(String symtomGroupName) {
		SymtomGroupName = symtomGroupName;
	}
	
	
	
}
