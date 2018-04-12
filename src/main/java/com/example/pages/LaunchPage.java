package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage {

	
	
	public LaunchPage (WebDriver driver,ExtentTest test){
		super(driver,test);
		System.out.println("Slenium");
	    test.log(LogStatus.INFO, "loading url as yahoo.com");
		driver.get("http://yahoo.com");
	    test.log(LogStatus.INFO, "Display the yahoo.com page");
	}
public LoginPage gotoFBHomePage(){
	
		System.out.println("Go to FB HomePage");
		
		LoginPage loginPage=new LoginPage(driver,test);
		 
		PageFactory.initElements(driver,loginPage);
		
		return  loginPage;
	}
}
