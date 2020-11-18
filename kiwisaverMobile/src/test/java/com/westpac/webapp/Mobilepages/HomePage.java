package com.westpac.webapp.Mobilepages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.westpac.co.nz/")
public class HomePage extends AppiumPageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="swMobileMenuToggle")
    public WebElement lnkPersonal;
	
	@FindBy(xpath=".//a/span[text()='KiwiSaver']")
    public WebElement lnkKiwiSaver;
	
	@FindBy(xpath=".//a[@href='/kiwisaver/calculators/'][@class='sw-page-item-link']")
    public WebElement lnkKiwiSaverCalc;
	
//###################################################################################################################################
//Function Name:		launchApplication 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to launch the application using the base url configured in serenity property file
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void launchApplication() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.westpac.co.nz/");
			String title= getDriver().getTitle().trim();
			assertEquals("Bank | Westpac New Zealand - Helping Kiwis with their personal banking", title);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//###################################################################################################################################
//Function Name:		clickPersonal 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to click Personal link from Home page tabs
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void clickPersonal() {
		try {
			if(isElementPresent(lnkPersonal)) {	
				clickOn(lnkPersonal);
				waitFor(ExpectedConditions.elementToBeClickable(lnkKiwiSaver));	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
//###################################################################################################################################
//Function Name:		clickKiwiSaver 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to click Kiwi Saver link from Home page tabs
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void clickKiwiSaver() {
		try {
			if(isElementPresent(lnkKiwiSaver)) {	
				clickOn(lnkKiwiSaver);
				waitFor(ExpectedConditions.elementToBeClickable(lnkKiwiSaverCalc));	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		clickKiwiSaverCalc 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to click Kiwi Saver calculator once kiwisaver is clicked from Home page tabs
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void clickKiwiSaverCalc() {
		try {
			System.out.println(isElementVisible(lnkKiwiSaverCalc));
			if(isElementVisible(lnkKiwiSaverCalc)) {
				clickOn(lnkKiwiSaverCalc);
				waitForTitleToAppear("KiwiSaver calculator - Westpac NZ");
				String title= getDriver().getTitle().trim();
				assertEquals("KiwiSaver calculator - Westpac NZ", title);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
