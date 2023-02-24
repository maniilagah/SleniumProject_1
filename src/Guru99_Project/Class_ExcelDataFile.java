package Guru99_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Class_ExcelDataFile {
	

	public Object[][] myData(String sheetName) throws IOException
	{
		
//		 prop  = new Class_PropertiesAccess();
		var p = Class_PropertiesAccess.properties();
		
		FileInputStream stream1 = new FileInputStream(new File(p.getProperty("excelFile")));
		//XSSFWorkbook workBook1 = new XSSFWorkbook(stream1);
		XSSFWorkbook book1 = new XSSFWorkbook(stream1);
		XSSFSheet sheet1 =  book1.getSheet(sheetName);
		int rows = sheet1.getLastRowNum();
		
		int column = (sheet1.getRow(0)).getLastCellNum();
		Object[][] data = new Object[rows][column];
		System.out.println("number of rows and column is " + rows + "  " + column);
		for(int i = 1;i<=rows;i++)
		{
			for (int j = 0;j<=column-1;j++)
			{
				System.out.println("value of i and j  " + i + "  " + j);
				var rowData = sheet1.getRow(i).getCell(j);
				System.out.println("and value are   " +  rowData);
				data[i-1][j] = String.valueOf(rowData);	
			}	
		}
		return data;
		
	}
	
	
}
