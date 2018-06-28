package com.maplesoft.peopleware.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayursinfotech.agent.beans.entity.Agent;
import com.ayursinfotech.agent.exception.NoRecordFoundException;
import com.maplesoft.peopleware.beans.entity.AcademicDegree;
import com.maplesoft.peopleware.beans.entity.Candidate;
import com.maplesoft.peopleware.beans.entity.JobOffer;
import com.maplesoft.peopleware.beans.entity.TechnicalSkill;
import com.maplesoft.peopleware.dao.PeoplewareDAO;
import com.maplesoft.peopleware.exception.DuplicateRecordFoundException;

@Repository
public class PeoplewareDAOImpl implements PeoplewareDAO {
	
	private static final Logger LOGGER = Logger.getLogger(PeoplewareDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Candidate registerCandidate(Candidate candidate) {
		LOGGER.info("start executing registerCandidate");
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();			
			session.saveOrUpdate(candidate);
			tx.commit();
			LOGGER.info("end executing registerCandidate");
			return candidate;
		} finally {
			session.close();
		}		
	}
	
	@Override
	public boolean isRegisteredCandidate(Candidate candidate) throws DuplicateRecordFoundException, Exception {
		LOGGER.info("start executing isRegisteredCandidate");
		Session session = sessionFactory.openSession();
		try {
			// check for duplicate mobile number
			Criteria cr = session.createCriteria(Candidate.class);
			cr.add(Restrictions.eq("contact", candidate.getContact()));
			Candidate candidateGotFromDB = (Candidate) cr.uniqueResult();
			if (candidateGotFromDB != null) {
				throw new DuplicateRecordFoundException("duplicate contact number");
			}
			LOGGER.info("end executing isRegisteredCandidate");
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public List<AcademicDegree> getAcademicDegreeList() {
		LOGGER.info("start executing getAcademicDegreeList");
		Session session = sessionFactory.openSession();
		
		try {
			Criteria cr = session.createCriteria(AcademicDegree.class);			
			List<AcademicDegree> academicDegreeList = cr.list();
			
			LOGGER.info("end executing getAcademicDegreeList");
			return academicDegreeList;
		} finally {
			session.close();
		}	
		
	}
	
	@Override
	public List<Candidate> getAllCandidates(){
		LOGGER.info("start executing getAllCandidates");
		Session session = sessionFactory.openSession();
		try {
			Criteria cr = session.createCriteria(Candidate.class);		
			
			List<Candidate> candidateList = cr.list();
			
			LOGGER.info("end executing getAllCandidates");
			return candidateList;
		} finally {
			session.close();
		}		
	}

	@Override
	public List<Candidate> getQualifiedCandidates(JobOffer jobOfferDetail){
		LOGGER.info("start executing getQualifiedCandidates");
		Session session = sessionFactory.openSession();
		try {
			
			Criteria cr = session.createCriteria(Candidate.class);		
			cr.add(Restrictions.between("minimumSalary",jobOfferDetail.getLowerSalaryRange() ,jobOfferDetail.getUpperSalaryRange()));
			cr.add(Restrictions.in("candidateTechnicalSkills", jobOfferDetail.getTechnicalSkills()));
			cr.add(Restrictions.eq("academicDegree", jobOfferDetail.getAcademicDegree()));
			List<Candidate> candidateList = cr.list();
			
			LOGGER.info("end executing getQualifiedCandidates");
			return candidateList;
		} finally {
			session.close();
		}		
	}
	
	@Override
	public List<JobOffer> getAllJobOffers() {
		LOGGER.info("start executing getAllJobOffers");
		Session session = sessionFactory.openSession();
		try {
			Criteria cr = session.createCriteria(JobOffer.class);		
			
			List<JobOffer> offerList = cr.list();
			
			LOGGER.info("end executing getAllJobOffers");
			return offerList;
		} finally {
			session.close();
		}		
	}

	@Override
	public List<TechnicalSkill> getTechnicalSkillList() {
		
		LOGGER.info("start executing getTechnicalSkillList");
		Session session = sessionFactory.openSession();
		
		try {
			Criteria cr = session.createCriteria(TechnicalSkill.class);			
			List<TechnicalSkill> technicalSkillList = cr.list();
			
			LOGGER.info("end executing getTechnicalSkillList");
			return technicalSkillList;
		} finally {
			session.close();
		}	
	}

	@Override
	public JobOffer getJobOffer(BigInteger jobOfferId) throws NoRecordFoundException, Exception {
		LOGGER.info("start executing getJobOffer");
		Session session = sessionFactory.openSession();
		JobOffer jobOffer = null;
		try {
			jobOffer = (JobOffer) session.get(JobOffer.class, jobOfferId);
			if (jobOffer != null) {
				LOGGER.info("end executing getJobOffer");
			} else {
				throw new NoRecordFoundException("invalid JobOffer Id");
			}
		} finally {
			session.close();
		}
		return jobOffer;
	}
	
}
