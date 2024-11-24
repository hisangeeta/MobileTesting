import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.app.ActivityOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.ActionUtils;

public class Demo {
	
	public static final Origin VIEW = Origin.viewport();
	public static final Duration ZERO_SEC = Duration.ZERO;
	
public static void main(String[] args) throws MalformedURLException, InterruptedException {
//	DesiredCapabilities dc= new DesiredCapabilities();
//	dc.setCapability("platformName", "android");
//	dc.setCapability("platformVersion", "14");
//	dc.setCapability("deviceName", "emulator-5554");
//	dc.setCapability("appPackage", "com.solodroid.solomerce");
//	dc.setCapability("appActivity", ".activities.MainActivity");
//	dc.setCapability("automationName", "uiAutomator2");
	
	// com.google.android.contacts/com.android.contacts.activities.PeopleActivity
	
	UiAutomator2Options dc = new UiAutomator2Options();
	dc.setCapability("platformName", "android");
	dc.setCapability("platformVersion", "14");
	dc.setCapability("deviceName", "emulator-5554");
	dc.setCapability("appPackage", "com.solodroid.solomerce");
	dc.setCapability("appActivity", ".activities.MainActivity");
//	dc.setCapability("appPackage", "com.google.android.contacts");
//	dc.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
	dc.setCapability("automationName", "uiAutomator2");
//	dc.autoGrantPermissions();
//	dc.noReset();
//	dc.setCapability("setUnlockType", "pin");
//	dc.setCapability("setUnlockPin", "14789");
	
	URL appium = new URL("http://127.0.0.1:4723");
	AndroidDriver driver = new AndroidDriver(appium, dc);
//	driver.findElement(AppiumBy.id(""));
//	driver.lockDevice();
//	Thread.sleep(2000);
//	driver.unlockDevice();
//	android:id/button2
//	WebElement search = driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/search"));
//	WebElement skipButton = driver.findElement(AppiumBy.id("android:id/button2"));
//	skipButton.click();
//	driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("Samsung");
	Thread.sleep(2000);
	
//	43 892
//	937 892
	
//	driver.findElement(AppiumBy.xpath("(//android.widget.TextView[text(),'Samsung Galaxy S10 - Black'])[3]")).click();
//	Thread.sleep(2000);
//	driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/product_image")).click();
//	Thread.sleep(2000);
	
//	RemoteWebElement image = (RemoteWebElement) driver.findElement(AppiumBy.id("com.solodroid.solomerce:id/action_bar_root"));
//	
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId", image.getId(), "percent", 0.75));
//	Thread.sleep(2000);
//	js.executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId", image.getId(), "percent", 0.75));
//	js.executeScript("mobile: doubleClickGesture", ImmutableMap.of("elementId", image.getId()));
	
	String scrollContainer = "new UiSelector().resourceId(\"com.solodroid.solomerce:id/recycler_view\")";
	String elementToScroll = "new UiSelector().textStartsWith(\"Animal Jumpsuit\")";
	
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable("+scrollContainer+")"
			+ ".scrollIntoView("+elementToScroll+")")).click();
	
//	Identify scrollable container - DONE
//	Then you can scroll - 
//	? To a point - Identify element
	
	
//	ActionUtils.pinchZoom(driver);
	
	
//	driver.perform(Arrays.asList(swipe, swipe2));
	
//	driver.runAppInBackground(Duration.ofSeconds(5));
//	driver.lockDevice();
//	Thread.sleep(1000);
//	driver.unlockDevice();
//	Thread.sleep(2000);
//	Activity activity = new Activity("com.google.android.contacts", "com.android.contacts.activities.PeopleActivity");
//	driver.startActivity(activity);
//	driver.navigate().back();
//	if(driver.getOrientation().equals(ScreenOrientation.PORTRAIT)) {
//		driver.rotate(ScreenOrientation.LANDSCAPE);
//	}
//	
	
	System.out.println("PASS");
}	

}
