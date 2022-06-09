package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class FirstScriptTest {
    public WebDriver driver;

    @Test
    public void eightComponents() {
        System.setProperty("webdriver.chrome.driver","D:\\CourseJavaQA\\chromedriver_win32\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://bing.com");

        Assertions.assertEquals("Bing", driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

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
