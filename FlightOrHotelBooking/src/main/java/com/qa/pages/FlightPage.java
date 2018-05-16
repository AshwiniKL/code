package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class FlightPage extends TestBase{
	
	@FindBy(id="OneWay")
	WebElement oneWayradioButton;
	
	@FindBy(id="FromTag")
	WebElement fromTag;
	
	@FindBy(id="ToTag")
	WebElement toTag;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	WebElement datePicker;
	
	@FindBy(id="SearchBtn")
	WebElement searchButton;
	

	public FlightPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean testThatResultsAppearForAOneWayJourney(String from,String to) {
		oneWayradioButton.click();
		
		fromTag.clear();
		fromTag.sendKeys(from);
		
		 //wait for the auto complete options to appear for the origin
		TestUtil.waitFor(2000);
		
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
		
		toTag.clear();
		toTag.sendKeys(to);
		
		//wait for the auto complete options to appear for the destination
		TestUtil.waitFor(2000);
		
		//select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();
        
        datePicker.click();
        
      //all fields filled in. Now click on search
        searchButton.click();
        
        //return true if result appears for the provided journey search
        return isElementPresent(By.className("searchSummary"));	
	}
	
	private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
