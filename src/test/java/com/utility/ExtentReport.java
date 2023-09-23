//package com.utility;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
////
////import com.aventstack.extentreports.ExtentReports;
////import com.aventstack.extentreports.reporter.ExtentSparkReporter;
////import com.aventstack.extentreports.reporter.configuration.Theme;import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//public class ExtentReport {
//	public static ExtentReports setupExtentReport() {
//	SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyy HH-mm-ss");
//	Date date = new Date();
//	String actualDate = format.format(date);
//	String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"+actualDate+".html";
//	
//	ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
//	
//	extent = new ExtentReports();
//	extent.attachReporter(sparkReport);
//	
//	sparkReport.config().setDocumentTitle("TEST EXECUTION REPORT");
//	sparkReport.config().setTheme(Theme.DARK);
//	sparkReport.config().setReportName("TEST EXECUTION REPORT");
//	
//	extent.setSystemInfo("Executed on Environment", "UAT");
//	extent.setSystemInfo("Executed on Browser", "Chrome");
//	extent.setSystemInfo("Executed on OS", System.getProperty("os.name"));
//	extent.setSystemInfo("Executed on Machine", System.getProperty("user.name"));
//	
//	return extent;
//}
//}
