package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends BasePage{

 
	public LoginPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		System.out.println("Loginpage");
	 
	}
	
	public LandingPage doLogin(String username,String password){
 
		// login
		System.out.println("Login successful");
		
		LandingPage landingpage=new LandingPage(driver,test);
       PageFactory.initElements(driver, landingpage);
		return landingpage;
		
	}
}
