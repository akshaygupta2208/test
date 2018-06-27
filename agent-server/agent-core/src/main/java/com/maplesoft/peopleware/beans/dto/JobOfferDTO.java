package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;

public class JobOfferDTO extends BaseDTO {

	private BigInteger jobOfferId;	
	private String name;
	private String description;
	private double salaryRange;
	private String workingTime;
	private AcademicDegree academicDegree;
	private TechnicalSkill technicalSkill;
	public BigInteger getJobOfferId() {
		return jobOfferId;
	}
	public void setJobOfferId(BigInteger jobOfferId) {
		this.jobOfferId = jobOfferId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalaryRange() {
		return salaryRange;
	}
	public void setSalaryRange(double salaryRange) {
		this.salaryRange = salaryRange;
	}
	public String getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}
	public TechnicalSkill getTechnicalSkill() {
		return technicalSkill;
	}
	public void setTechnicalSkill(TechnicalSkill technicalSkill) {
		this.technicalSkill = technicalSkill;
	}
	
}
