package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.SignInPage;

public class SignInTest extends TestBase {

	SignInPage signInPage;

	// Invoke parent class constructor
	public SignInTest() {
		super();
	}

	// Instantiation
	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
	}

	//verify Title Test
	@Test(priority = 1)
	public void verifyTitleTest() {
		Assert.assertEquals(signInPage.verifyTitle(),
				"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	}

	//Verify Logo
	@Test(priority = 2)
	public void verifyLogoTest() {
		Assert.assertTrue(signInPage.verifyLogo());
	}

	//Should Throw An Error If SignIn Details Are Missing
	@Test(priority = 3)
	public void shouldThrowAnErrorIfSignInDetailsAreMissingTest() {
		Assert.assertTrue(signInPage.shouldThrowAnErrorIfSignInDetailsAreMissing()
				.contains("There were errors in your submission"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
