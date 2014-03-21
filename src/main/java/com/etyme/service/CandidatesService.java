package com.etyme.service;

import java.util.List;

import com.etyme.model.Candidates;


public interface CandidatesService {

	public List<Candidates> listCandidates();	
	public void saveCandidate(Candidates can);
	public Candidates getCandidatesById(int canid);

}
