package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElementByID {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://yahoo.com");

        Thread.sleep(1000);

        WebElement inputBox = driver.findElement(By.id("ybar-sbq"));
        Thread.sleep(1000);

        inputBox.sendKeys("Hello");
        Thread.sleep(1000);

        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        Thread.sleep(1000);

        searchBtn.click();
        Thread.sleep(1000);

        System.out.println(" pageTitle = "+driver.getTitle());
        Thread.sleep(1000);

        driver.quit();




    }
}
