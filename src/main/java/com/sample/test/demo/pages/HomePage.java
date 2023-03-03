package com.sample.test.demo.pages;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	@FindBy(xpath="//input[@id='current-age']")
	WebElement currentAge;
	
	@FindBy(xpath="//input[@id='retirement-age']")
	WebElement retirementAge;
	
	@FindBy(xpath="//input[@id='current-income']")
	WebElement currentIncome;

	@FindBy(xpath="//input[@id='spouse-income']")
	WebElement spouseIncome;

	@FindBy(xpath="//input[@id='current-total-savings']")
	WebElement currentTotalSavings;

	@FindBy(xpath="//input[@id='current-annual-savings']")
	WebElement currentAnnualSavings;

	@FindBy(xpath="//input[@id='savings-increase-rate']")
	WebElement savingsIncreaseRate;

	@FindBy(xpath="//*[@id='yes-social-benefits']")
	WebElement yes;

	@FindBy(id="no-social-benefits")
	WebElement no;

	@FindBy(xpath="//button[text()='Calculate']")
	WebElement calculate;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	public HomePage enterCurrentAge(String age){
		currentAge.sendKeys(age);
        return this;
	}
	
	public HomePage enterRetirementAge(String age){
		retirementAge.sendKeys(age);
        return this;
	}
	
	public HomePage enterCurrentIncome(String income){
		TestBase.enterText(income, currentIncome);
		return this;
	}

	public HomePage enterSpouseIncome(String income){
		TestBase.enterText(income, spouseIncome);
		return this;
	}

	public HomePage enterCurrentTotalSavings(String savings){
		TestBase.enterText(savings, currentTotalSavings);
		return this;
	}

	public HomePage enterCurrentAnnualSavings(String savings){
		currentAnnualSavings.sendKeys(savings);
		return this;
	}

	public HomePage enterSavingsIncreaseRate(String rate){
		savingsIncreaseRate.sendKeys(rate);
		return this;
	}

	public HomePage clickYes(){
		TestBase.jsClick(yes);
		return this;
	}

	public HomePage clickNo(){
		no.click();
		return this;
	}

	public HomePage clickCalculate(){
		calculate.click();
		return this;
	}

	public boolean isNoChecked(){
		return no.isSelected();
	}

	public boolean isYesChecked(){
		return yes.isSelected();
	}

}
