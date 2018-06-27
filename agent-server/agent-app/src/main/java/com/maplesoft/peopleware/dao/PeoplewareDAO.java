package com.maplesoft.peopleware.dao;

import com.ayursinfotech.agent.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.beans.entity.Candidate;

public interface PeoplewareDAO {
	
	Candidate registerCandidate(Candidate candidate);
	boolean isRegisteredCandidate(Candidate candidate)
			throws DuplicateRecordFoundException, Exception;

}
