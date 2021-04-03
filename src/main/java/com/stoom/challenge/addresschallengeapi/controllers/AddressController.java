package com.stoom.challenge.addresschallengeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.challenge.addresschallengeapi.service.AddressService;
import com.stoom.challenge.addresschallengeapi.model.Address;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/create")
	public String createAddresses() {
		return "test";
	}

	@GetMapping("/index")
	public List<Address> indexAddresses() {
		return addressService.getAllAddresses();
	}
	
	@GetMapping("/show/{id}")
	public String showAddress(@PathVariable(value="id") String id) {
		return id;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAddress(@PathVariable(value="id") String id) {
		return id;
	}
	
	@PutMapping("/delete/{id}")
	public String updateAddress(@PathVariable(value="id") String id) {
		return id;
	}
	
}
