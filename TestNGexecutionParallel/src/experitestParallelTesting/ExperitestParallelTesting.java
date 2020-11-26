package experitestParallelTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ExperitestParallelTesting {

	private static final String ACCESS_KEY = "Enter your access key here.";

	private URL url;

	@BeforeTest

	public void Setup() throws MalformedURLException {
		url = new URL("https://cloud.seetest.io/wd/hub");
	}

	@Test
	public void ExperitestGoogleSearch() {

		RemoteWebDriver driver;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);

		dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability("testName", "Quick Start Firefox Browser Demo");
		driver = new RemoteWebDriver(url, dc);

		driver.get("https://www.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.click();
		searchBar.sendKeys("Experitest");
		searchBar.sendKeys(Keys.ENTER);
		System.out.print("Experitest TestCase is running in Thread  " + Thread.currentThread().getId());
		driver.quit();
	}

	@Test
	public void SeeTestGoogleSearch() {

		RemoteWebDriver driver1;
		DesiredCapabilities dc1 = new DesiredCapabilities();
		dc1.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

		dc1.setCapability(CapabilityType.PLATFORM, Platform.ANY);
		dc1.setCapability("accessKey", ACCESS_KEY);
		dc1.setCapability("testName", "Quick Start Chrome Browser Demo");
		driver1 = new RemoteWebDriver(url, dc1);

		driver1.get("https://www.google.com");
		new WebDriverWait(driver1, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		WebElement searchBar1 = driver1.findElement(By.name("q"));
		searchBar1.click();
		searchBar1.sendKeys("SeeTest");
		searchBar1.sendKeys(Keys.ENTER);
		System.out.print("SeeTest TestCase is running in Thread  " + Thread.currentThread().getId());
		driver1.quit();
	}
}
