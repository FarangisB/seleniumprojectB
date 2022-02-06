package com.cydeo.tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task003 {

    public static void main(String[] args) throws InterruptedException {

    //    TC #3: Back and forth navigation
    //    1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    //    2- Go to: https://google.com
        driver.get("https://google.com");

    //    3- Click to Gmail from top right.
        WebElement gmailBtn = driver.findElement(By.className("gb_d"));
        gmailBtn.click();

    //    4- Verify title contains: Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }
        Thread.sleep(2000);

    //    5- Go back to Google by using the .back();
        driver.navigate().back();

    //    6- Verify title equals: Expected: Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

        Thread.sleep(1000);
        driver.close();


    }
}

