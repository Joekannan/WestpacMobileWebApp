package com.westpac.webapp.Mobilesteps;

import com.westpac.webapp.Mobilepages.HomePage;
import com.westpac.webapp.Mobilepages.KiwiSaverCalcPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class KiwiSaverSteps extends ScenarioSteps{

	HomePage homePage;
	KiwiSaverCalcPage kiwiSaverCalcPage;
	
	@Step
	public void navigateToKiwiSaverRetirementCalculator() {
		try {
			homePage.launchApplication();
			homePage.clickPersonal();
			homePage.clickKiwiSaver();
			homePage.clickKiwiSaverCalc();
			kiwiSaverCalcPage.clickHereToStart();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void calculateRetirementProjection(String age, String employStatus, String balance, String contribution, String frequency ,String riskProfile, String savingGoal ) {
		try {
			kiwiSaverCalcPage.switchToFrame();
			kiwiSaverCalcPage.enterAge(age);
			kiwiSaverCalcPage.selectEmploymentStatus(employStatus);
			kiwiSaverCalcPage.enterKiwiSaverBalance(balance);
			kiwiSaverCalcPage.enterContribution(contribution);
			kiwiSaverCalcPage.selectFrequency(frequency);
			kiwiSaverCalcPage.selectRiskProfile(riskProfile);
			kiwiSaverCalcPage.enterSavingGoal(savingGoal);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void calculateRetirementProjectionForEmployed(String age, String employStatus, String salary, String kiwiSaverPercent, String riskProfile) {
		try {
			kiwiSaverCalcPage.switchToFrame();
			kiwiSaverCalcPage.enterAge(age);
			kiwiSaverCalcPage.selectEmploymentStatus(employStatus);
			kiwiSaverCalcPage.enterSalary(salary);
			kiwiSaverCalcPage.selectKiwiSaverPercent(kiwiSaverPercent);
			kiwiSaverCalcPage.selectRiskProfile(riskProfile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Step
	public void viewRetirementProjection() {
		try {
			kiwiSaverCalcPage.viewRetirementProjections();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void clickInformationIcon(String field) {
		try {
			kiwiSaverCalcPage.switchToFrame();
			kiwiSaverCalcPage.clickIcon(field);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void validateInformationMsg(String field) {
		try {
			kiwiSaverCalcPage.validateFieldMessage(field);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
