package com.etyme.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table ( name = "states")
public class State {

	@Id
	@Column ( name = "state_code")
	private String state_code;
	
	@Column(name = "state")
	private String state;
	
	@OneToMany(mappedBy = "city_state")
	private Set<City> City = new HashSet();
	
	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<City> getCity() {
		return City;
	}

	public void setCity(Set<City> city) {
		City = city;
	}
	
	
}
