package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.example.pages.LandingPage;
import com.example.pages.LaunchPage;
import com.example.pages.LoginPage;
import com.example.pages.ProfilePage;
import com.example.utities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfileTest {
	
public	 FirefoxDriver driver;
public 	 ExtentTest test;
public ExtentReports extent;
	@Test
	public void testProfile(){
	 	System.out.println("user.dir"+System.getProperty("user.dir"));
		  extent=ExtentManager.getInstance();
        test=extent.startTest("testProfile");
        test.log(LogStatus.INFO, "test profile testcase exeution started");

	
		  
		LaunchPage launchpage=new LaunchPage(driver,test);
        PageFactory.initElements(driver, launchpage) ;
	 	LoginPage loginpage=	launchpage.gotoFBHomePage();
	 	LandingPage landingpage=loginpage.doLogin("UserXXX", "test123");
	 	ProfilePage profilepage=landingpage.gotoProfilePage();
	 	profilepage.verifyProfile();
	
	System.out.println("Hello");
	}

	@AfterMethod()
	public void quit(){
		
		if(extent !=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
}
