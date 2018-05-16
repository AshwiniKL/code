package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlightPage;
import com.qa.pages.SignInPage;

public class FlightBookingTest extends TestBase {

	FlightPage flightPage;
	SignInPage signInPage;

	//Invoke parent class constructor
	public FlightBookingTest() {
		super();
	}

	//Instantiation
	@BeforeMethod
	public void setUp() {
		initialization();
		flightPage = new FlightPage();
		signInPage = new SignInPage();

	}

	//Verify title
	@Test(priority = 1)
	public void verifyTitleTest() {
		Assert.assertEquals(signInPage.verifyTitle(),
				"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	}

	//verify logo
	@Test(priority = 2)
	public void verifyLogoTest() {
		Assert.assertTrue(signInPage.verifyLogo());
	}

	//Test That Results Appear For A OneWayJourney
	@Test(priority = 3)
	public void testThatResultsAppearForAOneWayJourneyTest() {
		Assert.assertTrue(flightPage.testThatResultsAppearForAOneWayJourney("Bangalore", "Delhi"));
	}

	//close the browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
