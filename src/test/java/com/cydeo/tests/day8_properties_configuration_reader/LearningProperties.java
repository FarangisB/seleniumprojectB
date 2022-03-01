package com.cydeo.tests.day8_properties_configuration_reader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){

        System.out.println("System.getProperty(\"os.name\") = "+System.getProperty("os.name"));

        System.out.println("System.getProperty(\"user.name\") = "+System.getProperty("user.name"));

        System.out.println("System.getProperties() = " + System.getProperty("user.dir"));

        System.out.println("System.getProperties() = " + System.getProperty("java.vendor.url"));

        System.out.println("System.getProperties() = " + System.getProperty("java.home"));

        System.out.println("System.getProperties() = " + System.getProperty("os.version"));

        System.out.println("System.getProperties() = " + System.getProperty("user.home"));

        System.out.println("System.getProperties() = " + System.getProperty("file.separator"));

        //System.getProperty("os.name") = Windows 10
        //System.getProperty("user.name") = bayza

    }
}
