package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;

public class CandidateDTO extends BaseDTO{

	private BigInteger candidateId;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private double minimumSalary;
	private String workingTime;
	private AcademicDegree academicDegree;
	private TechnicalSkill technicalSkill;
	private JobOffer jobOffer;

	
	
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	public BigInteger getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(BigInteger candidateId) {
		this.candidateId = candidateId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getMinimumSalary() {
		return minimumSalary;
	}
	public void setMinimumSalary(double minimumSalary) {
		this.minimumSalary = minimumSalary;
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
