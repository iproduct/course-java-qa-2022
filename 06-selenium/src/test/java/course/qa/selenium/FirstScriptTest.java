package course.qa.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FirstScriptTest {
    public WebDriver driver;

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    public void testWebForm(Class<? extends WebDriver> webdriverClass) throws InterruptedException {
        // Setup webdriver for browser
        driver = WebDriverManager.getInstance(webdriverClass).create();

        // Exercise
        driver.get("https://bing.com");

        // Assert
        Assertions.assertEquals("Bing", driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.id("search_icon"));

        searchBox.sendKeys("Selenium");
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        Assertions.assertEquals("Selenium", searchBox.getAttribute("value"));

        driver.quit();
    }
}
