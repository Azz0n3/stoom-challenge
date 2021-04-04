package com.stoom.challenge.addresschallengeapi.model;

import java.util.List;

public class GoogleAddressDTO {
	private List<GoogleAddressResultsDTO> results;
	private String status;
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<GoogleAddressResultsDTO> getResults() {
		return results;
	}
	public void setResults(List<GoogleAddressResultsDTO> results) {
		this.results = results;
	}
}
