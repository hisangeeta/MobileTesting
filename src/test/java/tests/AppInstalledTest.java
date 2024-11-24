package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.CapabilitiesConst;
import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppInstalledTest extends BaseTest {
	@Test
	public void firstTest() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver("android");

		boolean isInstalled = driver.isAppInstalled(CapabilitiesConst.PACKAGE_NAME);
		if (isInstalled) {
			System.out.println("The General Store application is installed.");
		} else {
			System.out.println("The General Store application is not installed.");
		}
	}

}
