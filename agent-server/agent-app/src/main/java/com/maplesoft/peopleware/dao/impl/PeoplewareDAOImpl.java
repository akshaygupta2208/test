package com.maplesoft.peopleware.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maplesoft.peopleware.beans.entity.Candidate;
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
		return true;
	}
}
