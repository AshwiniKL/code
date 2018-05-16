package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class SignInPage extends TestBase{

	@FindBy(xpath="//span[@class='cleartripLogo']")
	WebElement logo;
	
	@FindBy(linkText="Your trips")
	WebElement yourTripsLink;
	
	@FindBy(id="SignIn")
	WebElement signIn;
	
	@FindBy(id="signInButton")
	WebElement signInButton;
	
	@FindBy(xpath="//div[@id='errors1']")
	WebElement error;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLogo() {
		return logo.isDisplayed();
	}
	
	public String shouldThrowAnErrorIfSignInDetailsAreMissing() {
		yourTripsLink.click();
		signIn.click();
		driver.switchTo().frame("modal_window");
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
		
		return error.getText();
	}
}
