package com.cydeo.tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task004 {

    public static void main(String[] args) {

    //    TC #4: Practice Cydeo – Class locator practice
    //    1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    //    2- Go to: https://practice.cydeo.com/inputs
        driver.navigate().to("https://practice.cydeo.com/inputs");

    //    3- Click to “Home” link
    //    PS: Locate “Home” link using “className” locator
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

    //    4- Verify title is as expected: Expected: Practice
        String expectedHomePgeTitle = "Practice";
        String actualHomePgeTitle = driver.getTitle();

        if(actualHomePgeTitle.equals(expectedHomePgeTitle)){
            System.out.println("Verification Passed!");
        }else {
            System.out.println("Verification Not Passed!");
        }

        driver.close();



    }
}
