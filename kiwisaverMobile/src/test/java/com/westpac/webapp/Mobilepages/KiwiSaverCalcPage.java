package com.westpac.webapp.Mobilepages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;

public class KiwiSaverCalcPage extends AppiumPageObject {

	public KiwiSaverCalcPage(WebDriver driver) {
		super(driver);
	}

	// All WebElements from Kiwisaver Calculator page
	@FindBy(linkText="Click here to get started.")
    public WebElement lnkClickHere;
	
	@FindBy(xpath=".//label[text()='Current age']//following::input[1]")
    public WebElement txtCurrentAge;
	
	@FindBy(xpath=".//label[text()='Employment status']//following::div[@class='control-well'][1]")
    public WebElement lstEmploymentStatus;
	
	public final By lstOptions = By.cssSelector("ul.option-list li span");
	
	@FindBy(xpath=".//label[contains(text(),'Salary')]//following::input[1]")
    public WebElement txtSalary;
	
	@FindBy(xpath=".//input[contains(@id,'radio-option')]//following::span/span")
    public List<WebElement> radioKiwiPercent; // value = 3, 4, 6 , 8 ,10
	public final By radioOptions = By.xpath(".//input[contains(@id,'radio-option')]");
	
	@FindBy(xpath=".//label[text()='Current KiwiSaver balance']//following::input[1]")
    public WebElement txtKiwiBalance;
	
	@FindBy(xpath=".//label[text()='Voluntary contributions']//following::input[1]")
    public WebElement txtContribution;
	
	@FindBy(xpath=".//label[text()='Voluntary contributions']//following::span[text()='Frequency'][1]")
    public WebElement lstFrequency;
	
    public List<WebElement> optionsFrequency;
    
    public List <WebElement> optionsEmploymentStatus;
	
	@FindBy(xpath=".//input[contains(@id,'radio-option')]//following::span/span")
    public List<WebElement> radioRiskProfile; // value = low, medium, high, growth
	
	@FindBy(xpath=".//label[contains(text(),'Savings goal')]//following::input[1]")
    public WebElement txtSavingGoal;
	
	@FindBy(xpath=".//button/span[contains(text(),'View your KiwiSaver retirement projections')]")
    public WebElement btnProjections;
	
	@FindBy(className="result-title ng-binding")
    public WebElement lblResultTitle;
	
	@FindBy(xpath=".//div[@class='results-heading']/span[2]")
    public WebElement lblResultCurrency;
	public final By lblCurrency = By.xpath(".//div[@class='results-heading']/span[2]");
	
	//Icon and message to each field
	@FindBy(xpath=".//label[text()='Current age']//following::i[1]")
    public WebElement lblAgeIcon;
	
	@FindBy(xpath=".//label[text()='Current age']//following::p[1]")
    public WebElement lblAgeMsg;
	
	@FindBy(xpath=".//label[text()='Employment status']//following::i[2]")
    public WebElement lblEmpStatIcon;
	
	@FindBy(xpath=".//label[text()='Employment status']//following::p[1]")
    public WebElement lblEmpStatMsg;
	
	@FindBy(xpath=".//label[text()='Current KiwiSaver balance']//following::i[1]")
    public WebElement lblKiwiSaverBalIcon;
	
	@FindBy(xpath=".//label[text()='Current KiwiSaver balance']//following::p[1]")
    public WebElement lblKiwiSaverBalMsg;
	
	@FindBy(xpath=".//label[text()='Voluntary contributions']//following::i[2]")
    public WebElement lblContriIcon;
	
	@FindBy(xpath=".//label[text()='Voluntary contributions']//following::p[1]")
    public WebElement lblContriMsg;
	
	@FindBy(xpath=".//input[contains(@id,'radio-option')]//following::i[1]")
    public WebElement lblRiskProfIcon;
	
	@FindBy(xpath=".//label[text()='Voluntary contributions']//following::p[1]")
    public WebElement lblRiskProfMsg;
	
	@FindBy(xpath=".//label[contains(text(),'Savings goal')]//following::i[1]")
    public WebElement lblGoalIcon;
	
	@FindBy(xpath=".//label[contains(text(),'Savings goal')]//following::p[1]")
    public WebElement lblGoalMsg;
	
//###################################################################################################################################
//Function Name:		clickHereToStart 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to click "Click here to get started"
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void clickHereToStart() {
		try {
			if(isElementPresent(lnkClickHere)) {
				clickOn(lnkClickHere);
				waitForTitleToAppear("KiwiSaver Retirement Calculator - Westpac NZ");
				String title= getDriver().getTitle().trim();
				assertEquals("KiwiSaver Retirement Calculator - Westpac NZ", title);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		switchToFrame 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to switch to frame to interact with the elements to calculate the retirement projections
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void switchToFrame() {
		try {
			getDriver().switchTo().frame(0);
			waitFor(ExpectedConditions.elementToBeClickable(txtCurrentAge));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		enterAge 
//Input Parameter:		age
//Output Parameter:		None 
//Description:			This function is used to type the age into the current age field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void enterAge(String age) {
		try {
			if(isElementPresent(txtCurrentAge)) {
				typeInto(txtCurrentAge, age);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		selectEmploymentStatus 
//Input Parameter:		employStatus
//Output Parameter:		None 
//Description:			This function is used to select the employment status
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void selectEmploymentStatus(String employStatus) {
		try {
			if(isElementPresent(lstEmploymentStatus)) {
				clickOn(lstEmploymentStatus);
				waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(lstOptions));
				optionsEmploymentStatus = driver.findElements(lstOptions);
				for(WebElement optionEmployStatus : optionsEmploymentStatus) {
					String text = optionEmployStatus.getText();
					if(employStatus.equalsIgnoreCase(text)) {
						clickOn(optionEmployStatus);
						break;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		enterSalary 
//Input Parameter:		salary
//Output Parameter:		None 
//Description:			This function is used to type the salary p/a into the Salary or wages per year (before tax) field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void enterSalary(String salary) {
		try {
			if(isElementPresent(txtSalary)) {
				typeInto(txtSalary, salary);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//###################################################################################################################################
//Function Name:		selectKiwiSaverPercent 
//Input Parameter:		kiwiSaverPercent
//Output Parameter:		None 
//Description:			This function is used to select the kiwi saver percentage
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void selectKiwiSaverPercent(String kiwiSaverPercent) {
		try {
			if(isElementVisible(radioOptions)) {
				for(WebElement kiwiSaver: radioKiwiPercent) {
					String text = kiwiSaver.getText();
					if(kiwiSaverPercent.equalsIgnoreCase(text)) {
						clickOn(kiwiSaver);
						break;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

//###################################################################################################################################
//Function Name:		enterKiwiSaverBalance 
//Input Parameter:		balance
//Output Parameter:		None 
//Description:			This function is used to enter balance in current kiwisaver balance field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void enterKiwiSaverBalance(String balance) {
		try {
			if(isElementPresent(txtKiwiBalance)) {
				typeInto(txtKiwiBalance, balance);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
//###################################################################################################################################
//Function Name:		enterContribution 
//Input Parameter:		contribution
//Output Parameter:		None 
//Description:			This function is used to enter amount in voluntary contributions field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void enterContribution(String contribution) {
		try {
			if(isElementPresent(txtContribution)) {
				typeInto(txtContribution, contribution);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//###################################################################################################################################
//Function Name:		selectFrequency 
//Input Parameter:		frequency
//Output Parameter:		None 
//Description:			This function is used to select the frequency for voluntary contribution
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void selectFrequency(String frequency) {
		try {
			if(isElementPresent(lstFrequency)) {
				clickOn(lstFrequency);
				waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(lstOptions));
				optionsFrequency = driver.findElements(lstOptions);
				for(WebElement optionFrequency : optionsFrequency) {
					String text = optionFrequency.getText();
					if(frequency.equalsIgnoreCase(text)) {
						clickOn(optionFrequency);
						break;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
//###################################################################################################################################
//Function Name:		selectRiskProfile 
//Input Parameter:		riskProfile
//Output Parameter:		None 
//Description:			This function is used to select the risk profile radio option
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void selectRiskProfile(String riskProfile) {
		try {
			if(isElementVisible(radioOptions)) {
				for(WebElement RiskProfile: radioRiskProfile) {
					String text = RiskProfile.getText();					
					if(riskProfile.equalsIgnoreCase(text)) {
						clickOn(RiskProfile);
						break;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		enterContribution 
//Input Parameter:		contribution
//Output Parameter:		None 
//Description:			This function is used to enter amount in voluntary contributions field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void enterSavingGoal(String savingGoal) {
		try {
			if(isElementPresent(txtSavingGoal)) {
				typeInto(txtSavingGoal, savingGoal);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		viewRetirementProjections 
//Input Parameter:		None
//Output Parameter:		None 
//Description:			This function is used to view the retirement projections
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void viewRetirementProjections() {
		try {
			if(isElementPresent(btnProjections)) {
				clickOn(btnProjections);
				waitFor(ExpectedConditions.visibilityOfElementLocated(lblCurrency));
				boolean blnFlag = isElementVisible(lblResultCurrency);
				assertTrue("Estimated Projection amoount is displayed" ,blnFlag);
				String currency = lblResultCurrency.getText().split("\n")[1].replace(",", "").trim();
				assertTrue("Estimated Projection amount  (" + currency + ") should be greater than $0", Integer.parseInt(currency) > 0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//###################################################################################################################################
//Function Name:		clickIcon 
//Input Parameter:		field
//Output Parameter:		None 
//Description:			This function is used to click the icon next to each field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void clickIcon(String field) {
		try {
			switch(field) {
				case "Current Age":
					waitFor(ExpectedConditions.elementToBeClickable(lblAgeIcon));
					clickOn(lblAgeIcon);
					break;
				case "Employment status":
					waitFor(ExpectedConditions.elementToBeClickable(lblEmpStatIcon));
					clickOn(lblEmpStatIcon);
					break;
				case "Current KiwiSaver balance":
					waitFor(ExpectedConditions.elementToBeClickable(lblKiwiSaverBalIcon));
					clickOn(lblKiwiSaverBalIcon);
					break;
				case "Voluntary contributions":
					waitFor(ExpectedConditions.elementToBeClickable(lblContriIcon));
					clickOn(lblContriIcon);
					break;
				case "Risk profile":
					waitFor(ExpectedConditions.elementToBeClickable(lblRiskProfIcon));
					clickOn(lblRiskProfIcon);
					break;
				case "Savings goal at retirement":
					waitFor(ExpectedConditions.elementToBeClickable(lblGoalIcon));
					clickOn(lblGoalIcon);
					break;
				default:
					break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

//###################################################################################################################################
//Function Name:		validateMessage 
//Input Parameter:		field
//Output Parameter:		None 
//Description:			This function is used to validate the message after clicking icon next to each field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void validateMessage(WebElement ele , String Key) {
		try {
			waitFor(ExpectedConditions.visibilityOf(ele));
			if(isElementPresent(ele)) {
				String text = ele.getText();
				System.out.println(readConfigfile(Key));
				System.out.println(text);
				assertEquals(readConfigfile(Key), text);				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
//###################################################################################################################################
//Function Name:		validateFieldMessage 
//Input Parameter:		field
//Output Parameter:		None 
//Description:			This function is used to validate the message after clicking icon next to each field
//Tester:				Nagajothi Kaliappan
//###################################################################################################################################
	public void validateFieldMessage(String field) {
		try {
			switch(field) {
				case "Current Age":
					validateMessage(lblAgeMsg, "CurrentAge");
					break;
				case "Employment status":
					validateMessage(lblEmpStatMsg, "Employmentstatus");
					break;
				case "Current KiwiSaver balance":
					validateMessage(lblKiwiSaverBalMsg, "CurrentKiwiSaverbalance");
					break;
				case "Voluntary contributions":
					validateMessage(lblContriMsg, "Voluntarycontributions");
					break;
				case "Risk profile":
					validateMessage(lblRiskProfMsg, "Riskprofile");
					break;
				case "Savings goal at retirement":
					validateMessage(lblGoalMsg, "Savingsgoalatretirement");
					break;
				default:
					break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
}
