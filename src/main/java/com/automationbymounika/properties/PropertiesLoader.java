package com.automationbymounika.properties;

import com.automationbymounika.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {
    static Properties configProperties;

    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWait;
    public static Integer explicitWait;
    public static Integer pageLoadWait;
    public static boolean remoterun;
    public static boolean deleteCookies;
    public static boolean headless;


    public static void initializeProperties() throws Exception {
        if (configProperties==null){
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//config.Properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser = configProperties.getProperty("RunOnBrowser");
        takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        ieDriverPath = configProperties.getProperty("IEDriverPath");
        edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
        maximizedMode = Boolean.valueOf(configProperties.getProperty("MaximizedMode"));
        implicitWait = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWait = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadWait = Integer.valueOf(configProperties.getProperty("PageLoadWait"));
        remoterun = Boolean.valueOf(configProperties.getProperty("RemoteRun"));
        deleteCookies = Boolean.valueOf(configProperties.getProperty("DeleteCookies"));
        headless = Boolean.valueOf(configProperties.getProperty("Headless"));


    }

    public static void main(String[] args) throws Exception{
        PropertiesLoader.initializeProperties();
        System.out.println(runOnBrowser);
        PropertiesValidator.validateConfigurations();

    }
}
