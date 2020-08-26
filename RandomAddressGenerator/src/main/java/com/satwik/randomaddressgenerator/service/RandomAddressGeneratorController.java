package com.satwik.randomaddressgenerator.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RandomAddressGeneratorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomAddressGeneratorController.class);

	@Autowired
	private RandomAddressGeneratorService randomAddressGeneratorService;

	/**
	 * 
	 * @param country
	 * @return randomly generated fake address throws
	 *         org.springframework.web.server.ResponseStatusException when there is
	 *         no valid request or the country is not found
	 */
	@GetMapping(value = "/randomizer/address")
	public Address getRandomAddress(@RequestParam(value = "country", defaultValue = "USA") String country) {
		LOGGER.info("The service is called with country {}", country);
		Address randomAddress = null;
		randomAddress = randomAddressGeneratorService.getRandomAdress(country);
		if (randomAddress == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address Not Found");
		}
		return randomAddress;
	}
}
