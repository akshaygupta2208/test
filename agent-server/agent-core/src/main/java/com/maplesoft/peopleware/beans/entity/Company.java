package com.maplesoft.peopleware.beans.entity;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_offer_id", insertable = false, updatable = false)
	private Set<JobOffer> jobOffer = new HashSet<JobOffer>();

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

	public Set<JobOffer> getJobOffer() {
		return jobOffer;
	}

	public void setJobOffer(Set<JobOffer> jobOffer) {
		this.jobOffer = jobOffer;
	}

	
}
