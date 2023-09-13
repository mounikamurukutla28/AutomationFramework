package com.automationbymounika.components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebLibrary {
    //This class contains all the reusable methods that can be used to perform some actions.
    WebDriver driver;
    WebLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIt(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
        } catch(Exception e) {
        }
    }
    public void typeInto(String elementRef, String text) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(text);
        } catch(Exception e) {
        }
    }
    public void getTextFromElement(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.getText();
        } catch(Exception e) {
        }
    }
    public String getAttributeForElement(String elementRef, String attributeType){
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.getAttribute(attributeType);
        } catch(Exception e) {
        }
        return null;
    }
    public void selectValueFromDropdown(String elementRef, String findBy, String valueToSelect) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Select dropdownSelect = new Select(elementBy);
            if (findBy.equalsIgnoreCase("visible Text")){
                dropdownSelect.selectByVisibleText(valueToSelect);
            } else if (findBy.equalsIgnoreCase("Value")){
                dropdownSelect.selectByValue(valueToSelect);
            } else if (findBy.equalsIgnoreCase("index")) {
                int index = Integer.parseInt(valueToSelect);
                dropdownSelect.selectByIndex(index);
            }
        }catch(Exception e) {
        }

    }
    public void switchToSecondWindow() {
        try {
            driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        } catch (Exception e) {
        }
    }
    public void switchToLastWindow() {
        try {
            List<String> windows = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(windows.size() - 1));
        } catch(Exception e){
        }
    }
    public void hitEnter(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.ENTER);
        } catch(Exception e) {
        }
    }
    public void hitTab(String elementRef){
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.TAB);
        } catch (Exception e) {

        }

    }
}
