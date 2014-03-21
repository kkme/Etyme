package com.etyme.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

import org.springframework.context.annotation.Primary;

@Entity
@Table (name = "jobs", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Jobs {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column ( name = "id", unique = true, nullable = false)
	private Long jobId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "cityid")
	private int cityId;
	
	@Column(name = "duration")
	private String duration;

	@Column(name = "max_rate")
	private double max_rate;
	 
//	@JoinColumn(name="job_type",referencedColumnName="id")
//  no need for ManytoOne on JobTypes
	@ManyToOne(targetEntity=JobTypes.class,cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="job_type")
	private JobTypes jobtype;
		
	@Column(name = "openings")
	private int openings;
	
	@Column(name = "company_reference")
	private String company_reference;

	@Column(name = "salary")
	private double salary;
	
	@Column(name = "start_date")
	private Date start_date;
	
	@Column(name = "recruiterid")
	private int recruiterId;
	
	@Column(name = "ownerId")
	private int ownerId;

	@Column(name = "description")
	private String description;

	@ManyToMany(targetEntity=Skills.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinTable(name="job_skills",joinColumns=@JoinColumn(name="jobid",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="skillid",referencedColumnName="id"))
	private Set<Skills> skills;
	
	@Column(name = "status")
	private int status;

	@Column(name = "publish")
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

	public JobTypes getJobtype() {
		return jobtype;
	}

	public void setJobtype(JobTypes jobtype) {
		this.jobtype = jobtype;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

}
