package com.stoom.challenge.addresschallengeapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stoom.challenge.addresschallengeapi.model.Address;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressDTO;


@Service
public class GoogleApiService {

	@Value("${externalService.google.geocode.key}")
	private String API_KEY;
	
	@Value("${externalService.google.geocode.url}")
    private String GEOCODE_URL;

    
    public GoogleAddressDTO getLatNLongByAddress(Address address) {
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate.getForObject(this.buildUrlParam(address), GoogleAddressDTO.class);
    	
    }
    
    private String buildUrlParam(Address address) {
        String addressString = address.getStreetName() + " " + address.getNumber() + " " + address.getNeighbourhood() + " " + address.getZipcode() + " " + address.getCity() + " " + address.getState() + " "
                + address.getCountry();
        addressString = addressString.replaceAll("\\s+", "+");
        return GEOCODE_URL + addressString + "&key=" + API_KEY;
    }
    
}
