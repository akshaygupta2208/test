package com.maplesoft.peopleware.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.maplesoft.peopleware.beans.dto.CandidateDTO;
import com.maplesoft.peopleware.beans.dto.JobOfferDTO;
import com.maplesoft.peopleware.response.BaseResponse;
import com.maplesoft.peopleware.service.PeoplewareService;

@Controller
public class PeoplewareController {

	private static final Logger LOGGER = Logger
			.getLogger(PeoplewareController.class);
	
	@Autowired
	private PeoplewareService peoplewareService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse registerCandidate(@RequestBody CandidateDTO candidateDTO) {
		LOGGER.info("inside registerCandidate");
		System.out.println(candidateDTO.toString());
		System.out.println(candidateDTO.getFirstName());
		return peoplewareService.registerCandidate(candidateDTO);
	}
	
	@RequestMapping(value = "/getAcademicDegreeList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getAcademicDegreeList() {
		LOGGER.info("inside registerForm");		
		return peoplewareService.getAcademicDegreeList();
	}
	
	@RequestMapping(value = "/getTechnicalSkillList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getTechnicalSkillList() {
		LOGGER.info("inside getTechnicalSkillList");		
		return peoplewareService.getTechnicalSkillList();
	}
	
	@RequestMapping(value = "/listAllCandidates", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse listAllCandidates() {
		LOGGER.info("inside listAllCandidates");		
		return peoplewareService.getAllCandidates();
	}
	
	@RequestMapping(value = "/getCompanyList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse getCompanyList() {
		LOGGER.info("inside getCompanyList");		
		return peoplewareService.getCompanyList();
	}
	
	@RequestMapping(value = "/listAlloffers", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse listAlloffers() {
		LOGGER.info("inside listAlloffers");		
		return peoplewareService.getAllOffers();
	}
	
	@RequestMapping(value = "/postJobOffer", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse postJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
		LOGGER.info("inside postJobOffer");		
		return peoplewareService.postJobOffer(jobOfferDTO);
	}
	
	@RequestMapping(value = "/qualifiedCandidates", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse qualifiedCandidates(@RequestBody JobOfferDTO jobOfferDTO) {
		LOGGER.info("inside qualifiedCandidates");
		return peoplewareService.qualifiedCandidates(jobOfferDTO);
	}
	
	@RequestMapping(value = "/candidateJobOffers", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public BaseResponse candidateJobOffers(@RequestBody CandidateDTO candidateDTO) {
		LOGGER.info("inside candidateJobOffers");
		return peoplewareService.candidateJobOffers(candidateDTO);
	}
	
}
