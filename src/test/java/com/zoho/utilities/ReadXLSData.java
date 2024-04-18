package com.zoho.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSData {
    public static File path;
    public static FileInputStream fis;
    public static Workbook wb;
    public static Sheet sheetName;
    
    @DataProvider(name ="bvData")
    public static Object[][] getData() throws EncryptedDocumentException, IOException {
        path = new File(System.getProperty("user.dir")+ "\\Test Data\\Test Data.xlsx");
        fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);
        sheetName = wb.getSheet("TC_LoginPageTestData");
        
        if(sheetName == null) {
            System.out.println("Sheet with name TC_LoginPageTestData does not exist.");
            return null; // Return null if sheet does not exist
        }
        
        int ttlRows = sheetName.getLastRowNum() + 1; // Adding 1 because getLastRowNum() returns 0-based index
        System.out.println(ttlRows);
        Row rowCells = sheetName.getRow(0);
        int ttlCells = rowCells.getLastCellNum();
        System.out.println(ttlCells);
        
        DataFormatter format = new DataFormatter();
        
        Object[][] testData = new Object[ttlRows][ttlCells];
        for (int i = 0; i < ttlRows; i++) {
            Row row = sheetName.getRow(i);
            if (row != null) {
                for (int j = 0; j < ttlCells; j++) {
                    testData[i][j] = format.formatCellValue(row.getCell(j));
                    System.out.println(testData[i][j]);
                }
            }
        }
        return testData;        
    }
}
