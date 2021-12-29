package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * 
 * @author DELL
 *
 */
public class ExcelUtility {

	/**
	 * It is used to read the data from excel based on below arguments
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public String getDataFromExcel(String SheetName , int rowNum , int CelNum ) throws EncryptedDocumentException, Throwable {
		FileInputStream fis = new FileInputStream("./docs/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(rowNum);
		String data = ro.getCell(CelNum).getStringCellValue();
				return data;
		
	}
	/**
	 * used last used row on specified sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName ) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./docs/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		wb.close();
		return sh.getLastRowNum();
	}
    public void setDataExcel(String SheetName, int rowNum , int CelNum,String data ) throws Throwable {
    	FileInputStream fis = new FileInputStream("./docs/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(CelNum);
	   cel.setCellValue(data);
	   FileOutputStream fos = new   FileOutputStream("./docs/Book1.xlsx");
	   wb.write(fos);
	   wb.close();
	   
    }
}
