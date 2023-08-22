package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	// DataProvider 1
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking excel file from testdata
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalRows][totalCols]; // create 2 dim array to store the data user and
																	// password

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
	
	//DataProvider 2
	
	
	//DataProvider 3
	
	
	//DataProvider 4
	
	
	//DataProvider 5
	
}
