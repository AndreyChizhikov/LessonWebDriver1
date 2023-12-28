import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {
    @Test
    public void successfulSearch() {
        final String searchQuery = "Кактус";
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            webDriver.get("https://prozorro.gov.ua");
            WebElement webElement = webDriver
                    .findElement(By.xpath("//input[@class='search-text__input']"));

            webElement.clear();
            webElement.sendKeys(searchQuery);
            webElement.sendKeys(Keys.ENTER);

            new WebDriverWait(webDriver, Duration.ofSeconds(5)).
                    until(ExpectedConditions.presenceOfElementLocated(By
                            .xpath("(//div[contains(@class,'search-result-card__col')])[1]//a[@class='search-result-card__title']"))).click();

            Assert.assertTrue(webDriver.findElement(By
                            .xpath("//div[contains(@class,'tender--head--title') and contains(text(),'"+searchQuery+"')]"))
                    .isDisplayed(), "Element with text"+searchQuery+"is displayed");
        } finally {
            webDriver.quit();
        }
    }
}
