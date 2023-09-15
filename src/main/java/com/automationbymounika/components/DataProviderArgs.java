package com.automationbymounika.components;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //to make the below annotation available at runtime we are writing like this.
public @interface DataProviderArgs { //dataproviderArgs is the annotation same like @Test
    //the purpose of this class is to provides the values
    String value();
}
