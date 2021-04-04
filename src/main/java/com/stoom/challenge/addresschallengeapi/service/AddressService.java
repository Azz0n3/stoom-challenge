package com.stoom.challenge.addresschallengeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoom.challenge.addresschallengeapi.repository.AddressRepository;
import com.stoom.challenge.addresschallengeapi.model.Address;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressDTO;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressResultsAddressComponentsDTO;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressResultsDTO;
import com.stoom.challenge.addresschallengeapi.model.GoogleAddressResultsGeometryLocationDTO;

@Service
public class AddressService {

	private static final String ZIPCODE_GOOGLE_TYPE = "postal_code";

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private GoogleApiService googleApiService;

	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	public Address createNewAddress(Address newAddress) {
		this.setLatNLngForAddress(newAddress);
		return this.addressRepository.save(newAddress);
	}

	public Optional<Address> findAddressById(Long id) {
		return addressRepository.findById(id);
	}

	public void deleteAddressById(Long id) {
		addressRepository.deleteById(id);
	}

	public Address updateAddress(Address address, Address newAddress) {
		this.setLatNLngForAddress(newAddress);
	
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
	
	private void setLatNLngForAddress(Address address) {
		if(address.getLatitude() == null || address.getLongitude() == null) {
			GoogleAddressResultsGeometryLocationDTO geometryCoordinates = this.getCorrectGeometryByZipcode(address);
			if(geometryCoordinates != null) {
				address.setLatitude(geometryCoordinates.getLat());
				address.setLongitude(geometryCoordinates.getLng());
			}
		}
		
	}
	
	private GoogleAddressResultsGeometryLocationDTO getCorrectGeometryByZipcode(Address address) {
		GoogleAddressDTO googleAddressDTO = googleApiService.getLatNLongByAddress(address);
		for (GoogleAddressResultsDTO googleResultsDTO : googleAddressDTO.getResults()) {
			for (GoogleAddressResultsAddressComponentsDTO googleAddressComponentsDTO : googleResultsDTO
					.getAddressComponents()) {
				if (googleAddressComponentsDTO.getTypes().get(0).equals(ZIPCODE_GOOGLE_TYPE)) {
					String zipcodeWithoutExtraCharacters = googleAddressComponentsDTO.getShortName().replace("-", "");
					if (zipcodeWithoutExtraCharacters.equals(address.getZipcode()))
						return googleResultsDTO.getGeometry().getLocation();
				}
			}
		}
		return null;
	}

}
