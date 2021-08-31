package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class compliance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int complianceId;
	@NotEmpty(message="RL Type is mandatory.")
	private String RLtype;
	@NotEmpty(message="details is mandatory.")
	private String details;
	private String date;
	private int deptId;
	public int getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public String getRLtype() {
		return RLtype;
	}
	public void setRLtype(String rLtype) {
		RLtype = rLtype;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
