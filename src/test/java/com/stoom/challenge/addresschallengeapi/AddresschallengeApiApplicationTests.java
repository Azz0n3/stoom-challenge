package com.stoom.challenge.addresschallengeapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.equalTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.stoom.challenge.addresschallengeapi.controllers.AddressController;
import com.stoom.challenge.addresschallengeapi.model.Address;
import com.stoom.challenge.addresschallengeapi.service.AddressService;

@WebMvcTest(AddressController.class)
class AddresschallengeApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AddressService addressService;

	@Test
	@DisplayName("Should save a new Address. Fetching google API for LAT and LNG")
	void addressCreateTest() throws Exception {
		Address address = this.getAddressMockDataWithouLatNLng();
		String json = this.getObjectAsJsonString(address);
		
		when(addressService.createNewAddress(address)).thenReturn(address);

		RequestBuilder request = post("/address")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(request)
		.andExpect(status().isCreated());
	}
	
	
	@Test
	@DisplayName("Should get a specific Address.")
	void addressGetSpecificTest() throws Exception {
		Address responseAddress = this.getAddress()
;		when(addressService.findAddressById(anyLong())).thenReturn(Optional.of(responseAddress));
		
		
		RequestBuilder request = get("/address/1")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.zipcode").value(responseAddress.getZipcode()))
        .andExpect(jsonPath("$.city").value(responseAddress.getCity()))
        .andExpect(jsonPath("$.state").value(responseAddress.getState()))
        .andExpect(jsonPath("$.country").value(responseAddress.getCountry()))
        .andExpect(jsonPath("$.number").value(responseAddress.getNumber()))
        .andExpect(jsonPath("$.streetName").value(responseAddress.getStreetName()))
        .andExpect(jsonPath("$.latitude").value(responseAddress.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(responseAddress.getLongitude()))
        .andExpect(jsonPath("$.neighbourhood").value(responseAddress.getNeighbourhood()))
        .andExpect(jsonPath("$.complement").value(responseAddress.getComplement()));
	}
	
    @Test
    @DisplayName("Should Fetch all Registered Addresses")
    public void deveBuscarTodosOsEnderecosCadastrados() throws Exception {
        List<Address> mockEnderecos = getAddressList(5);

        when(addressService.getAllAddresses()).thenReturn(mockEnderecos);

        this.mockMvc.perform(
            get("/address"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()", equalTo(mockEnderecos.size())));
    }
    
    @Test
    @DisplayName("Should update an existing address")
    public void deveAtualizarUmEnderecoExistente() throws Exception {
        final Address optionalAddress = this.getAddress();
        
        when(addressService.findAddressById(anyLong())).thenReturn(Optional.of(this.getAddress()));
        when(addressService.updateAddress(any(Address.class), any(Address.class))).thenReturn(optionalAddress);

        this.mockMvc.perform(
            put("/address/1")
                .content(this.getObjectAsJsonString(optionalAddress))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
    
    @Test
    @DisplayName("Shoud delete one existing address")
    public void deveExcluirUmEnderecoDadoUmId() throws Exception {
        final Optional<Address> optionalAddress = Optional.of(this.getAddress());

        when(addressService.findAddressById(anyLong())).thenReturn(optionalAddress);

        this.mockMvc.perform(
            delete("/address/1"))
            .andExpect(status().isNoContent());
    }
    
    
    
	private Address getAddressMockDataWithouLatNLng() {
		Address address =  new Address();
		address.setCity("Jundiaí");
		address.setComplement("Chácara");
		address.setCountry("Brasil");
		address.setNeighbourhood("Bairro Champirra");
		address.setNumber("1293");
		address.setState("São Paulo");
		address.setStreetName("Avenida Geraldo Mazzi");
		address.setZipcode("13215791");
		return address;
	}
	
	private Address getAddress() {
		Address address =  new Address();
		address.setCity("Jundiaí");
		address.setComplement("Chácara");
		address.setCountry("Brasil");
		address.setNeighbourhood("Bairro Champirra");
		address.setNumber("1293");
		address.setState("São Paulo");
		address.setStreetName("Avenida Geraldo Mazzi");
		address.setZipcode("13215791");
		address.setLatitude(-23.0955427);
		address.setLongitude(-46.84824589999999);
		return address;
	}
	
	private List<Address> getAddressList(int listSize) {
		List<Address> listOfAddresses = new ArrayList<Address>();
		for (int i = 0; i < listSize; i++) {
			listOfAddresses.add(this.getAddress());
		}
		
		return listOfAddresses;
	}
	
	private String getObjectAsJsonString(Object object) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(object);
	}

}
