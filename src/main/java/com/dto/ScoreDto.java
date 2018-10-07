package com.dto;

import org.bson.types.ObjectId;
public class ScoreDto {
	String id;
	String drugformula;
	double score;
	int vote;
	public String getDrugformula() {
		return drugformula;
	}
	public void setDrugformula(String drugformula) {
		this.drugformula = drugformula;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
