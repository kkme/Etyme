package com.etyme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "job_types")
public class JobTypes {
	@Id
	@GeneratedValue
	@Column(name = "id" , updatable = false, insertable = false)
	private long jobId;
	
	@Column(name = "type" , updatable = false, insertable = false)
	private String type;

	@OneToMany (mappedBy = "jobtype")
	private Set<Jobs> job = new HashSet<Jobs>();
	
	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Jobs> getJob() {
		return job;
	}

	public void setJob(Set<Jobs> job) {
		this.job = job;
	}

		
	
}
