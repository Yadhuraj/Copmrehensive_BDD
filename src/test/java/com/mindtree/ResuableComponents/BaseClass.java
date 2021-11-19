package com.mindtree.ResuableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.mindtree.Util.OpenChromeBrowser;
import com.mindtree.Util.ReadProrperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	public static ReadProrperty rp;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	public static ExtentReports extent;
//	public static String date;
	public static String date = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
	static {
		 
				
		System.setProperty("currenttime", date);
		extent = new ExtentReports(System.getProperty("user.dir")+"\\extentreport\\"+date+"_ExtendReport.html",false);

	}

	public WebDriver DriverSetUp() {
		rp = new ReadProrperty();
		switch (rp.browser()) {
		case "chrome": {
			driver = OpenChromeBrowser.OpenChrome(driver, rp);
			break;
		}
		default: {
			System.out.println("Invalid browser");
			break;
		}
		}

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + rp.Excel());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(System.getProperty("user.dir") + rp.Excel());
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheetAt(0);
		return driver;

	}
}
