package com.dto;

public class DrugFormulaDto {
	
	String id;
	String drugName;
	HerbDrugDto[] herb;
	String[] suggestion;
	String[] use;
	String[] warning;
	String[] sideEffect;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public HerbDrugDto[] getHerb() {
		return herb;
	}
	public void setHerb(HerbDrugDto[] herb) {
		this.herb = herb;
	}
	public String[] getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String[] suggestion) {
		this.suggestion = suggestion;
	}
	public String[] getUse() {
		return use;
	}
	public void setUse(String[] use) {
		this.use = use;
	}
	public String[] getWarning() {
		return warning;
	}
	public void setWarning(String[] warning) {
		this.warning = warning;
	}
	public String[] getSideEffect() {
		return sideEffect;
	}
	public void setSideEffect(String[] sideEffect) {
		this.sideEffect = sideEffect;
	}
	
}
