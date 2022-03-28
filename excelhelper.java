package practices;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelhelper {
	private String filepath;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	HashMap<String, String> hp;
	
	public excelhelper(String filepath) throws InvalidFormatException, IOException
	{
		this.filepath=filepath;
		workbook=new XSSFWorkbook(new File(filepath));
	}
	
	public Integer getRowNumber(String Sheetname) 
	{
		sheet=workbook.getSheet(Sheetname);
		int rownum=sheet.getLastRowNum();
		return rownum;
	}
	
	public Object[][] getdata()
	{
		int rownumber=getRowNumber("Sheet1");
		Object[][] data=new Object[rownumber][1];
		XSSFRow titleRow=sheet.getRow(0);
		System.out.println("Total row: "+rownumber);
		for(int i=0;i<rownumber;i++)
		{
			XSSFRow rows= sheet.getRow(i+1);
			int cellnum=rows.getLastCellNum();
			hp=new HashMap();
			for(int j=0;j<cellnum;j++)
			{
				XSSFCell cells=rows.getCell(j);
				System.out.println(cells.getStringCellValue()+" ");
				hp.put(titleRow.getCell(j).getStringCellValue(), cells.getStringCellValue());
			}
			data[i][0]=hp;
		}
		return data;
	}
}
