package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 
 * @author donald
 *
 */
public class ChargingPoints {
	int id;
	int type;

	public ChargingPoints(int id, int type) {
		this.id = id;
		this.type = type;
	}

	// public
	/**
	 * 
	 * @param file
	 *            read Excel
	 * @throws IOException
	 * @throws BiffException
	 */
	public static double[] readExcel(File file) throws BiffException, IOException {

		InputStream is = new FileInputStream(file.getAbsolutePath());
		Workbook wb = Workbook.getWorkbook(is);
		int sheet_size = wb.getNumberOfSheets();
		Sheet sheet = wb.getSheet(0);
		double cellinfo = Integer.parseInt(sheet.getCell(2, 2).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo1 = Integer.parseInt(sheet.getCell(3, 2).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo2 = Integer.parseInt(sheet.getCell(2, 3).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo3 = Integer.parseInt(sheet.getCell(4, 3).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo4 = Integer.parseInt(sheet.getCell(2, 4).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo5 = Integer.parseInt(sheet.getCell(3, 4).getContents().replaceAll("\\D+", "")) * 0.01;
		double cellinfo6 = Integer.parseInt(sheet.getCell(5, 4).getContents().replaceAll("\\D+", "")) * 0.01;

		double[] speed = new double[] { cellinfo, cellinfo1, cellinfo2, cellinfo3, cellinfo4, cellinfo5, cellinfo6 };
		return speed;

	}

}
