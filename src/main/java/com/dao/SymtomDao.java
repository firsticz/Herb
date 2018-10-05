package com.dao;

public class SymtomDao {
	
	SymtomGroupDao idSymtomGroup;
	String SymtomName;
	DrugFormulaDao[] idDrugFormula;
	
	public SymtomGroupDao getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(SymtomGroupDao idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
	public String getSymtomName() {
		return SymtomName;
	}
	public void setSymtomName(String symtomName) {
		SymtomName = symtomName;
	}
	public DrugFormulaDao[] getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(DrugFormulaDao[] idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}
	
}
