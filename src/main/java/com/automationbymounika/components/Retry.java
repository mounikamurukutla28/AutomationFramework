package com.automationbymounika.components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private static final int MAX_RETRY = 2;
    private int retryCount = 0;
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < MAX_RETRY) {
                retryCount++;
                result.setStatus(result.FAILURE);
                return true;
            } else {
                result.setStatus(result.FAILURE);
            }
        } else {
            result.setStatus(result.SUCCESS);
        }
        return false;
    }
}
