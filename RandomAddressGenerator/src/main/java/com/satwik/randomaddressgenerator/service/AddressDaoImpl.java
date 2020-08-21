package com.satwik.randomaddressgenerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Override
	public List<String> getCountries() {
		List<String> countries = new ArrayList<>();
		countries.add("US");
		countries.add("Canada");
		countries.add("Mexico");
		countries.add("Netherlands");
		
		return countries;
	}
}
