package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maplesoft.peopleware.beans.entity.JobOffer;

public class CompanyDTO extends BaseDTO {

	private BigInteger id;
	private String name;
	private String contact;
	@JsonIgnore
	private Set<JobOffer> jobOffers;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Set<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public void setJobOffers(Set<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

}
