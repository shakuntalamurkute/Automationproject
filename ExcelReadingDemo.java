package excelReadingFile;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingDemo {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\readData.xlsx";
		String sheetName ="PlayerInfo";
		Object[][] data;
		try {
			FileInputStream fis = new FileInputStream(path);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum(); // 6
			int totalCols = sheet.getRow(0).getLastCellNum(); // 4
			data = new Object[totalRows][totalCols];
			for (int i = 1; i <= totalRows; i++) {
				for (int j = 0; j < totalCols; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue().toString();
				}
				System.out.println();
				
			}

		} catch (FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("File Not found " + path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in opening workbook " + path);
		}

		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++)
				System.out.print(String.format("%10s", data[r][c]));
			System.out.println();
		}

	}

}
