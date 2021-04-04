package com.stoom.challenge.addresschallengeapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleAddressResultsDTO {
	private GoogleAddressResultsGeometryDTO geometry;
	 
	@JsonProperty("address_components")
	private List<GoogleAddressResultsAddressComponentsDTO> addressComponents;

	public List<GoogleAddressResultsAddressComponentsDTO> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<GoogleAddressResultsAddressComponentsDTO> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public GoogleAddressResultsGeometryDTO getGeometry() {
		return geometry;
	}
	
	public void setGeometry(GoogleAddressResultsGeometryDTO geometry) {
		this.geometry = geometry;
	}
}
