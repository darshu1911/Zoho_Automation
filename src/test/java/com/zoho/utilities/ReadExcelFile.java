package com.zoho.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {
	    try (FileInputStream inputStream = new FileInputStream(fileName);
	         Workbook workBook = new XSSFWorkbook(inputStream)) {
	        return workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	    } catch (IOException e) {
	        // Handle the exception without printing anything
	        return "";
	    }
	}

	public static int getRowCount(String fileName, String sheetName) {
	    try (FileInputStream inputStream = new FileInputStream(fileName);
	         Workbook workBook = new XSSFWorkbook(inputStream)) {
	        return workBook.getSheet(sheetName).getLastRowNum() + 1;
	    } catch (IOException e) {
	        // Handle the exception without printing anything
	        return 0;
	    }
	}

	public static int getColumnCount(String fileName, String sheetName) {
	    try (FileInputStream inputStream = new FileInputStream(fileName);
	         Workbook workBook = new XSSFWorkbook(inputStream)) {
	        return workBook.getSheet(sheetName).getRow(0).getLastCellNum();
	    } catch (IOException e) {
	        // Handle the exception without printing anything
	        return 0;
	    }
	}

}
