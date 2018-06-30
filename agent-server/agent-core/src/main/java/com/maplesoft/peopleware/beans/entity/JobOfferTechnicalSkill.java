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
@Table(name="pwr_job_offer_technical_skill")
public class JobOfferTechnicalSkill {
	
	@Id
	@Column(name = "job_offer_techskill_id", columnDefinition = "bigint")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	
	@ManyToOne
	@JoinColumn(name = "job_offer_id")
	private JobOffer jobOfferTech;
	
	@ManyToOne
	@JoinColumn(name = "technical_skill_id")
	private TechnicalSkill jobOfferSkill;
	
	@Column(name="rating")
	private int rating;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public JobOffer getJobOfferTech() {
		return jobOfferTech;
	}

	public void setJobOfferTech(JobOffer jobOfferTech) {
		this.jobOfferTech = jobOfferTech;
	}

	public TechnicalSkill getJobOfferSkill() {
		return jobOfferSkill;
	}

	public void setJobOfferSkill(TechnicalSkill jobOfferSkill) {
		this.jobOfferSkill = jobOfferSkill;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
