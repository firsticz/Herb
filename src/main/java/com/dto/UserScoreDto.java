package com.dto;

import org.bson.types.ObjectId;

public class UserScoreDto {
	String id;
	double score;
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
