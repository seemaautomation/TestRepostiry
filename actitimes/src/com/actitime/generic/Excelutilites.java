package com.actitime.generic;
/** @author seem1;
 * create on 5dec, 2018 at 7:00pm
 * 
  */
 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutilites {
	public static String readData(String filePath, String sheet, int row, int cell) {
		String value= null;
		try {
		Workbook wb = WorkbookFactory.create(new FileInputStream (new File(filePath)));
	value=	wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
