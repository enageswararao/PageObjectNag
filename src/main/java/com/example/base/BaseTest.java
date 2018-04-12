package com.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;
	
	public WebDriver getDriver(String BrowserType){
		
		if(BrowserType.equals("firefox")){
			
			//logic open FF browser
			
		}else if(BrowserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Users/Sravya/Desktop/VMZosft/MavenProjectDemo/driverexe/chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if(BrowserType.equals("safari")){
			
			
		}
		return driver;
		
	}
}
