package com.dto;

public class SymtomDto {
	
	String id;
	SymtomGroupDto idSymtomGroup;
	String SymtomName;
	DrugFormulaDto[] idDrugFormula;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SymtomGroupDto getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(SymtomGroupDto idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
	public String getSymtomName() {
		return SymtomName;
	}
	public void setSymtomName(String symtomName) {
		SymtomName = symtomName;
	}
	public DrugFormulaDto[] getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(DrugFormulaDto[] idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}
	
}
