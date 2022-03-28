package practices;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReadData {
	
	@Test(dataProvider = "getData")
	public void readData(HashMap<String,String> hp)
	{
		System.out.println("Name is:"+hp.get("Name") +" and email is: "+hp.get("Email"));
	}
	
	@DataProvider
	public Object[][] getData() throws InvalidFormatException, IOException
	{
		excelhelper excel=new excelhelper("D:\\Trainings\\ExcelRead\\testfile.xlsx");
		Object[][] data=excel.getdata();
		return data;
	}

}
