package com.bean;

import java.util.List;

public class regulation {

	private compliance regulationName;
	private List<statusreport> statusreports;
	public compliance getRegulationName() {
		return regulationName;
	}
	public void setRegulationName(compliance regulationName) {
		this.regulationName = regulationName;
	}
	public List<statusreport> getStatusreports() {
		return statusreports;
	}
	public void setStatusreports(List<statusreport> statusreports) {
		this.statusreports = statusreports;
	}
	
}
