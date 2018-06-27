package com.maplesoft.peopleware.beans.dto;

import java.math.BigInteger;

import com.maplesoft.peopleware.beans.entity.JobOffer;

public class CompanyDTO extends BaseDTO {

	private BigInteger companyId;
	private String name;
	private String contact;
	private JobOffer jobOffer;
	
	public BigInteger getCompanyId() {
		return companyId;
	}
	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
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
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	
}
