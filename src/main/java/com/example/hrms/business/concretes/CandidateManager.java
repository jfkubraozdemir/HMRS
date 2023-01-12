package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.SuccessDataResult;
import com.example.hrms.dataAccess.absracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.setCandidateDao(candidateDao);
		
	}
	public CandidateDao getCandidateDao() {
		return candidateDao;
	}
	public void setCandidateDao(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Data listelendi");
	}
}
