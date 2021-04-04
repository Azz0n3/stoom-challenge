package com.stoom.challenge.addresschallengeapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.challenge.addresschallengeapi.service.AddressService;
import com.stoom.challenge.addresschallengeapi.exception.ResourceNotFoundException;
import com.stoom.challenge.addresschallengeapi.model.Address;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping(path = "",  consumes = "application/json", produces = "application/json")
	public ResponseEntity<Address> createAddresses(@Valid @RequestBody Address address) {
		return new ResponseEntity<Address>(this.addressService.createNewAddress(address), HttpStatus.CREATED);
	}

	@GetMapping(path = "")
	public List<Address> indexAddresses() {
		return addressService.getAllAddresses();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> showAddress(@PathVariable(value="id") Long id) {
	    return this.addressService.findAddressById(id)
	            .map(address -> ResponseEntity.ok().body(address))
	            .orElseThrow(() -> new ResourceNotFoundException("Id not found"));

	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value="id") Long id) {
		   return this.addressService.findAddressById(id)
		           .map(address -> {
		        	   this.addressService.deleteAddressById(id);
		               return ResponseEntity.ok().build();
		           }).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value="id") Long id, @Valid @RequestBody Address address) {
		return this.addressService.findAddressById(id)
				.map(oldAddress -> {
					Address updatedAddress = this.addressService.updateAddress(oldAddress, address);
					return ResponseEntity.ok().body(updatedAddress);
				}).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
	}
	
}
