package com.dao;

public class ScoreDao {
	String drugformulaId;
	UserScoreDao[] userscore;
	public String getDrugformulaId() {
		return drugformulaId;
	}
	public void setDrugformulaId(String drugformulaId) {
		this.drugformulaId = drugformulaId;
	}
	public UserScoreDao[] getUserscore() {
		return userscore;
	}
	public void setUserscore(UserScoreDao[] userscore) {
		this.userscore = userscore;
	}
	

}
