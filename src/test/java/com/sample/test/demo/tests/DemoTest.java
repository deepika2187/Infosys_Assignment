package com.sample.test.demo.tests;

import java.util.Hashtable;

import com.sample.test.demo.pages.ResultsPage;
import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.pages.SocialSecurityIncomePage;
import com.sample.test.demo.pages.HomePage;

import static org.testng.Assert.*;

public class DemoTest extends TestBase {
	
	HomePage home = null;
	SocialSecurityIncomePage ssip = null;
	
    @Test(dataProvider = "data", description = "User should be able to submit form with all required fields filled in", priority = 1)
    public void submitFormWithAllFields(Hashtable<String, String> data) throws InterruptedException {
        home = new HomePage(driver);
        home.enterCurrentAge(data.get("Current Age"))
                .enterRetirementAge(data.get("Retirement Age"))
                .enterCurrentIncome(data.get("Current annual income"))
                .enterSpouseIncome(data.get("Spouse annual income"))
                .enterCurrentTotalSavings(data.get("Current retirement savings"))
                .enterCurrentAnnualSavings(data.get("Current retirement contribution"))
                .enterSavingsIncreaseRate(data.get("Annual retirement contribution increase"))
                .clickCalculate();
        ResultsPage result = new ResultsPage(driver);
        assertTrue(result.isResultsDisplayed());
    }

    @Test(dataProvider = "data", description = "Additional Social Security fields should display/hide based on Social Security benefits toggle", priority = 2)
    public void displayHideOnSocialSecurityToggle(Hashtable<String, String> data) throws InterruptedException {
        home = new HomePage(driver);
        assertTrue(home.isNoChecked());
        home.clickYes();
        SocialSecurityIncomePage ssi = new SocialSecurityIncomePage(driver);
        assertTrue(ssi.isMatitalStatusDisplayed());
        assertTrue(ssi.issocialSecurityOverrideDisplayed());
    }

    @Test(dataProvider = "data", description = "User should be able to submit form with all fields filled in", priority = 3)
    public void submitAllFields(Hashtable<String, String> data) throws InterruptedException {
        home = new HomePage(driver);
        home.enterCurrentAge(data.get("Current Age"))
                .enterRetirementAge(data.get("Retirement Age"))
                .enterCurrentIncome(data.get("Current annual income"))
                .enterSpouseIncome(data.get("Spouse annual income"))
                .enterCurrentTotalSavings(data.get("Current retirement savings"))
                .enterCurrentAnnualSavings(data.get("Current retirement contribution"))
                .enterSavingsIncreaseRate(data.get("Annual retirement contribution increase"))
                .clickYes();

        SocialSecurityIncomePage ssi = new SocialSecurityIncomePage(driver);
        ssi.clickMarried().entersocialSecurityOverride(data.get("Social Security Override"));

        home = new HomePage(driver);
        home.clickCalculate();

        ResultsPage result = new ResultsPage(driver);
        assertTrue(result.isResultsDisplayed());

    }


    
}
