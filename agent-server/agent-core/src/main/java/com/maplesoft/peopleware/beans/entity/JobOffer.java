package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pwr_job_offer")
public class JobOffer {

	@Id
	@Column(name="job_offer_id", columnDefinition = "bigint")
	@GeneratedValue
	private BigInteger id;
	
	private String name;
	private String description;
	private double lowerSalaryRange;
	private double upperSalaryRange;
	private String workingTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_degree_id", insertable = false, updatable = false)
	private AcademicDegree academicDegree;
	
	
	@OneToMany(mappedBy="jobOffer", fetch = FetchType.EAGER)
	private Set<TechnicalSkill> technicalSkills = new HashSet<TechnicalSkill>();
	

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
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

	public double getLowerSalaryRange() {
		return lowerSalaryRange;
	}
	public void setLowerSalaryRange(double lowerSalaryRange) {
		this.lowerSalaryRange = lowerSalaryRange;
	}
	public double getUpperSalaryRange() {
		return upperSalaryRange;
	}
	public void setUpperSalaryRange(double upperSalaryRange) {
		this.upperSalaryRange = upperSalaryRange;
	}
	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}
	public Set<TechnicalSkill> getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(Set<TechnicalSkill> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public String getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	

	
	
}
