package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {

		
		Xls_Reader reader = new Xls_Reader("G:/java programs/DataDriven/src/com/testsdata/MerToursdata.xlsx");

		
		String firstname = reader.getCellData("MertoursRegData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("MertoursRegData", "lastname", 2);
		System.out.println(lastname);
		
		String phone = reader.getCellData("MertoursRegData", "phone", 2);
		System.out.println(phone);
		
		String address = reader.getCellData("MertoursRegData", "address", 2);
		System.out.println(address);
		
		String city = reader.getCellData("MertoursRegData", "city", 2);
		System.out.println(city);
		
		String state = reader.getCellData("MertoursRegData", "state", 2);
		System.out.println(state);
		
		String country = reader.getCellData("MertoursRegData", "country", 2);
		System.out.println(country);
		
		String Username = reader.getCellData("MertoursRegData", "username", 2);
		System.out.println(Username);
		
		String Password = reader.getCellData("MertoursRegData", "password", 2);
		System.out.println(Password);
		
		//webdriver code
		System.setProperty("webdriver.chrome.driver",
		        "C:/Users/Dhrithi/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();//launch chrome
		driver.get("http://newtours.demoaut.com/mercurywelcome.php"); //enter URL

		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();  //goto Registration page

		
		//sending data to webelements
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		select.selectByVisibleText(country);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(Password);
	   
		driver.findElement(By.xpath("//input[@name='register']")).click();

	}

}
