package seleniumcodesnippet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader
{
	@Test(dataProvider="testcase")
	public void readData(String scenarioNumber, String requirementId, String scenarioDescription, String testCases) {
	    System.out.println(scenarioNumber + " - " + requirementId + " - " + scenarioDescription + " - " + testCases);
	}	
	@DataProvider(name="testcase")
	public Object[][] readExcelData() throws IOException
	{
		File filepath = new File(System.getProperty("user.dir")+"\\TestSceanrioTemplate.xlsx");
		//File filepath = new File(System.getProperty("user.dir") + File.separator + "TestSceanrioTemplate.xlsx");
		
		FileInputStream fis = new FileInputStream(filepath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Sheet1"); 
		
		int rowCount = sheet.getLastRowNum();
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object[] []  data = new Object[rowCount][columnCount];
		
		for (int r = 0; r < rowCount; r++) {
		    XSSFRow row = sheet.getRow(r + 5);
		    if (row != null) { // Check if the row exists
		        for (int c = 0; c < columnCount; c++) {
		            XSSFCell cell = row.getCell(c);
		            if (cell != null) { // Check if the cell exists
		                CellType cellType = cell.getCellType();
		                switch (cellType) {
		                    case STRING:
		                        data[r][c] = cell.getStringCellValue();
		                        break;
		                    case NUMERIC:
		                        data[r][c] = Double.toString(cell.getNumericCellValue());
		                        break;
		                    case BOOLEAN:
		                        data[r][c] = cell.getBooleanCellValue();
		                        break;
		                }
		            } else {
		                // Handle case where cell is null (optional)
		            }
		        }
		    } else {
		        // Handle case where row is null (optional)
		    }
		}
		return data;
	}
	
}

