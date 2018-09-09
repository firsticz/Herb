package com.dao;

public class HerbDao {
	int _id;
	String name;
	String herbtype;
	String grouptype;
	String formula;
	String help;
	String[] solution;
	String warning;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHerbtype() {
		return herbtype;
	}
	public void setHerbtype(String herbtype) {
		this.herbtype = herbtype;
	}
	public String getGrouptype() {
		return grouptype;
	}
	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormular(String formula) {
		this.formula = formula;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String[] getSolution() {
		return solution;
	}
	public void setSolution(String[] solution) {
		this.solution = solution;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	
	
}
