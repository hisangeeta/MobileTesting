package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Constants.ReportConst;
import base.BaseTest;





public class MobileListeners extends BaseTest implements ITestListener {
	private Logger mylog = LogManager.getLogger(MobileListeners.class);
	private ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();


	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName()+ "Started");
		//mylog.info(context.getName() + " Started");
		extentReportUtility.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {

		mylog.info(context.getName() + " MyTest ended");
		extentReportUtility.endReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getMethod().getMethodName() + "  started..................");
		extentReportUtility.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getMethod().getMethodName() + " ended with success......................");
		extentReportUtility.logTestpassed(result.getMethod().getMethodName()+" ended with success......................");
		
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getMethod().getMethodName() + " ended with failure.....................");
		extentReportUtility.logTestFailedWithException(result.getThrowable());
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		//String path=ReportConst.SCREENSHOTS_DIRECTORY_PATH+filename+".png";
		String path=ReportConst.SCREENSHOTS_DIRECTORY_PATH+filename+".png";
		takeScreenshot(path);
		extentReportUtility.logTestWithscreenshot(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		mylog.info(result.getMethod().getMethodName() + " skiped...........................");
		extentReportUtility.logTestFailed(result.getMethod().getMethodName()+" skiped...........................");
	}
}
