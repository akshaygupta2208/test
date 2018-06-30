package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;

public class JobOfferTechnicalSkillDTO extends BaseDTO{
	private BigInteger id;
	private JobOffer jobOfferTech;
	private TechnicalSkill jobOfferSkill;
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
