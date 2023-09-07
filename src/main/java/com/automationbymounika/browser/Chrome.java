package com.automationbymounika.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//we can find all the chrome capabilities in chromedriver.chromium.org
public class Chrome extends Browser{
    ChromeOptions chromeOptions;
    @Override
    public void setPreferences() {
        chromeOptions = new ChromeOptions();
        if (isHeadless()) { //if you want run something without opening a browser, we use headless mode. To enable that we have to set headless mode to true.
            chromeOptions.setHeadless(true);
        }
        if (isMaximized()){
            chromeOptions.addArguments("start-maximized");
        }
        Map<String, Object> prefs =  new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false); //after entering password, you get a popup to save password or never. to enable or disable we use this preference.
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);
        prefs.put("excludeSwitches", Collections.singletonList("enable-automation")); //used to disable popups, because it gets enabled by default in chrome.
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
    }


    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", path);
        if (isRemote()){ //this is used to run using selenium grid. if asked in interview, we have to say that using remoteWebDriver we can perform selenum grid operations.
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if (isDeleteCookies()){
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
