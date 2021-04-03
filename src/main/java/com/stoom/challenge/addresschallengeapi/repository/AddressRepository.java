package com.stoom.challenge.addresschallengeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stoom.challenge.addresschallengeapi.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
