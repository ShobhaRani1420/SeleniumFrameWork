package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Campaign");
		for (int i = 0; i <=sheet.getLastRowNum(); i++) 
		{
			Row row = sheet.getRow(i);
			for (int j = 0; j <=row.getLastCellNum(); j++) 
			{
				Cell cell = row.getCell(j);
				DataFormatter dataFormatter=new DataFormatter();
				String data = dataFormatter.formatCellValue(cell);
				System.out.println(data);
			}
		}


	}

}
