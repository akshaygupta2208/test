package com.maplesoft.peopleware.service.impl;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.dao.PeoplewareDAO;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.response.BaseResponse;
import com.maplesoft.peopleware.service.PeoplewareService;
import com.maplesoft.peopleware.util.PeoplewareConstants;

@Service
public class PeoplewareServiceImpl implements PeoplewareService{

	private static final Logger LOGGER = Logger.getLogger(PeoplewareServiceImpl.class);
	
	@Autowired
	private PeoplewareDAO peoplewareDAO;
	
	@Override
	public BaseResponse registerCandidate(CandidateDTO candidateDTO) {
		LOGGER.info("start executing registerCandidate");
		ModelMapper mp = new ModelMapper();
		BaseResponse response = new BaseResponse();

		Candidate candidate = null;
		try {
			if (peoplewareDAO.isRegisteredCandidate(mp.map(candidateDTO, Candidate.class))) {
				response.setMessage("Candidate Already Exist");
				response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
				return response;
			}
		

			candidate = peoplewareDAO.registerCandidate(mp.map(candidateDTO, Candidate.class));
			response.setBaseDTO(mp.map(candidate, CandidateDTO.class));

			response.setMessage("Registered Candidate Successfully");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
			// TODO send confirmation mail to candidate for successfull registration
		

		} catch (DuplicateRecordFoundException e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setMessage("unabe to register");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing registerCandidate");
		return response;
	}

}
