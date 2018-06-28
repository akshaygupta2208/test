package com.maplesoft.peopleware.service;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.response.BaseResponse;


public interface PeoplewareService {
	
	BaseResponse registerCandidate(CandidateDTO candidateDTO);
	BaseResponse getTechnicalSkillList();
	BaseResponse getAcademicDegreeList();
	BaseResponse getAllCandidates();
	BaseResponse getAllOffers();
	BaseResponse qualifiedCandidates(JobOfferDTO jobOfferDTO);	
	BaseResponse candidateJobOffers(CandidateDTO candidateDTO);
}
