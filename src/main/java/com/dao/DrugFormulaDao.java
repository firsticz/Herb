package com.dao;

public class DrugFormulaDao {
	
	String drugName;
	String idDrugFormula;
	String recipeType;
	HerbDrugDao[] herb;
	String[] suggestion;
	String[] use;
	String[] warning;
	String[] sideEffect;
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public HerbDrugDao[] getHerb() {
		return herb;
	}
	public void setHerb(HerbDrugDao[] herb) {
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
	public String getRecipeType() {
		return recipeType;
	}
	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}
	public String getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(String idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}
	

	
}
