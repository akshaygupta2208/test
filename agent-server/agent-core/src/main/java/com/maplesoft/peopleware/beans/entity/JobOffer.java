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
	private double salaryRange;
	private String workingTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_degree_id", insertable = false, updatable = false)
	private AcademicDegree academicDegree;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "pwr_job_offer_technical_skill",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "technical_skill_id"))
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
	

	
	
}
