package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        // TC #1: Yahoo Title Verification
        // Do set up for browser driver
        WebDriverManager.chromedriver().setup();

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Make our page fullscreen
        driver.manage().window().maximize();

        // 2. Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        // 3. Verify title:
        // Expected:Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title met the requirements: = " + actualTitle);
        }else{
            System.out.println("Actual Title doesn't met the requirements: "+actualTitle);
        }


    }
}
