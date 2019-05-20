package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 * @author donald
 *
 */
public class EVchargingReservation {
	public static void main(String[] args) throws BiffException, IOException {
		long startTime=System.currentTimeMillis();
		File file = new File("/Users/donald/test1.xls");
		double[] speed = ChargingPoints.readExcel(file);
//		System.out.println(speed[3]);
		// System.out.println(speed[1]);
		// for(int i=0;i<aa.length;i++) {
		// System.out.print(aa[i]+"\t");
		// }

		File file2 = new File("/Users/donald/test4.xls");
		String[][] pairs = readExcel(file2);

		int[][] intpairs = tointarry(pairs);
		boolean[] a = pairsexist2(intpairs);
		System.out.println(a[0]);
		// boolean[] a = new boolean[1];
		// ArrayList<Integer> colvalues = new ArrayList<>();
		// for (int i = 0; i < intpairs.length; i++) {
		// colvalues.add(intpairs[i][1]);
		// }
		// if (colvalues.contains(3)) {
		// a[0] = true;
		//
		// } else {
		// a[0] = false;
		// }
		// System.out.println(a[0]);

		for (int i = 0; i < intpairs.length; i++) {
			for (int j = 0; j < intpairs[i].length; j++) {
				System.out.print(intpairs[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(intpairs.length);
		// List<List<String>> listTest = new ArrayList<List<String>>();
		// for (int i = 0; i < pairs.length; i++) {
		// List<String> columnList = new ArrayList<String>();
		// for (int j = 0; j < pairs[i].length; j++) {
		//
		// columnList.add(j, pairs[i][j]);
		//
		// }
		// listTest.add(i, columnList);
		// }
		// System.out.println(listTest);
		// for (int i = 0; i < pairs.length; i++) {
		// for (int j = 0; j < pairs[i].length; j++) {
		// System.out.print(pairs[i][j] + " ");
		// }
		// System.out.println(" ");
		// }
		String[][] customer = Customer.readExcel(file2);
		 int[][] arr = tointarry1(customer);
		//
		// ArrayList<Integer> array = new ArrayList<>();
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i][4] == 3) {
		// array.add(i);
		// }
		// }
		//
		// int[][] a = new int[3][arr[0].length];
		// int[]s;
		// for(int n=0;n<array.size();n++) {
		// for(int j=0;j<arr[0].length;j++) {
		//
		// a[n][j]=arr[array.get(n)][j];
		// System.out.print(a[n][j]+"");
		//
		// }
		// }
//
		 for (int i = 0; i < arr.length; i++) {
		 for (int j = 0; j < arr[i].length; j++) {
		 System.out.print(arr[i][j] + " ");
		 }
		 System.out.println(" ");
		 }
		 System.out.println(arr.length);

		int[][] intcustomer1 = allocate1(tointarry1(customer));
		int[][] intcustomer2 = allocate2(tointarry1(customer));
		int[][] intcustomer3 = allocate3(tointarry1(customer));
		// for (int i = 0; i < intcustomer3.length; i++) {
		// for (int j = 0; j < intcustomer3[i].length; j++) {
		// System.out.print(intcustomer3[i][j] + " ");
		// }
		// System.out.println(" ");
		// }

		ArrayList<ArrayList<Integer>> list1 = bruteforce1(intcustomer1);
		ArrayList<ArrayList<Integer>> list2 = bruteforce2(intcustomer2);
		ArrayList<ArrayList<Integer>> list3 = bruteforce3(intcustomer3);

		Iterator it1 = list1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		Iterator it3 = list3.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		System.out.println(list1.size() + list2.size() + list3.size());
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");   

	}
	// for (int i = 0; i < customer.length; i++) {
	// for (int j = 0; j < customer[i].length; j++) {
	// System.out.print(customer[i][j] + " ");
	// }
	// System.out.println(" ");
	// }

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
		Sheet sheet = wb.getSheet(1);
		// ArrayList<Integer> arraysort = new ArrayList<>();
		// ArrayList<Integer> arraysort1 = new ArrayList<>();
		int m = sheet.getColumns();
		int n = sheet.getRows();
//		System.out.println(n+":"+m);
		String[][] pairs = new String[n][m];
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				pairs[i][j] = sheet.getCell(j, i).getContents();
			}
		}
		

		// int[] a = new int[sheet.getRows() - 1];
		// for (int i = 1; i < sheet.getRows(); i++) {
		// arraysort.add(Integer.parseInt((sheet.getCell(1, i).getContents()).trim()));
		// }
		// System.out.println(arraysort);
		// for (int j = 1; j < sheet.getRows(); j++) {
		// arraysort1.add(Integer.parseInt(sheet.getCell(0, j).getContents().trim()));
		// }
		// System.out.println(arraysort1);
		// for (int i = 0; i < arraysort.size(); i++) {
		// for (int j = 0; j < arraysort1.size(); j++) {
		// if (i == j) {
		// System.out.print("(" + arraysort.get(i) + "," + arraysort1.get(j) + ")" + "
		// ");
		// }
		// }
		// }
		return pairs;

	}

	public static int[][] tointarry(String[][] arr) {
		String[][] arr1 = new String[arr.length - 1][arr[0].length];
		System.arraycopy(arr, 1, arr1, 0, arr.length - 1);
		int[][] intarr = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				intarr[i][j] = Integer.parseInt(arr1[i][j]);
			}
		}
		for (int j = 0; j < intarr.length - 1; j++) {
			for (int i = 0; i < intarr.length - j - 1; i++) {
				int[] ss;
				if (intarr[i][1] < intarr[i + 1][1]) {
					ss = intarr[i];
					intarr[i] = intarr[i + 1];
					intarr[i + 1] = ss;

				}
			}
		}
		// ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		// for (int i = 0; i < arr.length; i++) {
		// ArrayList<String> listSub = new ArrayList<String>();
		// for (int j = 0; j < arr[i].length; j++) {
		// listSub.add(arr[i][j]);
		// }
		// list.add(listSub);
		// }
		// list.remove(0);

		return intarr;
	}

	public static int[][] tointarry1(String[][] arr) {
		String[][] arr1 = new String[arr.length - 1][arr[0].length];
		System.arraycopy(arr, 1, arr1, 0, arr.length - 1);
		int[][] intarr = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				if (j > 0 && j < 3) {
					String[] a = arr1[i][j].split(":");
					intarr[i][j] = Integer.parseInt(a[0].trim()) * 60 + Integer.parseInt(a[1].trim());
				} else {
					intarr[i][j] = Integer.parseInt(arr1[i][j]);
				}

			}

		}
		for (int j = 0; j < intarr.length - 1; j++) {
			for (int i = 0; i < intarr.length - j - 1; i++) {
				int[] ss;
				if (intarr[i][2] > intarr[i + 1][2]) {
					ss = intarr[i];
					intarr[i] = intarr[i + 1];
					intarr[i + 1] = ss;
				} else if (intarr[i][2] == intarr[i + 1][2]) {
					if (intarr[i][1] > intarr[i + 1][1]) {
						ss = intarr[i];
						intarr[i] = intarr[i + 1];
						intarr[i + 1] = ss;
					}
				}
			}
		}

		return intarr;
	}

	public static int[][] allocate2(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 2) {
				count++;
			}
		}
		int[][] a = new int[count][arr[0].length];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 2) {
				array.add(i);
			}
		}
		for (int n = 0; n < array.size(); n++) {
			for (int i = 0; i < arr[0].length; i++) {
				a[n][i] = arr[array.get(n)][i];
			}
		}
		return a;
	}

	public static int[][] allocate3(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 3) {
				count++;
			}
		}
		int[][] a = new int[count][arr[0].length];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 3) {
				array.add(i);
			}
		}
		for (int n = 0; n < array.size(); n++) {
			for (int i = 0; i < arr[0].length; i++) {
				a[n][i] = arr[array.get(n)][i];
			}
		}
		return a;
	}

	public static int[][] allocate1(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 1) {
				count++;
			}
		}
		int[][] a = new int[count][arr[0].length];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][4] == 1) {
				array.add(i);
			}
		}
		for (int n = 0; n < array.size(); n++) {
			for (int i = 0; i < arr[0].length; i++) {
				a[n][i] = arr[array.get(n)][i];
			}
		}
		return a;
		
	}

	/**
	 * 
	 * @param arr
	 * @return
	 * @throws IOException
	 * @throws BiffException
	 */
	public static ArrayList<ArrayList<Integer>> bruteforce3(int[][] arr) throws BiffException, IOException {
		File file = new File("/Users/donald/test1.xls");
		double[] speed = ChargingPoints.readExcel(file);
		File file2 = new File("/Users/donald/test4.xls");
		String[][] pairs = readExcel(file2);
		int[][] intpairs = tointarry(pairs);
		boolean[] a = pairsexist3(intpairs);
		ArrayList<Integer> list = null;
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		double n = arr[0][1];

		for (int x = 0; x < arr.length; x++) {
			arr[x] = Arrays.copyOf(arr[x], arr[x].length + 1);
			if (a[0] == true) {
				arr[x][arr[x].length - 1] = 4;
			} else if (a[0] == false) {
				arr[x][arr[x].length - 1] = 2;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			if (n >= arr[i][1] && a[0] == true) {
				n = n + (int)Math.floor((arr[i][3] / speed[6]));
			} else if (n < arr[i][1] && a[0] == true) {
				n = arr[i][1] +(int) Math.floor((arr[i][3] / speed[6]));
			}else {
				break;
			}
			if (n <= arr[i][2]) {
				for (int j = 0; j < arr[i].length; j++) {
					list.add(arr[i][j]);
				}
			} else {
				n=n-(int)Math.floor((arr[i][3] / speed[5]));
				continue;
			}
			list2.add(list);
		}
		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			 if (n >= arr[i][1] && a[0] == false) {
				n = n + (int)Math.floor((arr[i][3] / speed[5]));
			} else if (n < arr[i][1] && a[0] == false) {
				n = arr[i][1] +(int) Math.floor((arr[i][3] / speed[5]));
			}
			else {
				break;
			}
			if (n <= arr[i][2]) {
				for (int j = 0; j < arr[i].length; j++) {
					list.add(arr[i][j]);
				}
			} else {
				n=n-(int)Math.floor((arr[i][3] / speed[5]));
				continue;
			}
			list2.add(list);
		}
		return list2;
	}

	public static ArrayList<ArrayList<Integer>> bruteforce2(int[][] arr) throws BiffException, IOException {
		File file = new File("/Users/donald/test1.xls");
		double[] speed = ChargingPoints.readExcel(file);
		File file2 = new File("/Users/donald/test4.xls");
		String[][] pairs = readExcel(file2);
		int[][] intpairs = tointarry(pairs);
		boolean[] a = pairsexist2(intpairs);
		ArrayList<Integer> list = null;
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		double n = arr[0][1];
		for (int x = 0; x < arr.length; x++) {
			arr[x] = Arrays.copyOf(arr[x], arr[x].length + 1);
			if (a[0] == true) {
				arr[x][arr[x].length - 1] = 3;
			} else if (a[0] == false) {
				arr[x][arr[x].length - 1] = 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			if (n >= arr[i][1] && a[0] == true) {
				n = n + (int)Math.floor((arr[i][3] / speed[3]));
			}else  if (n < arr[i][1] && a[0] == true) {
				n = arr[i][1] + (int)Math.floor((arr[i][3] / speed[3]));
			} else {
				break;
			}
			if (n <= arr[i][2]) {
				for (int j = 0; j < arr[i].length; j++) {
					list.add(arr[i][j]);
				}
			} else {
				
				n=n-(int)Math.floor((arr[i][3] / speed[3]));
				continue;
			}
			
			list2.add(list);
		}
		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			 if (n >= arr[i][1] && a[0] == false) {
				n = n + (int)Math.floor((arr[i][3] / speed[2]));
			}  else if (n < arr[i][1] && a[0] == false) {
				n = arr[i][1] + (int)Math.floor((arr[i][3] / speed[2]));
			}else {
				break;
			}
			 if (n <= arr[i][2]) {
					for (int j = 0; j < arr[i].length; j++) {
						list.add(arr[i][j]);
					}
				} else {
					
					n=n-(int)Math.floor((arr[i][3] / speed[2]));
					continue;
				}			
				list2.add(list);
			}
		return list2;
	}

	public static ArrayList<ArrayList<Integer>> bruteforce1(int[][] arr) throws BiffException, IOException {
		File file = new File("/Users/donald/test1.xls");
		double[] speed = ChargingPoints.readExcel(file);
		File file2 = new File("/Users/donald/test4.xls");
		String[][] pairs = readExcel(file2);
		int[][] intpairs = tointarry(pairs);
		boolean[] a = pairsexist1(intpairs);
		ArrayList<Integer> list = null;
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		
		
		double n = arr[0][1];
		for (int x = 0; x < arr.length; x++) {
			arr[x] = Arrays.copyOf(arr[x], arr[x].length + 1);
			if (a[0] == true) {
				arr[x][arr[x].length - 1] = 2;
			} else if (a[0] == false) {
				arr[x][arr[x].length - 1] = 1;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			if (n >= arr[i][1]&& a[0] == true) {
				n = n + (int)Math.floor((arr[i][3] / speed[1]));
			} else if(n < arr[i][1] && a[0] == true){
				n = arr[i][1] + (int)Math.floor((arr[i][3] / speed[1]));
			}
			else {
				break;
			}
			if (n <= arr[i][2]) {
				for (int j = 0; j < arr[i].length; j++) {
					list.add(arr[i][j]);
				}
			} else {
				n=n-(int)Math.floor((arr[i][3] / speed[1]));
				continue;
			}
			list2.add(list);
		}
		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Integer>();
			 if (n >= arr[i][1] && a[0] == false) {
				n = n + (int)Math.floor((arr[i][3] / speed[0]));
			} else if (n < arr[i][1] && a[0] == false) {
				n = arr[i][1] + (int)Math.floor((arr[i][3] / speed[0]));
			}else {
				break;
			}
			if (n <= arr[i][2]) {
				for (int j = 0; j < arr[i].length; j++) {
					list.add(arr[i][j]);
				}
			} else {
				n=n-(int)Math.floor((arr[i][3] / speed[0]));
				continue;
			}
			list2.add(list);
		}
		return list2;
		
	}

	public static boolean[] pairsexist1(int[][] arr) {
		boolean[] a = new boolean[1];
		ArrayList<Integer> colvalues = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			colvalues.add(arr[i][1]);
		}
		if (colvalues.contains(2)) {
			a[0] = true;
		} else {
			a[0] = false;
		}
		return a;
	}

	public static boolean[] pairsexist2(int[][] arr) {
		boolean[] a = new boolean[1];
		ArrayList<Integer> colvalues = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			colvalues.add(arr[i][1]);
		}
		if (colvalues.contains(3)) {
			a[0] = true;
		} else {
			a[0] = false;
		}
		return a;
	}

	public static boolean[] pairsexist3(int[][] arr) {
		boolean[] a = new boolean[1];
		ArrayList<Integer> colvalues = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			colvalues.add(arr[i][1]);
		}
		if (colvalues.contains(4)) {
			a[0] = true;
		} else {
			a[0] = false;
		}
		return a;
	}
	public void writeexcel() {
		
	}
}
