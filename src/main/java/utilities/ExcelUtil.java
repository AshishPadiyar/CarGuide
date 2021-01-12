package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	private static String testDataExcel=new File("D:\\selenium\\Names.xlsx").getAbsolutePath();
	private static  XSSFWorkbook wb ;
	private static XSSFSheet sh;
	private static int rowNumber=0;
	
	static HashMap<String ,String> dataMap;
	
	
	public static HashMap<String,String> getTestData(String testCaseName,String sheetName) {
		testCaseName="This is TC 1";
		int col;
		HashMap<String,String> testData=new HashMap<String,String>();
	
		try {
		File f= new File(testDataExcel);
		FileInputStream fis= new FileInputStream(f);
		wb= new XSSFWorkbook(fis);
		sh= wb.getSheet("LoginTest");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sheet not found");
		}
		
		for (int i =1;i<sh.getPhysicalNumberOfRows();i++) 
		{
			col=sh.getRow(i).getLastCellNum();
			XSSFCell cellData=sh.getRow(i).getCell(0);
			String cell1=cellData.getStringCellValue();
			String cell=sh.getRow(i).getCell(0).getStringCellValue();
			if(cell.equalsIgnoreCase(testCaseName))
			{	
				rowNumber=i;
			for(int k=0;k<col-1;k++)
				{
				
				XSSFCell cellData1=sh.getRow(rowNumber).getCell(k);
				String key=new DataFormatter().formatCellValue(sh.getRow(0).getCell(k));
				String value= new DataFormatter().formatCellValue(cellData1);
				testData.put(key,value);
				}
			}
		}	
		
	return testData;
		
	}
}
