package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * z
 * @author donald
 *
 */
public class Customer {
	int id;
	double preferedstart;
	double preferedfinish;
	int mile;
	int evtype;

	public Customer() {

	}

	/**
	 * 
	 * @param file
	 *            read Excel
	 * @throws IOException
	 * @throws BiffException
	 */
	public static String[][] readExcel(File file) throws BiffException, IOException {

		InputStream is = new FileInputStream(file.getAbsolutePath());
		Workbook wb = Workbook.getWorkbook(is);
		int sheet_size = wb.getNumberOfSheets();
		Sheet sheet = wb.getSheet(0);
		int m = sheet.getColumns();
		int n = sheet.getRows();
//		System.out.println(n+":"+m);
		String[][] customer = new String[n][m];
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				customer[i][j] = sheet.getCell(j, i).getContents();
			}
		}
		return customer;

	}

}
