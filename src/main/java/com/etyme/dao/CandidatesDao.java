package com.etyme.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.etyme.model.Candidates;

public interface CandidatesDao {
	
	public List<Candidates> listCandidates();	
	public void saveCandidate(Candidates can);
	public Candidates getCandidateById(int candidateId);
	
}
