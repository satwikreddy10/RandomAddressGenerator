package com.satwik.randomaddressgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomAddressGeneratorController {

	@Autowired
	private RandomAddressGeneratorService randomAddressGeneratorService;

	@GetMapping(value = "/randomizer/address/{country}")
	public ResponseEntity<Address> getRandomAddress(@PathVariable String country) {
		Address randomAddress = randomAddressGeneratorService.getRandomAdress(country);

		if (randomAddress == null) {
			return ResponseEntity.badRequest().body(new Address());
		}
		return ResponseEntity.accepted().body(randomAddress);
	}
}
