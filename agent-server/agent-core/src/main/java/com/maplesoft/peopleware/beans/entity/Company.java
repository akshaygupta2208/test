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
@Table(name="pwr_company")
public class Company {

	@Id
	@Column(name="company_id", columnDefinition = "bigint")
	@GeneratedValue
	private BigInteger id;
	
	private String name;
	private String contact;
	
	@OneToMany(mappedBy="company", fetch = FetchType.EAGER)
	private Set<JobOffer> jobOffers = new HashSet<JobOffer>();

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
