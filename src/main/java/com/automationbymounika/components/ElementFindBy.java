package com.automationbymounika.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ElementFindBy {
    //This class is used to find the elements
    WebDriver driver;
    public ElementFindBy(WebDriver driver) {
        this.driver = driver;
    }
    public By findBy(String element) throws Exception {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0]; //this will get us the type of element
        String findByValue = elementValue.split(":")[1]; //this will get us the value of the element.
        if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("name")) {
            by = By.name(findByValue);
        } else if (findBy.equalsIgnoreCase("id")){
            by = By.id(findByValue);
        } else if (findBy.equalsIgnoreCase("class")) {
            by = By.className(findByValue);
        } else if (findBy.equalsIgnoreCase("css")){
            by = By.cssSelector(findByValue);
        } else if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("linktext")){
            by = By.linkText(findByValue);
        } else if (findBy.equalsIgnoreCase("partialLinkText")) {
            by = By.linkText(findByValue);
        } else {
            throw new Exception("Invalid locator Type/Value in [" + element + "].Please check the value in OR.Properties file.");
        }
        return by;
    }
    public WebElement findElementBy(String element) throws Exception {
        By by = findBy(element);
        return driver.findElement(by);
    }

}
