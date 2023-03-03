package com.sample.test.demo.pages;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialSecurityIncomePage {

	@FindBy(id="single")
	WebElement single;

	@FindBy(id="married")
	WebElement married;

	@FindBy(xpath="//input[@id='social-security-override']")
	WebElement socialSecurityOverride;

	public SocialSecurityIncomePage(WebDriver driver){
		PageFactory.initElements(driver, this);;
	}
	
	public SocialSecurityIncomePage clickSingle(){
		single.click();
		return this;
	}

	public SocialSecurityIncomePage clickMarried(){
		TestBase.jsClick(married);
		return this;
	}

	public boolean isMatitalStatusDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		return single.isDisplayed() && married.isDisplayed();
	}

	public boolean issocialSecurityOverrideDisplayed(){
		return socialSecurityOverride.isDisplayed();
	}

	public void entersocialSecurityOverride(String amount){
		TestBase.enterText(amount, socialSecurityOverride);
	}
}
