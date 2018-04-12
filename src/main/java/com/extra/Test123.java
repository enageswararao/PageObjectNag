package com.extra;

import java.io.File;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Test123 {

	
	
	@Test (dataProvider="testdata")
	public void loginTest(String username,String password ){
	 
		System.out.println("Va1--------------------"+username);
		System.out.println("Va2--------------------"+password);
 

		
	}
    @DataProvider(name="testdata")
	public Object[][] fnGetTableArray(  )
	{
    	Hashtable<String,String>  table=new Hashtable<String,String>();
    	String strXLFilePath="C:\\Users\\Sravya\\Desktop\\VMZosft\\PageObjectModelWithPageFactory\\TestData\\Smoke_Test_Data.xls";
	    String strSheetName="Smoke_Test_Data";
	    String strTableName="Add_New_Site";
	    Object[][] strTabArray=null;
 	    try
	    {
	   
	        Workbook workbook = Workbook.getWorkbook(new File(strXLFilePath));
	        Sheet sheet = workbook.getSheet(strSheetName);
	        int intStartRow, intStartCol, intEndRow, intEndCol, intCI, intCJ;
	        Cell clTableStart = sheet.findCell(strTableName);
	        intStartRow = clTableStart.getRow() + 1;
	        intStartCol = clTableStart.getColumn() + 1;

	        Cell clTableEnd= sheet.findCell(strTableName, intStartCol + 1, intStartRow + 1, 50, 200,  false);                               

	        intEndRow = clTableEnd.getRow() + 1;
	        intEndCol = clTableEnd.getColumn() + 1;
	        //info("start Row=" + intStartRow + ", end Row=" + intEndRow + ", " +
	         //       "start Col=" + intStartCol +", end Col=" + intEndCol);
	        strTabArray = new String[intEndRow - intStartRow - 1][intEndCol - intStartCol - 1];
	        //info("first index - " + (intEndRow - intStartRow - 1));
	        //info("second index - " + (intEndCol - intStartCol - 1));
	        
	        intCI=0; 
	        for (int i = intStartRow; i < intEndRow - 1; i++, intCI++)
	        {
	        	 
	        	intCJ = 0;
	            for (int j = intStartCol; j < intEndCol - 1; j++, intCJ++)
	            {    
	            	
	                        
	            	strTabArray[intCI][intCJ]= sheet.getCell(j,i).getContents();
	            	System.out.println("===================="+ sheet.getCell(j,i).getContents());
	            	//info("the cell value - row - " + intCI + "- col - " + intCJ + "- " + strTabArray[intCI][intCJ]);
	            }
	            //info("after for");
	        }
	    }
	    catch(Exception e)   
	    {

	    }
 
	    return(strTabArray);
	}
	
	
	public static void main(String[] args) {
		
	//	Test t=new Test();
		
		//String[][] array=	t.fnGetTableArray("C:\\Users\\Sravya\\Desktop\\VMZosft\\PageObjectModelWithPageFactory\\TestData\\Smoke_Test_Data.xls", "Smoke_Test_Data", "Call_Center_Page_Verification");
		 
	}
}
