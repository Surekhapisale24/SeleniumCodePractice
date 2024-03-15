package seleniumcodesnippet.test;

import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;


public class ExcelDataWriterTest 
{
	@Test
	 public static void writeDataIntoExcel() {
	        // Create a new workbook
	        XSSFWorkbook workbook = new XSSFWorkbook();

	        // Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Sheet1");

	        // Write data starting from second row and second column
	        int rowNum = 0; // Second row
	        int colNum = 0; // Second column

	        // Sample data to be written
	        String[] data = {"Surekha", "Shivaji", "Nakate"};

	        // Write data to the specified cell
	        for (String value : data) {
	            XSSFRow row = sheet.getRow(rowNum);
	            if (row == null) {
	                row = sheet.createRow(rowNum);
	            }
	            XSSFCell cell = row.createCell(colNum);
	            cell.setCellValue(value);
	            rowNum++; // Move to the next row for the next value
	        }

	        // Write the workbook to a file
	        try (FileOutputStream fileOut = new FileOutputStream("WrittenData.xlsx")) {
	            workbook.write(fileOut);
	            System.out.println("Data has been written successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Close the workbook
	        try {
	            workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
