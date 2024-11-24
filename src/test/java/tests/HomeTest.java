package tests;

import java.net.MalformedURLException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage;

public class HomeTest extends BaseTest {

	@Test
	public void fieldTest() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver)getDriver("android");
		
//		IOSDriver iosDriver =  (IOSDriver) BaseTest.getDriver("ios");
		
		
	/*	WebElement letsShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		String Expected_letsShotpButton = "Let's  Shop";
		String Actual_letsShotpButton = letsShopButton.getText();
		Assert.assertEquals(Actual_letsShotpButton, Expected_letsShotpButton);
		Assert.assertTrue(letsShopButton.isDisplayed(), "The button is not displayed.");
		Assert.assertTrue(letsShopButton.isEnabled(), "The button is not enabled.");
		Assert.assertTrue(letsShopButton.getAttribute("clickable").equals("true"));

		System.out.println("Let's shop button is validated");*/
	
	
	HomePage homePage= new HomePage(driver); 
		//verify title of the page
		String expectedTitle = "General Store";
		Assert.assertTrue(homePage.isTitleDisplaye(),"The title element is not displayed.");
		Assert.assertEquals(homePage.actualTitle(), expectedTitle, "The title text does not match.");
		System.out.println("");
		//protected Logger mylog = LogManager.getLogger(BaseTest.class);
		mylog.info("Title verification passed!");
		// verify the fields lables and types
		

		//The first field should be a dropdown with label "Select the country where you want to shop" and "Afghanistan" as default country
		Assert.assertTrue(homePage.isLableDisplayed(), "The label is not displayed.");
		Assert.assertEquals(homePage.lableText(), "Select the country where you want to shop",
				"The label text does not  match.");
		Assert.assertTrue(homePage.check_Default_valueOf_Dropdown(), "Afghanistan is not default value in dropdown");
		mylog.info("Select the country where you want to shop\" and \"Afghanistan\" as default country is verified");
		//homePage.click_Select_Country_DropDown();//click on select country dropdown
	
		//dropdownElement.click();
		//validate The Second field should be a Text box with label "Your Name" and place holder label "Enter name here"
		Assert.assertTrue(homePage.Check_YourName_label_Displayed(), "The label 'Your Name'not displayed.");
		Assert.assertTrue(homePage.Check_textBox_Text_Displayed(), "The textbox text 'Enter name here' is not displayed.");
		Assert.assertEquals(homePage.actualTextboxValue(), "Enter name here","The label text 'Enter name here' does not  match.");
		mylog.info("label \"Your Name\" and place holder label \"Enter name here\" is verified");
		
		//Verify the third field is a radio button with a label "Gender"
		//The third field should be a radio button with label "and with 2 options Male and Female and Male is selected as default
		Assert.assertTrue(homePage.genderlevelDisplayed(), "The Gender label not displayed.");
		Assert.assertTrue(homePage.checkMaleRadioButton(), "The male radio button not displayed.");
		Assert.assertTrue(homePage.checkFemaleRadioButton(), "The female radio button not displayed.");
		Assert.assertEquals(homePage.check_MaleRadioButton_isChecked_ByDefault(), "true","Male radio button is not selected by default.");
		mylog.info("radio button and Male value selected by default is verified");
		
		//Verify the last field is a clickable button with a label "Let's Shop"
		Assert.assertTrue(homePage.letsShop_Button_IsDisplayed(), "Lets Shop label not displayed.");
		Assert.assertTrue(homePage.letsShop_Button_isEnabled(), "Lets Shop label not enabled.");
		Assert.assertEquals(homePage.letsShop_Button_isclickable(), "true","Lets shop button is not clickable.");
		mylog.info("clickable button with a label \"Let's Shop\" is validated");
	}

}