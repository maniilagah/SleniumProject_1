package NewTestingPractice;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Guru99_Project.Class_PropertiesAccess;

public class DataProviderClass {
	
	
	public static Object[][] testData(String sheetName) throws IOException
	{
		
		
		var prop = Class_PropertiesAccess.properties();
		try
		{		
		FileInputStream stream1 = new FileInputStream(new File(prop.getProperty("ExcelSheetAddress")));
		try (XSSFWorkbook book1 = new XSSFWorkbook(stream1)) {
			XSSFSheet sheet = book1.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int columns = (sheet.getRow(0)).getLastCellNum();
			Object[][] data = new Object[rows][columns];
			
//			System.out.println("The number of rows are " + rows + " and Number of columns are " + columns);
			
			
			for(int i = 1;i<=rows;i++)
			{
				for (int j = 0;j<=columns-1;j++)
				{
//					System.out.println("value of i and j  " + i + "  " + j);
					var rowData = sheet.getRow(i).getCell(j);
					System.out.println("and value are   " +  rowData);
					data[i-1][j] = String.valueOf(rowData);	
				}	
			}
			return data;
		}
		
		
	
		}
		catch(Exception e)
		{
			
			Object[][] emptyData = new Object[0][0];
			System.out.println("The Excel sheet is not availble");
			return emptyData;
		}
		
	}
}
	
	
