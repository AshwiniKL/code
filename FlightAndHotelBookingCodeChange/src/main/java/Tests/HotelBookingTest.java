package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

public class HotelBookingTest {
	  WebDriver driver;
	
	@Test
	public void shouldBeAbleToSearchForHotels() throws Throwable {
		setDriverPath();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		driver.findElement(By.linkText("Hotels")).click();
		
		driver.findElement(By.id("Tags")).sendKeys("Indiranagar, Bangalore, Karnataka, India");
		
		new Select(driver.findElement(By.id("SearchHotelsButton"))).selectByVisibleText("1 room, 2 adults");
		
		driver.findElement(By.id("travellersOnhome")).click();
		
		driver.quit();
	}
	
	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver_linux");
            driver = new ChromeDriver();
        }
	}
}
