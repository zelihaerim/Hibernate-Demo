package com.hibernatedemo;

import javax.persistence.*;

@Entity // bu classsin bir veritabani nesnesi oldugunu gosterir
@Table(name="city")
public class City {
	@Id
	/*The @Id annotation specifies the primary key of an entity and 
	 * the @GeneratedValue provides for the specification of generation 
	 * strategies for the values of primary keys.
	 * */
	@Column(name="ID")
	private int id;
	@Column(name="name")
	private String name; 
	@Column(name="countryCode")
	private String countryCode;
	@Column(name="district")
	private String district;
	@Column(name="population")
	private int population;
	// veritabanina hibernate ile ulasalim artik
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
}
