package com.maplesoft.peopleware.dao;

import java.math.BigInteger;
import java.util.List;

import com.ayursinfotech.agent.exception.DuplicateRecordFoundException;
import com.ayursinfotech.agent.exception.NoRecordFoundException;
import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.Company;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;

public interface PeoplewareDAO {
	
	Candidate registerCandidate(Candidate candidate);
	boolean isRegisteredCandidate(Candidate candidate)
			throws DuplicateRecordFoundException, Exception;
	List<TechnicalSkill> getTechnicalSkillList();
	List<AcademicDegree> getAcademicDegreeList();
	List<Candidate> getAllCandidates();
	List<JobOffer> getAllJobOffers();
	List<Candidate> getQualifiedCandidates(JobOffer jobOfferDetail);
	JobOffer getJobOffer(BigInteger jobOfferId) throws NoRecordFoundException, Exception;
	JobOffer postJobOffer(JobOffer jobOffer);
	Candidate getCandidate(BigInteger candidateId) throws NoRecordFoundException, Exception;
	List<JobOffer> getQualifiedJobs(Candidate candidateDetail);
	List<Company> getCompanyList() throws NoRecordFoundException, Exception;
	
}
