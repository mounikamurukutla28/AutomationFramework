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
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public DriverManager driverManager;
    public BaseActions pageActions;
    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurations() throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }
    @BeforeMethod
    public void setUpBrowser() throws Exception {
        driverManager.loadDriver(); //loading the driver or opening the driver
//        driver = driverManager.getDriver(); //getting the driver instance from driverManager and set it to BaseActions class
        driver.set(driverManager.getDriver()); // this is how we have to set driver when making the driver as threadlocal
        // and when ever you have to call driver instead of driver we have to use driver.get() to call the driver
        pageActions = new BaseActions(driver.get());
        pageActions.launchUrl(PropertiesLoader.appUrl);
    }


    @AfterMethod(alwaysRun=true)
    public void tearDownBrowser() {
        driverManager.closeBrowser();
    }
//    @AfterSuite
//    public void tearDownObjects() throws Exception{
//        PropertiesLoader.configProperties = null; //so that it will destroyed.
//    }
}
