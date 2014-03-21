package com.etyme.validators;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;


public class JobForm {
	
	@Id
	@GeneratedValue
	@NotEmpty
	private Long jobId;
	
	@NotEmpty
	private String title;
	
	private int cityId;
	
	private int stateId;

	private String zip;

	private String duration;

	@NotEmpty
	private double max_rate;
	
	@NotEmpty
	private String job_type;
	
	private int openings;
	
	private String company_reference;

	@NotEmpty
	private double salary;
	
	private Date start_date;
	
	private int recruiterId;
	
	private int ownerId;

	private String description;

	private int status;

	private int publish;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getMax_rate() {
		return max_rate;
	}

	public void setMax_rate(double max_rate) {
		this.max_rate = max_rate;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public int getOpenings() {
		return openings;
	}

	public void setOpenings(int openings) {
		this.openings = openings;
	}

	public String getCompany_reference() {
		return company_reference;
	}

	public void setCompany_reference(String company_reference) {
		this.company_reference = company_reference;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPublish() {
		return publish;
	}

	public void setPublish(int publish) {
		this.publish = publish;
	}

	
}
