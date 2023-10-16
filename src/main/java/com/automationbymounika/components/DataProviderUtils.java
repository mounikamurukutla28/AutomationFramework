package com.automationbymounika.components;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviderUtils {

    @DataProvider(name="jsonDataProvider") //naming the dataprovider as jsonDataProvider
    public static Object[][] getJsonTestData(Method method) throws IOException, ParseException { //method is a parameter, it is a runtime class which gives the method
        //that is running at the runtime.
        String testCaseName = method.getName();
        System.out.println("testcaseName is: " + testCaseName);
        DataProviderArgs args = method.getAnnotation(DataProviderArgs.class);
        String testCaseArguments = args.value();
        System.out.println("testCaseArguments are: " + testCaseArguments);
        String testDataName = testCaseArguments.split("=")[0];
        System.out.println("testDataName is: " + testDataName);
        String testFields = testCaseArguments.split("=")[1];
        System.out.println("testFields are: " + testFields);
        List<String> allTestFields = Arrays.asList(testFields.split(","));
        File testDataFile = new File(System.getProperty("user.dir") + "//src//test//resources//testData.json");
        FileReader fileReader = new FileReader(testDataFile);
        //create the instance of JSON Parser file, that is responsible for parsing file.
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(fileReader);
        System.out.println("super set is: " + obj); //superset
        JSONObject testCase = (JSONObject) obj;
        JSONArray testArray = (JSONArray) testCase.get(testDataName);
        List<List<String>> listOfList = new ArrayList<>();
        for (int i=0; i<testArray.size();i++){
            List<String> valueFromFields = new ArrayList<String>();
            System.out.println("value of fields are: " + valueFromFields);
            JSONObject subset = (JSONObject) testArray.get(i);
            System.out.println(subset);
            for (int j=0;j< allTestFields.size();j++){
                valueFromFields.add(subset.get(allTestFields.get(j)).toString());
            }
            System.out.print(valueFromFields);
            listOfList.add(valueFromFields);
            System.out.println(listOfList);
        }
        return parseListToObjectArray(listOfList);
    }
    public static Object[][] parseListToObjectArray(List<List<String>> testData){
        Object[][] TwoDArray = new Object[testData.size()][testData.get(0).size()];
        for (int i=0; i< testData.size(); i++) {
            List<String> subset = testData.get(i);
            for (int j=0; j< subset.size();j++){
                TwoDArray[i][j] = subset.get(j);
            }
        }
        return TwoDArray;
    }

}
