package PracticeWithDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataFile {

public static void main(String[] args) throws IOException
{
	
	FileInputStream stream1 = new FileInputStream(new File("\"C:\\Users\\Owner\\Desktop\\assignment\\Test1.xlsx\""));
	//XSSFWorkbook workBook1 = new XSSFWorkbook(stream1);
	XSSFWorkbook book1 = new XSSFWorkbook(stream1);
	XSSFSheet sheet1 =  book1.getSheetAt(0);
	book1.getSheet("Sheet1");
	


}
	
}
