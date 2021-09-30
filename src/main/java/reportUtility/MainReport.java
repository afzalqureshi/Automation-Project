package reportUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonUtility.CommonFunction;

public class MainReport {
	
	public static ExtentReports extent;
	//This class is used to set custom system information in the report.
	
	public static ExtentHtmlReporter htmlreporter;
	//This class is used for initialization of blank report name
	
	public static ExtentTest test;// This class is used for logging Pass/Fail of step and used to store start test method.
	
	/**
	 * Summary:So i have created name of report dynmaically with help of time in milisecond
	 * so that we can keep older report as well.
	 * Step1: we need to crate report path in specified folder name automationReport.
	 * We have created object of ExtenthtmlReporter So that i can create blank file with the name
	 * after that attach with Extentreports.
	 * Now i have fetched all computer details where is my project is running and details
	 * related to my browser and Env where is my code executing and all details i have attached in my report.
	 * I have set down html file title and black and white theme.
	 */
	public static void generateReport()
	{
		long time=System.currentTimeMillis();
		String reportPath=System.getProperty("user.dir")+"//automationReport//Report"+time+".html";
		
		htmlreporter=new ExtentHtmlReporter(reportPath);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		String username=System.getProperty("user.name");
		String osname=System.getProperty("os.name");
		String browsername=CommonFunction.readPropertyFile("Browser");
		String env=CommonFunction.readPropertyFile("Enviornment");
		
		
		extent.setSystemInfo("User Name", username);
		extent.setSystemInfo("OS Name", osname);
		extent.setSystemInfo("Browser Name", browsername);
		extent.setSystemInfo("Enviornment", env);
		
		
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setChartVisibilityOnOpen(true);
        
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
