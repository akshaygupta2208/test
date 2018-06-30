package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;
import java.util.Set;

import com.maplesoft.peopleware.beans.entity.CandidateTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.JobOfferTechnicalSkill;

public class TechnicalSkillDTO extends BaseDTO {
	private BigInteger id;
	private String name;
	private Set<JobOfferTechnicalSkill> jobOfferTechnicalSkill;
	private Set<CandidateTechnicalSkill> candidateTechnicalSkills;
	
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
	public Set<JobOfferTechnicalSkill> getJobOfferTechnicalSkill() {
		return jobOfferTechnicalSkill;
	}
	public void setJobOfferTechnicalSkill(Set<JobOfferTechnicalSkill> jobOfferTechnicalSkill) {
		this.jobOfferTechnicalSkill = jobOfferTechnicalSkill;
	}
	public Set<CandidateTechnicalSkill> getCandidateTechnicalSkills() {
		return candidateTechnicalSkills;
	}
	public void setCandidateTechnicalSkills(Set<CandidateTechnicalSkill> candidateTechnicalSkills) {
		this.candidateTechnicalSkills = candidateTechnicalSkills;
	}
}
