package com.automationbymounika.components;

import com.automationbymounika.browser.DriverManager;
import com.automationbymounika.properties.PropertiesLoader;
import com.automationbymounika.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestActions {
    public WebDriver driver;
    public DriverManager driverManager;
    public BaseActions pageActions;
    @BeforeSuite
    public void setUpConfigurations() throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }
    @BeforeMethod
    public void setUpBrowser() throws Exception {
        driverManager.loadDriver(); //loading the driver or opening the driver
        driver = driverManager.getDriver(); //getting the driver instance from driverManager and set it to BaseActions class
        pageActions = new BaseActions(driver);
        pageActions.launchUrl(PropertiesLoader.appUrl);
    }


//    @AfterMethod
//    public void tearDownBrowser() {
//        driverManager.closeBrowser();
//    }
//    @AfterSuite
//    public void tearDownObjects() throws Exception{
//        PropertiesLoader.configProperties = null; //so that it will destroyed.
//    }
}
