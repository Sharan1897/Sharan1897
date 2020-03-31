package com.NewV1.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.Color;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

//	private static String ChartLocation = NULL;
	public ExtentHtmlReporter htmlReporter;
	
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void OnStart(ITestContext testContext)
	{
		
	  String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
	  String repName = ("Testreport- "+timestamp+".html");
	  
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/" +repName);
	  htmlReporter.loadXMLConfig(System.getProperty(("user.dir"))+ "/extent-config.xml/");
		

	  ExtentReports extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("user","Sharan");
	  extent.setSystemInfo("Environment", "QA");
	  
	  htmlReporter.config().setDocumentTitle("Facebook Test");
	  htmlReporter.config().setReportName("Fuctional Test Report");
	  htmlReporter.config().setTheme(Theme.DARK);
    //  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);	  
	}
	
	public void OnTestSuccess(ITestContext tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void OnTestFailure(ITestContext tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String ScreenshotPath = System.getProperty(("user.dir")+ "/Screenshots/"+tr.getName()+".png");
		
		File f = new File(ScreenshotPath);
		
		if(f.exists())
		{
			try
			{
				logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(ScreenshotPath));
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
				
			}
			
		}
		
		
	}
	
	public void OnTestSkip(ITestContext tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void OnTestCompletion(ITestContext testContext)
	{
		extent.flush();
	}



}
