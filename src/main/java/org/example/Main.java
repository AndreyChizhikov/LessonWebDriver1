package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://testng.org/");
        ((JavascriptExecutor) driver).executeScript("alert('hello world');");
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        driver.quit();
    }
}