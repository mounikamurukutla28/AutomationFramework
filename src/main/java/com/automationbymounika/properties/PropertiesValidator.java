package com.automationbymounika.properties;

import com.automationbymounika.ConfigurationException;

import static com.automationbymounika.properties.PropertiesLoader.*;

public class PropertiesValidator {
    public static void validateConfigurations() throws Exception{
        if (runOnBrowser.equalsIgnoreCase("chrome")){
            if (chromeDriverPath.isEmpty()){
                throw new ConfigurationException("ChromeDriverPath Empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("firefox")){
            if (firefoxDriverPath.isEmpty()){
                throw new ConfigurationException("FirefoxDriver Empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("edge")){
            if (edgeDriverPath.isEmpty()){
                throw new ConfigurationException("EdgeDriverPath Empty");
            }
        }
    }
}
