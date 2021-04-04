package com.stoom.challenge.addresschallengeapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
	
	private static final String ONLY_NUMBERS_REGEX = "^[0-9]*$";
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "streetName can not be null")
	private String streetName; 
	
	@Pattern(
			   regexp = ONLY_NUMBERS_REGEX,
			   message = "number can contain only numbers")
    @NotEmpty(message = "number can not be null")
	private String number; 
   
	@Column(nullable = true)
	private String complement;
	
	@NotEmpty(message = "neighbourhood can not be null")
	private String neighbourhood; 
	
	@NotEmpty(message = "city can not be null")
	private String city;
	
	@NotEmpty(message = "state can not be null")
	private String state; 
	
	@NotEmpty(message = "country can not be null")
	private String country;
	
	@Pattern(
			   regexp = ONLY_NUMBERS_REGEX,
			   message = "zipcode can contain only numbers")
	@NotEmpty(message = "zipcode can not be null")
	private String zipcode;
	
	@Digits(fraction = 6, integer = 10, message = "latitudde must be a number with at most 6 fraction digits")
	private Float latitude;
	
	@Digits(fraction = 6, integer = 10, message = "longitude must be a number with at most 6 fraction digits")
	private Float longitude;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	} 

}
