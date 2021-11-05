package org.hobsoft.docker.mavenchrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Tests that Selenium can run on Chrome.
 */
public class BrowserTest
{
	// ----------------------------------------------------------------------------------------------------------------
	// fields
	// ----------------------------------------------------------------------------------------------------------------
	
	private WebDriver driver;
	
	// ----------------------------------------------------------------------------------------------------------------
	// JUnit methods
	// ----------------------------------------------------------------------------------------------------------------
	
	@Before
	public void setUp()
	{
		ChromeOptions options = new ChromeOptions()
			.setHeadless(true);
		
		driver = new ChromeDriver(options);
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// tests
	// ----------------------------------------------------------------------------------------------------------------
	
	@Test
	public void canDuck()
	{
		driver.get("http://androidreact.westus.cloudapp.azure.com:81/");
		driver.findElement(By.id("titulo")).click();	
		
		assertThat(driver.getTitle(), containsString("Demoweb"));
	}
}
