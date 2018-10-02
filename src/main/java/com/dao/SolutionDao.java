package com.dao;

public class SolutionDao {
	String water;
	String seed;
	TestDao test;
	
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
	public TestDao getTest() {
		return test;
	}
	public void setTest(TestDao test) {
		this.test = test;
	}	
}
