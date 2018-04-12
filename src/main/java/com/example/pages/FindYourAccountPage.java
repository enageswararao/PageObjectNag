package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class FindYourAccountPage extends BasePage {
	
	
	@FindBy(id="identify_email")
	public WebElement identifyemail;
	
	@FindBy(name="did_submit")
	public WebElement submitbtn;
	
	@FindBy(className="uiButtonText")
	private WebElement cancelbtn;
	
	
	@FindBy(xpath="//div[@class='pam uiBoxRed']/div[1]")
	private WebElement noserarchresult;
	public FindYourAccountPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		
	}
	
	public void searchEmail(){
		
		identifyemail.sendKeys("rajkumar.onlinetraining@gmail.com");
		submitbtn.click();
	}
	
 

	public String getTextonPage() {
 
		return noserarchresult.getText();
	}
	
	

}
