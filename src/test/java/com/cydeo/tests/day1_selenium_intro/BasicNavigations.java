package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // 1. Set up the browser driver
        WebDriverManager.chromedriver().setup();

        // 2. Create an instance eof the Selenium Webdriver
        //This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the browser size
        driver.manage().window().maximize(); // maximize method works with both MAC and Windows
        //driver.manage().window().fullscreen(); --> fullscreen method works MAC only


        // 3. Go-to "https://www.tesla.com"
        driver.get("https://www.tesla.com"); // this line will not work without https but will work without www. but it's not recommended

        // get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to():
        driver.navigate().to("https://www.google.com");

        // get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle()); --> driver.getTitle() = Google
        // re-assigned existing String
        currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using selenium
        // re-assigned existing String
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // this will close the currently opened window
       driver.close();

        // this will close the all the opened window
       driver.quit();

    }
}
