package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;
//import org.testng.annotations.Test;

public class CRMAddContacts {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
		        "C:/Users/Dhrithi/Downloads/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		 
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("GayathriB");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		
		
		driver.switchTo().frame("mainpanel");
		WebElement Contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		WebElement newcontacts = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		Actions action = new Actions(driver); 
		action.moveToElement(Contacts).build().perform();
		newcontacts.click();
	}
	
	@DataProvider
	public Iterator<Object[]> gettestdata(){
		ArrayList<Object[]> testdata = TestUtil.getdatafromexcel();
		return testdata.iterator();
		
	}
		
		@Test(dataProvider = "gettestdata")
		public void Addcontact(String title, String firstname,String lastname,String company,
				               String address,String city,String state,String zipcode,
				               String country) {
			
			Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
			select.selectByVisibleText(title);
			
			driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(company);
			
			driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(address);
			
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
			
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
			
			driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(zipcode);
			
			driver.findElement(By.xpath("//input[@name='country']")).sendKeys(country);
		
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
	
	
	
	


