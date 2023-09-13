package com.automationbymounika.components;

import com.automationbymounika.properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementFindBy {
    //This class is used to find the elements
    WebDriver driver;
    WebDriverWait wait;
    public ElementFindBy(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, PropertiesLoader.explicitWait);
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
        //Wait is an interface and webDriverWait is a class which implements wait interface.
        //similar to WebDriver driver = new ChromeDriver();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        return waitUntilElementVisible(by);
    }
    public List<WebElement> findElementsBy(String element) throws Exception {
        By by = findBy(element);
        return waitUntilAllElementsVisible(by);

    }
    public WebElement waitUntilElementVisible(By by) throws Exception{
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitUntilElementFound(By by) throws Exception { //used to check if element is present in the dom or not by using presenceOfElement.
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public List<WebElement> waitUntilAllElementsVisible(By by) throws Exception {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public WebElement waitUntilElementClickable(By by) throws Exception {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public boolean waitUntilElementDisappear(By by) throws Exception {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
