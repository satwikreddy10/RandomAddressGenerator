package com.satwik.randomaddressgenerator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class RandomAddressGeneratorServiceImpl implements RandomAddressGeneratorService {

	@Autowired
	private AddressDao addressDao;

	@Override
	/**
	 * This method is using a library which gets the random fake address.
	 */
	public Address getRandomAdress(final String country) {

		List<String> countries = addressDao.getCountries();
		if (!countries.contains(country)) {
			return null;
		}
		final Faker faker = new Faker();
		Address address = new Address();
		address.setStreet(faker.address().buildingNumber() + " " + faker.address().streetName());
		address.setHouse("Apt" + faker.number().digits(3));
		address.setCity(faker.address().city());
		address.setCountry(country);
		address.setCounty(faker.address().cityName());
		Map<String, String> localeCountries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale l = new Locale("", iso);
			localeCountries.put(l.getDisplayCountry(), l.getISO3Country());
		}
		String countryCode = localeCountries.get(country);
		if (countryCode == null) {
			Locale locale = new Locale("", country);
			countryCode = locale.getISO3Country();
			address.setCountryCode(countryCode);
		} else {
			address.setCountryCode(localeCountries.get(country));
		}
		address.setState(faker.address().state());
		address.setStateCode(faker.address().stateAbbr());
		address.setPostalCode(faker.address().zipCode());
		return address;
	}
}
