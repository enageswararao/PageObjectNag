package com.example.tests;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utities.Xls_Reader;

public class Test_Readdata {

	 
	@Test(dataProvider="getTestData")
	public void loginTestCase(Hashtable<String,String> data){
		
		 System.out.println(data.get("UserName")+data.get("password")+data.get("Email"));
	}
	@DataProvider
	public Object[][] getTestData() {

		// create object of the Xls_Reader..

		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\Sravya\\Desktop\\VMZosft/PageObjectModelWithPageFactory/TestData/TestDataVM.xlsx");
		String sheetName = "Regression_Test_Data";
		String testCaseName = "Rervestation_TestCase";

		// reads data for only testCaseName
		
				int testStartRowNum=1;
				while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
					testStartRowNum++;
				}
				System.out.println("Test starts from row - "+ testStartRowNum);
				int colStartRowNum=testStartRowNum+1;
				int dataStartRowNum=testStartRowNum+2;
				
				// calculate rows of data
				int rows=0;
				while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
					rows++;
				}
				System.out.println("Total rows are  - "+rows );
				
				//calculate total cols
				int cols=0;
				while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
					cols++;
				}
				System.out.println("Total cols are  - "+cols );
				Object[][] data = new Object[rows][1];
				//read the data
				int dataRow=0;
				Hashtable<String,String> table=null;
				for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
					table = new Hashtable<String,String>();
					for(int cNum=0;cNum<cols;cNum++){
						String key=xls.getCellData(sheetName,cNum,colStartRowNum);
						String value= xls.getCellData(sheetName, cNum, rNum);
						table.put(key, value);
						// 0,0 0,1 0,2
						//1,0 1,1
					}
					data[dataRow][0] =table;
					dataRow++;
				}
				return data;
			}
			
			

}