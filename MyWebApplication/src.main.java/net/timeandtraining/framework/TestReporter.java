package net.timeandtraining.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestReporter extends TestBase implements ITestListener {
		static final String OUTPUT_FOLDER = "test-output/";
    	static final String FILE_NAME = "automation-report.html";
    	private static ExtentReports extent = ExtentManager.createInstance(OUTPUT_FOLDER+FILE_NAME);
    	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    	private static ExtentTest child;
    	public synchronized static ExtentTest getReporter() {
    	return child;
    }
	
    @Override
	public synchronized void onStart(ITestContext context) {
    	ExtentTest parent = extent.createTest(context.getCurrentXmlTest().getName());
        	parentTest.set(parent);
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
        test.set(child);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		((ExtentTest) test.get()).pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		
		long currentMilisecond = System.currentTimeMillis();
		File capturedFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
		FileUtils.copyFile(capturedFile, new File(OUTPUT_FOLDER+"screenshots/"+currentMilisecond+".png"));
		((ExtentTest) test.get()).fail(result.getThrowable()).addScreenCaptureFromPath("screenshots/"+currentMilisecond+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		((ExtentTest) test.get()).skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}

class ExtentManager {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
    	if (extent == null)
    		createInstance(TestReporter.OUTPUT_FOLDER+TestReporter.FILE_NAME);
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }
}
