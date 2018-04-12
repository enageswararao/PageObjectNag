package com.example.base;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public  WebDriver driver;
	public ExtentTest test;
		
	public BasePage() { }
	
	public BasePage(WebDriver driver,ExtentTest test){
		
		this.driver=driver;
		this.test=test;
	}
	
	//common action to all page
	public void logout(){
		 
		System.out.println("logout logic");
	}
}
