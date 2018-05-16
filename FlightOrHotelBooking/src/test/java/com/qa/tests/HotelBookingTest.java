package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HotelPage;
import com.qa.pages.SignInPage;

public class HotelBookingTest extends TestBase {

	HotelPage hotelPage;
	SignInPage signInPage;

	//Invoke parent class constructor
	public HotelBookingTest() {
		super();
	}

	//Instantiation
	@BeforeMethod
	public void setUp() {
		initialization();
		hotelPage = new HotelPage();
		signInPage = new SignInPage();
	}

	//verify Title
	@Test(priority = 1)
	public void verifyTitleTest() {
		Assert.assertEquals(signInPage.verifyTitle(),
				"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	}

	//verify Logo
	@Test(priority=2)
	public void verifyLogoTest() {
		Assert.assertTrue(signInPage.verifyLogo());
	}

	//Should Be Able To Search For Hotels
	@Test(priority=3)
	public void shouldBeAbleToSearchForHotelsTest() {
		hotelPage.shouldBeAbleToSearchForHotels();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
