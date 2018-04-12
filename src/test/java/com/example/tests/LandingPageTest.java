package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.constant.LabelConstant;
import com.example.pages.FindYourAccountPage;
import com.example.pages.LandingPage;
import com.example.pages.LaunchPage;
import com.example.utities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPageTest extends BaseTest {
	
	
	WebDriver driver;
 
	public 	 ExtentTest test;
	public ExtentReports extent;
	@BeforeTest 
	public void setup(){
		
		driver= getDriver("chrome");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
 
	  System.out.println("user.dir"+System.getProperty("user.dir"));
	  extent=ExtentManager.getInstance();
      test=extent.startTest("LogingPageTestCases");
      test.log(LogStatus.INFO, "Login Page testcase exeution started");

	}
	
//	@Test
	public void TC_001_LoginTestCase_01(){
		
		LandingPage landingpage=new LandingPage(driver,test);
         PageFactory.initElements(driver, landingpage) ;
        landingpage.dologin();
        
       
	}
	
	@Test void TC_002_ForgotPWdCase_01(){
		
		LandingPage landingpage=new LandingPage(driver,test);
        PageFactory.initElements(driver, landingpage) ;
        test.log(LogStatus.INFO, "Openining landing page");
        FindYourAccountPage findyouraccountpage =  landingpage.naviagtoFindAccountPage();
        test.log(LogStatus.INFO, "click on forgotpassword link");
        
        findyouraccountpage.searchEmail();
        findyouraccountpage.getTextonPage();
        System.out.println("----------------0"+findyouraccountpage.getTextonPage());
        test.log(LogStatus.INFO,   findyouraccountpage.getTextonPage());
        test.log(LogStatus.INFO, "Enter email and click on serach buttmon");
        String acturesult=findyouraccountpage.getTextonPage();
        System.out.println("----------------0"+LabelConstant.noserachResult);

        Assert.assertEquals(acturesult,LabelConstant.noserachResult);
        
       

	}
	
	@Test
	public void TC_003_testCase(){
		
		 test.log(LogStatus.INFO, "TC_003_testCase");
		 Assert.assertTrue(true);
		 test.log(LogStatus.PASS, "TC_005_testCase1");
	}
	
	@Test
	public void TC_004_testCase1(){
		
		 test.log(LogStatus.INFO, "TC_004_testCase1");
		 test.log(LogStatus.FAIL, "TC_005_testCase1");
		 Assert.assertTrue(false);

	}
	
	@Test
	public void TC_005_testCase1(){
		
		 test.log(LogStatus.INFO, "TC_005_testCase1");
		 Assert.assertTrue(true);
		 test.log(LogStatus.PASS, "TC_005_testCase1");

	}
   @AfterTest
   public void teardown(){
		if(extent !=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	   
   }
   
 
