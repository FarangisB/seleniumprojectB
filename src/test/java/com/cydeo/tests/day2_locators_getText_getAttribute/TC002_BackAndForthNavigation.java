package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002_BackAndForthNavigation {

    public static void main(String[] args) {

        // 1. Open the chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com");

        // 3. Click to A/B Testing from top of the list
        // driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));

        abTestLink.click();

        // 4. Verify title is:
        // Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED! = "+actualTitle);
        }else{
            System.out.println("Title verification FAILED! = "+actualTitle);
        }

        // 5. Go back to home page by using the .back();
        driver.navigate().back();

        // 6. Verify title equals:
        //  Expected: Practice
        expectedTitle="Practice";
        actualTitle= driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED! = "+actualTitle);
        }else{
            System.out.println("Title verification FAILED! = "+actualTitle);
        }


    }
}
/**
 * TC #3: Back and forth navigation
 * 1- Open a chrome browser
 * 2- Go to: https://practice.cydeo.com/
 * 3- Click to A/B Testing from top of the list.
 * 4- Verify title is:
 *   Expected: No A/B Test
 * 5- Go back to home page by using the .back();
 * 6- Verify title equals:
 *   Expected: Practice
 */
