package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.CandidatesDao;
import com.etyme.dao.JobsDao;
import com.etyme.dao.UserDao;
import com.etyme.model.Candidates;
import com.etyme.model.Jobs;
import com.etyme.model.User;
import com.etyme.service.CandidatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("candidatesService")
@Transactional
public class CandidatesServiceImpl implements CandidatesService{

	@Autowired
	private CandidatesDao candidateDao;

	@Override
	public List<Candidates> listCandidates() {
		// TODO Auto-generated method stub
		return candidateDao.listCandidates();
	}

	@Override
	public void saveCandidate(Candidates can) {
		// TODO Auto-generated method stub
		candidateDao.saveCandidate(can);
	}

	@Override
	public Candidates getCandidatesById(int canid) {
		// TODO Auto-generated method stub
		return candidateDao.getCandidateById(canid);
	}	
}
