package Excel;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileInputStream fis;
	static FileOutputStream fileOut;
	static XSSFSheet sh;
	static XSSFCell cell;
	static XSSFRow row;
	static XSSFCellStyle cellstyle;
	static XSSFColor mycolor;
	static String path;
	static String sheetN;

	public ExcelUtils(String pathed, String SheetName) throws IOException {
		path = pathed;
		wb = new XSSFWorkbook(path);
		sheetN = SheetName;
		sheet = wb.getSheet(sheetN);
	}


	public static void getCellData(int x, int y) throws IOException {
		DataFormatter df = new DataFormatter();
		Object value = df.formatCellValue(sheet.getRow(x).getCell(y));

		System.out.println(value);

	}

	public static void setExcelFile(String ExcelPath,String SheetName) throws Exception
	{  
		try{
			File f = new File(ExcelPath);
			if(!f.exists())
			{
				f.createNewFile();
				System.out.println("File doesn't exist, so created!");
			}  
			fis=new FileInputStream(ExcelPath);
			wb=new XSSFWorkbook(fis);
			sh = wb.getSheet(SheetName);
			//sh = wb.getSheetAt(0); //0 - index of 1st sheet
			if (sh == null)
			{
				sh = wb.createSheet(SheetName);
			}  
		}catch (Exception e){System.out.println(e.getMessage());}
	}

	public static void getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("N° of rows is " + rowCount);		

	}

	public static void setCellStringValue(int rowNum, int cellNum, String value) throws IOException {

		File f = new File("./data/Testu.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		
		try {
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			sheet.createRow(rowNum).createCell(cellNum).setCellValue(value);
		}

		FileOutputStream fileOut = new FileOutputStream(f);

		wb.write(fileOut);

		wb.close();
	}
	
	public static void setCellIntValue(int rowNum, int cellNum, int value) throws IOException {

		File f = new File("./data/Testu.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		
		try {
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			sheet.createRow(rowNum).createCell(cellNum).setCellValue(value);
		}

		FileOutputStream fileOut = new FileOutputStream(f);

		wb.write(fileOut);

		wb.close();
	}
	
	public static void setCellFloatValue(int rowNum, int cellNum, float value) throws IOException {

		File f = new File("./data/Testu.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		
		try {
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			sheet.createRow(rowNum).createCell(cellNum).setCellValue(value);
		}

		FileOutputStream fileOut = new FileOutputStream(f);

		wb.write(fileOut);

		wb.close();
	}
	
	public static void setCellDateValue(int rowNum, int cellNum, Date value) throws IOException {

		File f = new File("./data/Testu.xlsx");

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		
		try {
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			sheet.createRow(rowNum).createCell(cellNum).setCellValue(value);
		}

		FileOutputStream fileOut = new FileOutputStream(f);

		wb.write(fileOut);

		wb.close();
	}

}
