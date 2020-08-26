package com.satwik.randomaddressgenerator.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class RandomAddressGeneratorServiceImpl implements RandomAddressGeneratorService {

	@Override
	/**
	 * This method is using a library which gets the random fake address and also
	 * using the Locale for getting the ISO3Country codes
	 */
	public Address getRandomAdress(final String country) {
		String localeCountryName = CountryEnum.getCountryName(country);
		if (localeCountryName == null) {
			return null;
		}
		final Faker faker = new Faker();
		final Address address = new Address();
		address.setStreet(faker.address().buildingNumber() + " " + faker.address().streetName());
		address.setHouse("Apt" + faker.number().digits(3));
		address.setCity(faker.address().city());
		address.setCountry(country);
		address.setCounty(faker.address().cityName());
		final Map<String, String> iso3CountryMap = new HashMap<>();

		for (final String iso : Locale.getISOCountries()) {
			Locale l = new Locale("", iso);
			iso3CountryMap.put(l.getDisplayCountry().toUpperCase(), l.getISO3Country());
		}
		
		if (iso3CountryMap.containsKey(localeCountryName)) {
			address.setCountryCode(iso3CountryMap.get(localeCountryName));
		}
		else {
			return null;
		}
		address.setCountry(country);
		address.setState(faker.address().state());
		address.setStateCode(faker.address().stateAbbr());
		address.setPostalCode(faker.address().zipCode());
		return address;
	}
}
