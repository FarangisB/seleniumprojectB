package com.cydeo.tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task002 {

    public static void main(String[] args) {

    // TC #2: Zero Bank header verification
    // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

    // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

    // 3. Verify header text
    // Expected: “Log in to ZeroBank”
    WebElement header = driver.findElement(By.tagName("h3"));
    String expectedHeader = "Log in to ZeroBank";
    String actualHeader = header.getText();

    if (expectedHeader.equals(actualHeader)){
        System.out.println("Test Passed!");
    }else{
        System.out.println("Test Not Passed!");
    }

    String wrongHeader= "log in to zerobank";

    if(actualHeader.equals(wrongHeader)){
        System.out.println("Test Passed!");
    }else{
        System.out.println("Test Not Passed!");
    }


    driver.close();






    }
}
/**
 * TC #2: Zero Bank header verification
 * 1. Open Chrome browser
 * 2. Go to http://zero.webappsecurity.com/login.html
 * 3. Verify header text
 * Expected: “Log in to ZeroBank”
 */
