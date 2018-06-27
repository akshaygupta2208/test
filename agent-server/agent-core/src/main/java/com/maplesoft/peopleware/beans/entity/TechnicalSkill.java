package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pwr_technical_skill")
public class TechnicalSkill {

	@Id
	@Column(name="technical_skill_id", columnDefinition = "bigint")
	@GeneratedValue
	private BigInteger id;
	private String name;
	
	@OneToMany(mappedBy="technicalSkill", fetch = FetchType.EAGER)
	private Set<CandidateTechnicalSkill> candidateTechnicalSkills = new HashSet<CandidateTechnicalSkill>();

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

	public Set<CandidateTechnicalSkill> getCandidateTechnicalSkills() {
		return candidateTechnicalSkills;
	}

	public void setCandidateTechnicalSkills(Set<CandidateTechnicalSkill> candidateTechnicalSkills) {
		this.candidateTechnicalSkills = candidateTechnicalSkills;
	}

	
	
	
}
