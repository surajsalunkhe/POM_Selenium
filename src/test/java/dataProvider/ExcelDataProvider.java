/**
 * 
 */
package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author SurajS
 *
 */
public class ExcelDataProvider {
	

	public  static String filepath="E:\\Suraj\\Selenium\\TestSheet.xlsx";
	public  FileInputStream fis = null;
	public  FileOutputStream fout =null;
	public static Workbook wb;
	private static Sheet sh;	
	
	
	public ExcelDataProvider()
	{
		File datafile=new File(filepath);
		try {
			fis = new FileInputStream(datafile);
			
			//verify the extension of file and apply the sheet type
			String fileExtensionName = filepath.substring(filepath.indexOf("."));
			if(fileExtensionName.equalsIgnoreCase(".xlsx"))
			{
				wb=new XSSFWorkbook(fis);
			}
			else if(fileExtensionName.equalsIgnoreCase(".xls"))
			{
				wb=new HSSFWorkbook(fis);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in dataprovider file"+e.getMessage());
		}
	}//end of constructor
	
	//return tow count
	public int rowcount(String sheetname)
	{
		int index=wb.getSheetIndex(sheetname);
		if(index==-1){
			
			return 0;
		}else{
			sh=wb.getSheetAt(index);
			int number=sh.getLastRowNum()+1;
			return number;
		}
		
	}//end row count
	public int rowcount(int sheetno)
	{
		
		if(sheetno<=-1 ){
			
			return 0;
		}else{
			sh=wb.getSheetAt(sheetno);
			int number=sh.getLastRowNum()+1;
			return number;
		}
		
	}//end row count
	
	//get data via sheet name
	public String getCellData(String sheetname,int row,int col){
		
			if(row <=0){
				return "";
			}
			else if(col<=0)
			{
				return "";
			}
			else{				
			int index = wb.getSheetIndex(sheetname);			
			String data=wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue().trim();
			
			return data;
			}						
	}//end of getcellData
	
	//Get data via index
	public String getCellData(int sheetindex,int row,int col){
		
			if(row <=0){
				return "";
			}
			else if(col<=0)
			{
				return "";
			}
			else{						
			String data=wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue().trim();
			return data;
			}						
	}//end of getcellData
	
	public boolean setcellData(String sheetName,int row,int col, String data){
		if(row <=0){
			return false;
		}
		else if(col<=0)
		{
			return false;
		}
		else{		
		int index=wb.getSheetIndex(sheetName);	
		wb.getSheetAt(index).getRow(row).createCell(col).setCellValue(data);
		try {
			fout=new FileOutputStream(filepath);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to write data"+e.getMessage());
		}
		return true;
		}
		
	}
		
}
	

