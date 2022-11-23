package com.flightnetwork.basetest;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BaseTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public static void setUpBeforInBaesClass() throws Exception {
		System.setProperty("Spring.profile.active", "junit");

	}

}
