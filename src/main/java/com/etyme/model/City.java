package com.etyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table ( name = "cities")
public class City {

	@Id
	@Column ( name = "id")
	private int id;
	
	@Column(name = "city")
	private String city;

	@ManyToOne
	@JoinColumn(name = "state_code")
	private State city_state;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return city_state;
	}

	public void setState(State state) {
		this.city_state = state;
	}

	
}
