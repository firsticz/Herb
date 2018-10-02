package com.dto;

import org.bson.types.ObjectId;

public class SolutionDto {
	String id;
	String water;
	String seed;
	TestDto test;
	
	public String getWater() {
		return water;
	}
	public String getSeed() {
		return seed;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public TestDto getTest() {
		return test;
	}
	public void setTest(TestDto test) {
		this.test = test;
	}	
	
}
