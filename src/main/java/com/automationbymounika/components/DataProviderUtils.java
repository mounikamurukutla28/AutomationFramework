package com.automationbymounika.components;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

@DataProvider(name="jsonDataProvider") //naming the dataprovider as jsonDataProvider
    public static Object[][] getJsonTestData(Method method){ //method is a parameter, it is a runtime class which gives the method
    //that is running at the runtime.
        return null;
    }

}
