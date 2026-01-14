package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

	public static Object[][] getFiscalReasonData(String filePath, String sheetName) {

	    Object[][] data = null;

	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getLastCellNum();

	        data = new Object[rowCount - 1][colCount];
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[i - 1][j] = formatter.formatCellValue(cell);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return data;
	}

}
