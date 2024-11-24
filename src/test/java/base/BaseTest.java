package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import Constants.CapabilitiesConst;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pages.HomePage;

public class BaseTest {
	protected static AppiumDriver driver = null;
	protected Logger mylog = LogManager.getLogger(BaseTest.class);
	
	AppiumDriverLocalService service;
	
	@BeforeSuite
	public void startServer() throws InterruptedException {
		Thread.sleep(5000);
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\hidee\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
	}
	
	
	public static AppiumDriver getDriver(String driverName) throws MalformedURLException {

		String name = driverName.toLowerCase();
		//AppiumDriver driver = null;
		switch (name) {
		case "android":
			URL url = new URL("http://127.0.0.1:4723/");
			UiAutomator2Options uio = new UiAutomator2Options();
			uio.setPlatformName("Android");
			uio.setDeviceName("ce07171790865c730b7e");
			uio.setPlatformVersion("9");
			uio.setAutomationName("UIAutomator2");
			//uio.setAppPackage(CapabilitiesConst.PACKAGE_NAME);
			//uio.setAppActivity(CapabilitiesConst.ACTIVITY_NAME);
			uio.setApp(System.getProperty("user.dir") + "/src/test/resources/apkFiles/General-Store.apk");
			driver = new AndroidDriver(url, uio);
			
			break;

		case "ios":
			URL url1 = new URL("http://127.0.0.1:4723/");
			XCUITestOptions xct = new XCUITestOptions();
			xct.setPlatformName("android");
			xct.setDeviceName("Samsung");
			xct.setPlatformVersion("13");
			xct.setAutomationName("XCUITDriver");
			xct.setApp("");
			driver = new IOSDriver(url1, xct);
			break;

		default:
			break;
		}
		return driver;
	}

	public void takeScreenshot(String filepath) {

		TakesScreenshot screenCapture = (TakesScreenshot) driver;// typcasting webdriver driver to takescreenshot type
		File src = screenCapture.getScreenshotAs(OutputType.FILE);// screenshot
		File destFile = new File(filepath);
		try {
			Files.copy(src, destFile);
			mylog.info("screen captured");
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
			mylog.error("problem occured during screenshot taking");
		}
	}

	public void takePartialScreenshot(WebElement ele, String filepath) {
		File src = ele.getScreenshotAs(OutputType.FILE); // getScreenshotAs method is used directely to take the
															// screenshot of webelement.
		File destFile = new File(filepath);
		try {
			Files.copy(src, destFile);
			mylog.info("screen captured");
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
			mylog.error("problem occured during screenshot taking");
		}
	}
	

}
