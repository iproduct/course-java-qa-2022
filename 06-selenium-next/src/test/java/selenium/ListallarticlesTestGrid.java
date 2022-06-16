package selenium;// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ListallarticlesTestGrid {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        var caps = new DesiredCapabilities();
        caps.setBrowserName("Chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void listallarticles() {
        driver.get("https://localhost:8081/articles");
        driver.manage().window().setSize(new Dimension(1338, 880));
        driver.findElement(By.linkText("Add Article")).click();
        driver.findElement(By.id("content")).click();
        driver.findElement(By.id("content")).sendKeys("Spring is grate ...");
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).sendKeys("New Article");
        driver.findElement(By.id("file")).click();
        driver.findElement(By.id("file")).sendKeys("C:\\fakepath\\java2days.png");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.cssSelector("tr:nth-child(9) .btn-danger")).click();
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn-danger")).click();
        driver.findElement(By.id("navbarDropdown")).click();
        driver.findElement(By.linkText("Articles")).click();
        driver.findElement(By.linkText("Add Article")).click();
        driver.findElement(By.id("cancel")).click();
    }
}