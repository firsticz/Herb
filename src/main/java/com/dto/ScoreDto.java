package com.dto;

public class ScoreDto {
	String Id;
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
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	

}
