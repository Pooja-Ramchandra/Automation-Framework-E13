package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This is used to create 
 * @author dell
 */
public class ListenerImplementation implements ITestListener {
	
	//To capture system date and time
	Date d=new Date();
	SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date=f.format(d);
	
	//For extent reports
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--TestExecution Started--");

		//Initimate the @Test for extent report
		test =report.createTest(testMethodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--TestExecution Pass--");
		
		//Log the test status as PASS in Extent reports 
		test.log(Status.PASS, testMethodName+" --- Test PASS ---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--TestExecution Fail--");
		
		//Capture the exception
		System.out.println(result.getThrowable());//used to throw exception when test case or script is skipped or failed
	
		//Log the Status as FAIL in Extent Report 
		test.log(Status.FAIL, testMethodName+" --- Test FAIL ---");
		
		 //Log the exception in extent reports
		 test.log(Status.WARNING,result.getThrowable() );
		
		//capture the screenshot
		SeleniumWaits s=new SeleniumWaits();
		
		//configuring the screenshotname
		String screenshotName = testMethodName + date;
		
		try {
			String path = s.captureScreenshot(BaseClass.sdriver,screenshotName);
			
			//Attach the screenshot to extent reports
			 test.addScreenCaptureFromPath(path, screenshotName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--Test Skip--");
		
		//Capture Exception
		 System.out.println(result.getThrowable());
		 
		//Log the status as SKIP in extent Reports 
		test.log(Status.SKIP, testMethodName+" --- Test SKIP ---"); 
		
		//Log the exception in extent report
		 test.log(Status.WARNING, result.getThrowable());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("--Suite Execution Started--");
		
		//Configure extent report
		ExtentSparkReporter esr =new ExtentSparkReporter(".\\ExtentReports\\Report-"+date+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft edge");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base URL", "http://testEnv.com");
		report.setSystemInfo("Reporter Name", "Pooja");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("--Suite Execution Finished--");
		
		//Generate extent report
		report.flush();
	}
	

}
