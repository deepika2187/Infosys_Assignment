package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.sample.test.demo.utils.ExcelUtils;

public class TestBase {

    private Configuration config;
    protected static WebDriver driver;
//    protected String url;

    @BeforeMethod(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
//        url = config.getUrl();
        initializelDriver();
        navigateToSite();
    }

    private void navigateToSite() {
    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--headless");
//    	options.addArguments("--no-sandbox");
//    	options.addArguments("--disable-dev-shm-usage");
    	driver = new ChromeDriver(options);
        driver.get(config.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
        }
        else {
            fail("Unsupported browser " + config.getBrowser());
        }

    }

    public static void enterText(String text, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);
    }

    public static void jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    
    @DataProvider(name = "data")
    public Iterator<Object[]> getData(Method M) throws Exception{
    	List<Hashtable<String, String>> dataList = ExcelUtils.readFile(System.getProperty("user.dir")+"/src/test/resources/testdata/testData.xlsx", "data", M.getName());
    	List<Object[]> testArray = new ArrayList<Object[]>();
    	Iterator<Hashtable<String, String>> dataIterator = dataList.iterator(); 
    	while(dataIterator.hasNext()){
    		Hashtable<String, String> testdataset = dataIterator.next();
    		if(!(testdataset.get("RunTest").equalsIgnoreCase("TRUE"))){
    			dataIterator.remove();
    		}else{
    			Object[] dataObj = {testdataset};
    			testArray.add(dataObj);
    		}
    	}
    	return testArray.iterator();
    }


}
