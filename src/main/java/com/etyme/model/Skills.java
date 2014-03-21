package com.etyme.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int skillId;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(targetEntity=Jobs.class,mappedBy="skills")
	private Set jobs;
	
	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	
}
