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
		return peoplewareService.registerCandidate(candidateDTO);
	}
}
