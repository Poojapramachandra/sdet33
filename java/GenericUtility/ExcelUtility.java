package GenericUtility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.ObjectArrays;

/**
 * its Developed using apache POI libaries. which used to handle Microsoft Excel sheet
 * @author POOJA P R
 *
 */
public class ExcelUtility {
	/*
	 * its used read the data from the excel base don below Arugumnets
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @retun Data
	 * @throws Throwable
	 * 
	 * 
	 */
       public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable{
    	   FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
    	   Workbook wb= WorkbookFactory.create(fis);
    	   Sheet sh= wb.getSheet(sheetName);
    	   Row row = sh.getRow(rowNum);
    	   String data = row.getCell(cellNum).getStringCellValue();
    	   wb.close();
    	   return data;
    	   
       }
    /*
   	 * its used read the data from the excel base don below Arugumnets
   	 * @param sheetName
   	 * @param rownum
   	 * @param cellnum
   	 * @retun Data
   	 * @throws Throwable
   	 * 
   	 * 
   	 */
       public int getRowCount(String sheetName) throws Throwable{
    	   FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
    	   Workbook wb= WorkbookFactory.create(fis);
    	   Sheet sh= wb.getSheet(sheetName);
    	   wb.close();
    	   return sh.getLastRowNum();
       
       }
       public void setDataExcel(String sheetName, int rowNum, int cellNum, String data ) throws Throwable{
    	   FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
    	   Workbook wb= WorkbookFactory.create(fis);
    	   Sheet sh= wb.getSheet(sheetName);
    	   Row row = sh.getRow(rowNum);
    	   Cell cell = row.createCell(cellNum);
    	   cell.setCellValue(data);
    	   FileOutputStream fos= new FileOutputStream("./src/test/resources/testdata/testdata.xlsx");
    	   wb.write(fos);
    	   wb.close();
    	   
       
       }
       
       public static Object[][] fetchMutipleData(String excelSheet) throws Throwable{
    	   FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
    	   Workbook wb= WorkbookFactory.create(fis); 
		    Sheet sh= wb.getSheet(excelSheet);
    	   Object[][] arr= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
    	   for (int i = 0; i <sh.getLastRowNum(); i++) {
    		   for (int j = 0; j <sh.getRow(0).getLastCellNum(); j++) {
    			   arr[i][j]= sh.getRow(i+1).getCell(j).toString();
			}
			
		}
    	   return  arr;
       }
       
       
}
