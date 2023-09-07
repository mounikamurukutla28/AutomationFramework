package com.automationbymounika;

public class ConfigurationException extends RuntimeException{
    String exceptionMessage;
    String cause;

    public ConfigurationException(String message){

        this.cause = message;
    }

    public String toString() {
        exceptionMessage = "Error in Configuration file. Pls check the file for anu errors/invalid Input";
        exceptionMessage += "Exception occured due to: " + this.cause;
        return exceptionMessage;
    }

}
