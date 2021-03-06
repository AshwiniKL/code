package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;
import com.sun.javafx.PlatformUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\acer\\git\\code\\FlightOrHotelBooking\\"
					+ "src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization() {
		
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver");
			driver = new ChromeDriver();
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver","./DriverFiles/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver_linux");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Open url
		driver.get(prop.getProperty("url"));
		TestUtil.waitFor(2000);

	}

	// public static void setDriverPath() {
	// if (PlatformUtil.isMac()) {
	// System.setProperty("webdriver.chrome.driver", "chromedriver");
	// }
	// if (PlatformUtil.isWindows()) {
	// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	// }
	// if (PlatformUtil.isLinux()) {
	// System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	// }
	// }
}
