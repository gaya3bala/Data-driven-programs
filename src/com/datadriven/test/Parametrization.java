package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class Parametrization {

	public static void main(String[] args) {

//Data driven approach
  
  
//webdriver code
		System.setProperty("webdriver.chrome.driver",
		        "C:/Users/Dhrithi/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();//launch chrome
		driver.get("http://demo.guru99.com/test/newtours/"); //enter URL

		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();  //goto Registration page

	//load the excel file	
		  Xls_Reader reader = new Xls_Reader("G:/java programs/DataDriven/src/com/testsdata/MerToursdata.xlsx");
		  int rowCount = reader.getRowCount("MertoursRegData");
		  System.out.println(rowCount);
		  
		  // create a column " STATUS"
		  
		  reader.addColumn("MertoursRegData", "Status");
		//To get all the data from excel ---Parametrization
  for(int rowNum=2;rowNum<=rowCount;rowNum++)
  {
  String firstname = reader.getCellData("MertoursRegData", "firstname", rowNum);
	System.out.println(firstname);
	
	String lastname = reader.getCellData("MertoursRegData", "lastname", rowNum);
	System.out.println(lastname);
	
	String phone = reader.getCellData("MertoursRegData", "phone", rowNum);
	System.out.println(phone);
	
	String address = reader.getCellData("MertoursRegData", "address", rowNum);
	System.out.println(address);
	
	String city = reader.getCellData("MertoursRegData", "city", rowNum);
	System.out.println(city);
	
	String state = reader.getCellData("MertoursRegData", "state", rowNum);
	System.out.println(state);
	
	String country = reader.getCellData("MertoursRegData", "Country", rowNum);
	System.out.println(country);
	
	String Username = reader.getCellData("MertoursRegData", "username", rowNum);
	System.out.println(Username);
	
	String Password = reader.getCellData("MertoursRegData", "password", rowNum);
	System.out.println(Password);
  
  
//sending data to webelements
	
		driver.findElement(By.xpath("//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@name='phone']")).clear();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		
		driver.findElement(By.xpath("//input[@name='address1']")).clear();
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		select.selectByVisibleText(country);
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(Password);
		
		//reader.setCellData("MertoursRegData", "Status", rowNum, "PASS");
	   
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		String actualURL = "http://newtours.demoaut.com/create_account_success.php";
		String expectedURL = driver.getCurrentUrl();
		
		if(expectedURL.equalsIgnoreCase(actualURL))
		{
			reader.setCellData("MertoursRegData", "Status", rowNum, "PASS");
			//driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		}else
		{
			reader.setCellData("MertoursRegData", "Status", rowNum, "FAIL");
			//driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		}
		
		
		
		//register next data
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		
		
	}
	}

}
