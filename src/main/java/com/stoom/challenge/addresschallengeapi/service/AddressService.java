package com.stoom.challenge.addresschallengeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoom.challenge.addresschallengeapi.repository.AddressRepository;
import com.stoom.challenge.addresschallengeapi.model.Address;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

}
