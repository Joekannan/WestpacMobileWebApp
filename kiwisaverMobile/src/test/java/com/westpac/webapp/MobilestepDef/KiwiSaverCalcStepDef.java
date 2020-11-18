package com.westpac.webapp.MobilestepDef;

import java.util.List;

import com.westpac.webapp.Mobilesteps.KiwiSaverSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class KiwiSaverCalcStepDef {
	
	@Steps
	KiwiSaverSteps kiwiSaverSteps;
	
	@Given("User is on KiwiSaver Calculator Page")
	public void user_is_on_KiwiSaver_Calculator_Page() {
		kiwiSaverSteps.navigateToKiwiSaverRetirementCalculator();
	}

	@When("User enters age {string} employment status {string} salary {string} kiwiSaverPercent {string} risk profile {string}")
	public void user_enters_age_employment_status_salary_kiwiSaverPercent_risk_profile(String age, String employStatus, String salary, String kiwiSaverPercent, String riskProfile) {
		kiwiSaverSteps.calculateRetirementProjectionForEmployed(age, employStatus, salary, kiwiSaverPercent, riskProfile);
	}

	@Then("Projected Balance at retirement should be displayed")
	public void projected_Balance_at_retirement_should_be_displayed() {
		kiwiSaverSteps.viewRetirementProjection();
	}

	@When("User clicks Information icon next to {string} field")
	public void user_clicks_Information_icon_next_to_field(String field) {
		kiwiSaverSteps.clickInformationIcon(field);
	}

	@Then("The message should be displayed for the user to enter the correct information in the {string}")
	public void the_message_should_be_displayed_for_user_to_enter_the_correct_information(String field) {
		kiwiSaverSteps.validateInformationMsg(field);
	}
	
	@When("User enters the below information")
	public void user_enters_the_below_information(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		kiwiSaverSteps.calculateRetirementProjection(list.get(0).get(1).toString(), list.get(1).get(1).toString(), list.get(2).get(1).toString(), list.get(3).get(1).toString(), list.get(4).get(1).toString(), list.get(5).get(1).toString(), list.get(6).get(1).toString());
		
	}
}
