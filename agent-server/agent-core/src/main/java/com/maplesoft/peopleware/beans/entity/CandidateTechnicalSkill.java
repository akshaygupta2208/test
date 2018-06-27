package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pwr_candidate_technical_skill")
public class CandidateTechnicalSkill {
	
	@Id
	@Column(name = "can_techskill_id", columnDefinition = "bigint")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "technical_skill_id")
	private TechnicalSkill technicalSkill;
	
	@Column(name="rating")
	private int rating;

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public TechnicalSkill getTechnicalSkill() {
		return technicalSkill;
	}

	public void setTechnicalSkill(TechnicalSkill technicalSkill) {
		this.technicalSkill = technicalSkill;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}