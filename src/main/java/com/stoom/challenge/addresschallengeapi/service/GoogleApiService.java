package com.stoom.challenge.addresschallengeapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stoom.challenge.addresschallengeapi.model.Address;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressDTO;


@Service
public class GoogleApiService {
	
	private static final String API_KEY = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
    private final static String GEOCODE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    
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
