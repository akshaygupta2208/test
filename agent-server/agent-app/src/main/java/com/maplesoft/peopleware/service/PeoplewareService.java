package com.maplesoft.peopleware.service;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.response.BaseResponse;


public interface PeoplewareService {
	
	BaseResponse registerCandidate(CandidateDTO candidateDTO);

}
