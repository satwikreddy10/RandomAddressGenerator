package com.satwik.randomaddressgenerator.service;

import java.util.Arrays;
import java.util.List;

public enum CountryEnum {

	UNITEDSTATES("United States of America", "U.S.A.", "USA", "u.s.a.", "us", "united states"),
	MEXICO("Mexico", "mex", "mexico", "MEXICO", "MEX", "mex"),
	NETHERLANDS("Netherlands", "The Netherlands", "the netherlands", "NLD", "NL", "nl"),
	CANADA("Canada", "CANADA", "canada", "CAN", "can");

	private List<String> countries;

	private CountryEnum(String... countries) {
		this.countries = Arrays.asList(countries);
	}

	public List<String> getCountries() {
		return countries;
	}
	
	public static String getCountryName(String country) {
		for (CountryEnum countryEnum : CountryEnum.values()) {
			if (countryEnum.getCountries().stream().anyMatch(country::equalsIgnoreCase)) {
				if(countryEnum==UNITEDSTATES) {
					return "UNITED STATES";
				}
				return countryEnum.name();
			}
		}
		return null;
	}
}
