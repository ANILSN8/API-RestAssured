package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author A
 *
 */
public class ExcelUtility {
	/**
	 * This method is used to read the data from excel
	 * @param SheetName
	 * @param rowNum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String SheetName,int rowNum,int cellnum) throws Throwable {
	FileInputStream fis=new FileInputStream(IConstants.excelpath);
	Workbook wb= WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet(SheetName);
	  Row row = sh.getRow(rowNum);
	  Cell cell = row.getCell(cellnum);
	  DataFormatter df=new DataFormatter();
	 String data = df.formatCellValue(cell);
	  return data;
	}
	/**
	 * it is used to insert the data into excel
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertIntoExcel(String SheetName,int RowNum,int CellNum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(RowNum);
		Cell cell = row.createCell(CellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IConstants.excelpath);
		wb.write(fos);
		
	}
	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getLastRowNum(String SheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sh = wb.getSheet(SheetName);
	        int	row=sh.getLastRowNum();
			return row;
	}
}
