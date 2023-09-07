package com.automationbymounika.browser;

import com.automationbymounika.properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    //The driver manager is responsible for getting the driver, loading the driver, closing the driver, quitting the driver
    public static WebDriver driver;
    public WebDriver getDriver() {

        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void loadDriver(){
        Browser browser = null;
        String path = "";
        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")){
            browser = new Chrome(); //runtime polymorphism
            path = PropertiesLoader.chromeDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Firefox")){
            browser = new Firefox();
            path = PropertiesLoader.firefoxDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge")) {
            browser = new Edge();
            path = PropertiesLoader.edgeDriverPath;
        }
        browser.setHeadless(PropertiesLoader.headless);
        browser.setMaximized(PropertiesLoader.maximizedMode);
        browser.setRemote(PropertiesLoader.remoterun);
        browser.setPageLoadTimeout(PropertiesLoader.pageLoadWait);
        browser.setPreferences(); //set the preferences
        WebDriver driver = browser.loadBrowser(path); //loading the browser
        setDriver(driver); //setting the driver so that the global driver gets instantiated
    }
    public void closeBrowser() {
        driver.close();
    }
    public void closeAllBrowsers() {
        driver.quit();
    }
}
