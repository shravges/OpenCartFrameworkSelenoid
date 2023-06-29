package com.qa.opencart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	public static File registrationData = new File("./src/main/resources/testdata/OpenCartTestData.xlsx");
	public static Workbook workbook;
	public static Sheet sheet;
	public static Object[][] data=null;

	public static Object[][] getTestDataFromExcel(String sheetName)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(registrationData);
			workbook = WorkbookFactory.create(fis);
			sheet = workbook.getSheet(sheetName);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}		
		}
		catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (EncryptedDocumentException | IOException e) 
		{
				e.printStackTrace();
		}
		return data;	
	}

}
