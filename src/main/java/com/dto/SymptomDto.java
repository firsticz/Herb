package com.dto;

import org.bson.types.ObjectId;

public class SymtomDto {
	
	String id;
	SymtomGroupDto idSymtomGroup;
	String SymtomName;
	String[]  idDrugFormula;
	
	public ObjectId getId() {
		return new ObjectId(id);
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
	public String[] getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(String[] idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}

}
