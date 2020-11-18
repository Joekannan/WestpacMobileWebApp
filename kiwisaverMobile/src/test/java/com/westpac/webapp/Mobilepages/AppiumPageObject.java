package com.westpac.webapp.Mobilepages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.webdriver.WebDriverFacade;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.pages.PageObject;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.google.common.base.Predicate;
import org.openqa.selenium.support.PageFactory;


public class AppiumPageObject extends PageObject {
	
	public static String Value;
	public WebDriver facade = getDriver();
	public WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();

	//########################################################################################################################################################################	 

	  public AppiumPageObject(WebDriver driver) {
		  super(driver, new Predicate<PageObject>() {
			  @Override
			  public boolean apply(PageObject page) {
	
				  PageFactory
						  .initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver(),
								  page.getImplicitWaitTimeout()), page);
				  return true;
				  
			  }
	
		  });
	  }


//########################################################################################################################################################################	  
  public boolean isElementPresent(WebElement we) {

	     if(we!=null) {
	    	 return true; 
	    }
	     else {
	         System.out.println("The target is null");
         return false;
     }
 } 
	  
//########################################################################################################################################################################	  
  public boolean isElementVisible(WebElement we) {

		     if(we.isDisplayed()) {
		    	 return true; 
		    }
		     else {
		         System.out.println("The target is null");
         return false;
     }
 } 

//########################################################################################################################################################################		 
public void scrollToElementByJS(AppiumDriver<WebElement> driver,WebElement element) {			
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
}
//########################################################################################################################################################################	

public static String readConfigfile (String Key) throws IOException {
	
	try {
		Properties prop = new Properties();
		FileInputStream ip= new FileInputStream("./src/test/resources/config.properties");
		prop.load(ip);
		Value = prop.getProperty(Key);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return Value;
}
}
