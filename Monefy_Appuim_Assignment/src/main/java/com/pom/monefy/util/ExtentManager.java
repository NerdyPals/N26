package com.pom.monefy.util;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;
    public static String screenshotFolderPath;
    
    
    
    public static ExtentReports getInstance(String reportPath) {
    	if (extent == null){
    		String fileName="Report.html";
    		Date d = new Date();
    		String folderName=d.toString().replace(":", "_").replace(" ", "_");
    		
    		// directory of the report folder
    		new File(reportPath+folderName+"//screenshots").mkdirs();
    		reportPath=reportPath+folderName+"//";
    		screenshotFolderPath=reportPath+"screenshots//";
    		System.out.println("screenshot folder path:"+screenshotFolderPath);
    		System.out.println(reportPath+"\\"+fileName);
    		createInstance(reportPath+fileName);
    	}
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter spark=new ExtentSparkReporter(fileName);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Reports");
        spark.config().setEncoding("utf-8");
        spark.config().setReportName("Reports - Automation Testing");
        spark.config().setCSS("css-string");
        spark.config().enableTimeline(true);
        spark.config().setJS("js-string");
   
        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        return extent;
    }
}