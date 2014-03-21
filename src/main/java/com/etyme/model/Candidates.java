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
@Table (name = "candidates", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Candidates {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column ( name = "id", unique = true, nullable = false)
	private Long candidateId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;

	@Column(name = "cityid")
	private int cityId ;

	@Column(name = "homephone")
	private String homePhone;

	@Column(name = "cellphone")
	private String cellPhone;

	@Column(name = "workPhone")
	private String workPhone;
	
	@Column(name = "remarks")
	private String remarks;
	
	@ManyToOne(targetEntity=CandidateSource.class,cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="sourceid")
	private CandidateSource candidateSource;	
		
	@Column(name = "canrelocate")
	private boolean canRelocate;

	@ManyToMany(targetEntity=Skills.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinTable(name="candidate_skills",joinColumns=@JoinColumn(name="candidateid",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="skillid",referencedColumnName="id"))
	private Set<Skills> skills;

	@Column(name = "otherskills")
	private String otherKeySkills;

	@Column(name = "salary")
	private String salary;

	@Column(name = "notes")
	private String notes;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CandidateSource getCandidateSource() {
		return candidateSource;
	}

	public void setCandidateSource(CandidateSource candidateSource) {
		this.candidateSource = candidateSource;
	}

	public boolean isCanRelocate() {
		return canRelocate;
	}

	public void setCanRelocate(boolean canRelocate) {
		this.canRelocate = canRelocate;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public String getOtherKeySkills() {
		return otherKeySkills;
	}

	public void setOtherKeySkills(String otherKeySkills) {
		this.otherKeySkills = otherKeySkills;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
