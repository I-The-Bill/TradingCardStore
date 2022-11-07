package com.cognixia.jump.tcg.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;

@Entity
public class Address implements Serializable
{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long id;
	
	@Column(nullable = false, length = 10)
	private String steetNumber;
	
	@Column(nullable = false, length = 30)
	private String streetName;
	
	@Column(nullable = true, length = 10)
	private String suiteNumber;
	
	@Column(nullable = false, length = 30)
	private String city;
	
	@Column(nullable = false, length = 30)
	private String stateOrProvince;
	
	@Column(nullable = false, length = 10)
	private String zipOrPostalCode;
	
	@Column(nullable = false, length = 30)
	private String country;
	
	//Link for the 1 to many of users\
	@JsonIgnoreProperties("address")
	@OneToMany(mappedBy = "address", targetEntity = User.class)
	private Set<User> users = new HashSet<>();
	


	public Address()
	{
		super();
		this.id = -1L;
		this.steetNumber = "N/A";
		this.streetName = "N/A";
		this.suiteNumber = "N/A";
		this.city = "N/A";
		this.stateOrProvince = "N/A";
		this.zipOrPostalCode = "N/A";
		this.country = "N/A";
		this.users = null;
	}
	
	
	public Address(Long id, String steetNumber, String streetName, String suiteNumber, String city,
			String stateOrProvince, String zipOrPostalCode, String country, Set<User> users) {
		super();
		this.id = id;
		this.steetNumber = steetNumber;
		this.streetName = streetName;
		this.suiteNumber = suiteNumber;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.zipOrPostalCode = zipOrPostalCode;
		this.country = country;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSteetNumber() {
		return steetNumber;
	}

	public void setSteetNumber(String steetNumber) {
		this.steetNumber = steetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getSuiteNumber() {
		return suiteNumber;
	}

	public void setSuiteNumber(String suiteNumber) {
		this.suiteNumber = suiteNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZipOrPostalCode() {
		return zipOrPostalCode;
	}

	public void setZipOrPostalCode(String zipOrPostalCode) {
		this.zipOrPostalCode = zipOrPostalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<User> getUser() {
		return users;
	}

	public void setUser(Set<User> users) {
		this.users = users;
	}
	
	public void addUser( User user)
	{
		this.users.add(user);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", steetNumber=" + steetNumber + ", streetName=" + streetName + ", suiteNumber="
				+ suiteNumber + ", city=" + city + ", stateOrProvince=" + stateOrProvince + ", zipOrPostalCode="
				+ zipOrPostalCode + ", country=" + country + ", User=" + users + "]";
	}





	@Override
	public int hashCode() {
		return Objects.hash(city, country, id, stateOrProvince, steetNumber, streetName, suiteNumber, users,
				zipOrPostalCode);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(stateOrProvince, other.stateOrProvince)
				&& Objects.equals(steetNumber, other.steetNumber) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(suiteNumber, other.suiteNumber) && Objects.equals(users, other.users)
				&& Objects.equals(zipOrPostalCode, other.zipOrPostalCode);
	}
	
	

}
