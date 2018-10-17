package com.dto;

import org.bson.types.ObjectId;
public class ScoreDto {
	String id;
	String drugformulaId;
	UserScoreDto[] userscore;
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDrugformulaId() {
		return drugformulaId;
	}
	public void setDrugformulaId(String drugformulaId) {
		this.drugformulaId = drugformulaId;
	}
	public UserScoreDto[] getUserscore() {
		return userscore;
	}
	public void setUserscore(UserScoreDto[] userscore) {
		this.userscore = userscore;
	}
	
	

}
