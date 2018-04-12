package com.example.utities;

import java.io.File;
import java.util.Date;

import com.example.constant.Configuration;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ","_")+".html";
			
			String  reportPath=Configuration.REPORTFILELOCATION+fileName;
			
			extent=new ExtentReports(reportPath,true,DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File("C:\\Users\\Sravya\\Desktop\\VMZosft\\PageObjectModelWithPageFactory\\extent-config.xml"));
			
			extent.addSystemInfo("Selenium Version ","2.53.0").addSystemInfo("Environment","QA");
		}
		return extent;
		
		
	}
	
	
}
