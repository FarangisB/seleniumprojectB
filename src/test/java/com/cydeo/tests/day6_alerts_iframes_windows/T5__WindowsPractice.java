package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5__WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set ups
        //3. Go to : https://practice.cydeo.com/windows
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void multiple_window_test(){

        // Storing the main page's window handle as string is a good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title before click: "+actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));

        clickHereLink.click();
        actualTitle = driver.getTitle();

        System.out.println("Title after click: "+actualTitle);

        //6. Switch to new Window.
        //Set<String> allWindowHandles = driver.getWindowHandles(); -> we can also create a Set of Windows and put it inside the for loop
        // Window handle 1 - main Window
        // Window handle 2 - 2nd Window

        for (String each: driver.getWindowHandles()){

            driver.switchTo().window(each);

            System.out.println("Current title while switching windows: "+driver.getTitle());
        }

        //7. Assert: Title is “New Window”

        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        actualTitle = driver.getTitle();

        System.out.println("Title after switching the window: "+actualTitle);

    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}





