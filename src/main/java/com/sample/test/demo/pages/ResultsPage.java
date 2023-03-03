package com.sample.test.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    @FindBy(xpath="//h3[text()='Results']")
    WebElement results;

    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean isResultsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        return results.isDisplayed();
    }
}
