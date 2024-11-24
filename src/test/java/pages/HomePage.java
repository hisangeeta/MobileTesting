package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage {
	 AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public HomePage(IOSDriver driver) {
		super(driver);
	}
	
	
	
	
	@iOSXCUITFindBy(accessibility = "")
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement titleElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select the country where you want to shop\"]")
	private WebElement labelElement;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement dropdownElement;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement AfganstanElement;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your Name\")")
	private WebElement yourNamelabelEle;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter name here\")")
	private WebElement textBoxElement;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gender\")")
	private WebElement genderLeveElement;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadioButtonElement;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadioButtonElement;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButtonElement;
	
	
	
	
	
	
	public String actualTitle() {
		waitFortextToBePresent(titleElement, 30, "General Store", "Page Title");
		return getTextFromWebElement(titleElement, "Page Title");
		
	}
	
	public boolean isTitleDisplaye() {
		return titleElement.isDisplayed();
	}
	
	
	public String lableText() {
		waitFortextToBePresent(labelElement, 30, "Select the country where you want to shop", "Select Country");
		return getTextFromWebElement(labelElement, "Select Country");
		
	}
	public boolean isLableDisplayed() {
		return labelElement.isDisplayed();
	}
	
	public void click_Select_Country_DropDown() {
	waitForElementToBeClicked(dropdownElement, 30, "country drop down element");
	clickElement(dropdownElement, "Select dropdown of the countries ");
		
	}
	
	
	public boolean check_Default_valueOf_Dropdown() {
		return dropdownElement.isDisplayed();
		
	}
	
	public boolean Check_YourName_label_Displayed() {
		
		return yourNamelabelEle.isDisplayed();
	}
	
	public boolean Check_textBox_Text_Displayed() {
		waitFortextToBePresent(textBoxElement, 10, "Enter name here", "'Enter name here' textbox value");
		return textBoxElement.isDisplayed();
	}
	
	public String actualTextboxValue() {
		waitFortextToBePresent(textBoxElement, 30, "Enter name here", "Default value of textbox");
		return getTextFromWebElement(textBoxElement, "Default value of textbox");
		
	}
	
	
	public boolean genderlevelDisplayed() {
		waitFortextToBePresent(genderLeveElement, 30, "Gender", "'Gender is displayed'");
		return genderLeveElement.isDisplayed();
	}
	
	public boolean checkMaleRadioButton() {
		return maleRadioButtonElement.isDisplayed();
	}
	
	public boolean checkFemaleRadioButton() {
		return femaleRadioButtonElement.isDisplayed();
	}
	
	
	public String check_MaleRadioButton_isChecked_ByDefault() {
		
		return maleRadioButtonElement.getAttribute("checked");
	}
	
	public String Actual_ButtonText() {
		
		return letsShopButtonElement.getText();
	}
	public boolean letsShop_Button_IsDisplayed() {
		return letsShopButtonElement.isDisplayed();
	}
	
	public boolean letsShop_Button_isEnabled() {
		return letsShopButtonElement.isEnabled();
	}
	
	
	public String letsShop_Button_isclickable() {
		waitForElementToBeClicked(letsShopButtonElement, 30, "Let's Shop button");
		return letsShopButtonElement.getAttribute("clickable");
	}
	
	

	
	

}
