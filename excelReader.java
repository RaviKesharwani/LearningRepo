package practices;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class excelReader {

	//public static void main(String[] args) throws IOException, InvalidFormatException {
	//	excelread();
	//}
	
	public static void excelread() throws IOException, InvalidFormatException
	{
		File excelfile=new File("D:\\Trainings\\ExcelRead\\testfile.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(excelfile);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rownum=sheet.getLastRowNum();
		for(int i=0;i<rownum;i++)
		{
			XSSFRow rows= sheet.getRow(i);
			int cellnum=rows.getLastCellNum();
			for(int j=0;j<cellnum;j++)
			{
				XSSFCell cells=rows.getCell(j);
				System.out.println(cells.getStringCellValue()+" ");
			}
		}
		
		workbook.close();
	}

}
