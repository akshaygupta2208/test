package com.maplesoft.peopleware.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplesoft.peopleware.beans.dto.AcademicDegreeDTO;
import com.maplesoft.peopleware.beans.dto.AcademicDegreeWrapper;
import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.CandidateWrapper;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferWrapper;
import com.maplesoft.peopleware.beans.dto.TechnicalSkillDTO;
import com.maplesoft.peopleware.beans.dto.TechnicalSkillWrapper;
import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.CandidateTechnicalSkill;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;
import com.maplesoft.peopleware.dao.PeoplewareDAO;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;
import com.maplesoft.peopleware.response.BaseResponse;
import com.maplesoft.peopleware.service.PeoplewareService;
import com.maplesoft.peopleware.util.PeoplewareConstants;
import com.maplesoft.peopleware.util.SortMap;

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
			response.setMessage("unabe to register candidate");
			response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch (Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing registerCandidate");
		return response;
	}

	@Override
	public BaseResponse getAcademicDegreeList() {
		LOGGER.info("start executing getAcademicDegreeList");		
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		AcademicDegreeWrapper awp =  new AcademicDegreeWrapper();
		
		try{
		List<AcademicDegree> academicDegreeList = peoplewareDAO.getAcademicDegreeList();
		List<AcademicDegreeDTO> tempList = new ArrayList<AcademicDegreeDTO>();
		
		Iterator<AcademicDegree> itr = academicDegreeList.iterator();
		while(itr.hasNext()) {
			tempList.add(mapper.map(itr.next(), AcademicDegreeDTO.class));	
		}
		
		awp.setAcademicDegreeList(tempList);
		
		response.setMessage("Fetch initial form data getAcademicDegreeList");
		response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		} catch(Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		return response;
	}
	
	@Override
	public BaseResponse getAllCandidates() {
		BaseResponse response = new BaseResponse();
		CandidateWrapper cwp =  new CandidateWrapper();
		ModelMapper mapper = new ModelMapper();
	
		try {
		List<Candidate> candidateList = peoplewareDAO.getAllCandidates();
		List<CandidateDTO> tempList = new ArrayList<CandidateDTO>();
		
		Iterator<Candidate> itr = candidateList.iterator();
		
		while(itr.hasNext()) {
			tempList.add(mapper.map(itr.next(), CandidateDTO.class));	
		}
		
		cwp.setCandidateList(tempList);
		response.setBaseDTO(cwp);
		response.setMessage("List of Candidate");
		response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		
		}catch(Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		
		return response;
	}

	@Override
	public BaseResponse getAllOffers() {
		BaseResponse response = new BaseResponse();
		JobOfferWrapper jwp =  new JobOfferWrapper();
		ModelMapper mapper = new ModelMapper();
		
		try {
			List<JobOffer> offerList = peoplewareDAO.getAllJobOffers();
			List<JobOfferDTO> tempList = new ArrayList<JobOfferDTO>();
			
			Iterator<JobOffer> itr = offerList.iterator();
			
			while(itr.hasNext()) {
				tempList.add(mapper.map(itr.next(), JobOfferDTO.class));
			}
			
			jwp.setJobOfferList(tempList);
			}catch(Exception e) {
				LOGGER.error(e);
				response.setErrorMessage(e.getMessage());
				response.setStatus(PeoplewareConstants.STATUS_FAILURE);
			}
		
		return response;
	}
	
	
	@Override
	public BaseResponse getTechnicalSkillList() {
		LOGGER.info("start executing getTechnicalSkillList");		
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		TechnicalSkillWrapper twp =  new TechnicalSkillWrapper();
		
		try{
		List<TechnicalSkill> technicalSkillList = peoplewareDAO.getTechnicalSkillList();
		List<TechnicalSkillDTO> tempList = new ArrayList<TechnicalSkillDTO>();
		
		Iterator<TechnicalSkill> itr = technicalSkillList.iterator();
		while(itr.hasNext()) {
			tempList.add(mapper.map(itr.next(), TechnicalSkillDTO.class));	
		}
		
		twp.setTechnicalSkillList(tempList);
		
		response.setMessage("Fetch initial form data");
		response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		
		} catch(Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing getTechnicalSkillList");	
		return response;
	}

	@Override
	public BaseResponse qualifiedCandidates(JobOfferDTO jobOfferDTO) {
		LOGGER.info("start executing qualifiedCandidates");		
		BaseResponse response = new BaseResponse();
		ModelMapper mapper = new ModelMapper();
		List<Candidate> finalList = new ArrayList<Candidate>();
		Candidate candidate = null;
		try{
			
			JobOffer jobOfferDetail = peoplewareDAO.getJobOffer(jobOfferDTO.getJobOfferId());
			List<Candidate> candidateList = peoplewareDAO.getQualifiedCandidates(jobOfferDetail);
			Map<Candidate,Integer> candidateMap = new HashMap<Candidate,Integer>();
			Iterator itr = candidateList.iterator();
			
			while(itr.hasNext()) {
				int score = 0;
				candidate = (Candidate) itr.next();
					Iterator it= candidate.getCandidateTechnicalSkills().iterator();
					
					while(it.hasNext()) {	
					CandidateTechnicalSkill skill= (CandidateTechnicalSkill) it.next();
						score += skill.getRating();
					}
					
			candidateMap.put(candidate, score);
			}
			SortMap.sortByValues(candidateMap);
			
		response.setMessage("Qualified Candidates for Job Offer");
		response.setStatus(PeoplewareConstants.STATUS_SUCCESS);
		
		} catch(Exception e) {
			LOGGER.error(e);
			response.setErrorMessage(e.getMessage());
			response.setStatus(PeoplewareConstants.STATUS_FAILURE);
		}
		LOGGER.info("end executing getTechnicalSkillList");	
		return response;
	}

	@Override
	public BaseResponse candidateJobOffers(CandidateDTO candidateDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
