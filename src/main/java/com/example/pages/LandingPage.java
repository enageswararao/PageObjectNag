package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends BasePage {
	
	
	@FindBy(id="email")
	private WebElement facebookemail;
	
	@FindBy(name="pass")
	private WebElement password;
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement siginBtn;
	
	@FindBy(linkText="Forgotten account?")
	public WebElement forgotlnk;
	
	public LandingPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		
	}
	
 
	public FindYourAccountPage naviagtoFindAccountPage(){
		
		forgotlnk.click();
		FindYourAccountPage findyouraccountpage=new FindYourAccountPage(driver,test);
        PageFactory.initElements(driver, findyouraccountpage) ;
        return findyouraccountpage;
	}
public ProfilePage gotoProfilePage(){
	
	
	ProfilePage profpage=new ProfilePage();
	
	return profpage;
}

public void dologin(){
	facebookemail.sendKeys("robotesting55@gmail.com");
	test.log(LogStatus.INFO, "Enter username ");
	password.sendKeys("ammulu123");
	test.log(LogStatus.INFO, "Enter the password");
	siginBtn.click();
	test.log(LogStatus.INFO, "Click on singin Button");
}
 
}