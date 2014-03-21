package com.etyme.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "candidateSource")
public class CandidateSource {
	@Id
	@GeneratedValue
	@Column(name = "id", insertable = false, updatable = false)
	private int sourceId;
	
	@Column(name = "name", insertable = false, updatable = false)
	private String sourceName;

	@OneToMany(targetEntity=Candidates.class,mappedBy="candidateSource")
	private Set<Candidates> candidates;

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Set<Candidates> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidates> candidates) {
		this.candidates = candidates;
	}
		
	
}
