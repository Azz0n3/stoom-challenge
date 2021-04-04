package com.stoom.challenge.addresschallengeapi.service;

import java.util.List;
import java.util.Optional;

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
	
	public Address createNewAddress(Address newAddress) {
		return addressRepository.save(newAddress);
	}
	
	public Optional<Address> findAddressById(Long id) {
		return addressRepository.findById(id);
	}
	
	public void deleteAddressById(Long id) {
		addressRepository.deleteById(id);
	}
	
	public Address updateAddress(Address address, Address newAddress) {
		address.setCity(newAddress.getCity());
		address.setComplement(newAddress.getComplement());
		address.setCountry(newAddress.getCountry());
		address.setLatitude(newAddress.getLatitude());
		address.setLongitude(newAddress.getLongitude());
		address.setNeighbourhood(newAddress.getNeighbourhood());
		address.setNumber(newAddress.getNumber());
		address.setState(newAddress.getState());
		address.setStreetName(newAddress.getStreetName());
		address.setZipcode(newAddress.getZipcode());
		
		return this.addressRepository.save(address);
	}

}
