package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





/**
 * This file consists of generic methods related to property file
 * @author dell
 */
public class ExcelFileUtility {
	/**
	 * 
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("E:\\AdvanceSelenium\\AutomationFramework\\src\\test\\resources\\Testadata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rowNo);
		Cell cl= rw.getCell(cellNo);
		String value=cl.getStringCellValue();
		return value;
		
		
		
		
		
		
		
		
		
		
	}

}
