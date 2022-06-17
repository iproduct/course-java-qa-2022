package course.qa.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WebdriverManagerTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

//    @BeforeEach
//    void setupTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        driver = new ChromeDriver(options);
//    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    public void openBrowserPage(Class<? extends WebDriver> webdriverClass) throws InterruptedException {
        // Setup webdriver for browser
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = WebDriverManager.getInstance(webdriverClass).capabilities(options).create();

        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Assert
        assertThat(title).contains("Selenium WebDriver");

//        Thread.sleep(2000);
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    public void openInsecureCertificatePage(Class<? extends WebDriver> webdriverClass) throws InterruptedException {
        // Setup webdriver for browser
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = WebDriverManager.getInstance(webdriverClass).capabilities(options).create();

        // Exercise
        driver.get("https://expired.badssl.com/");
        String title = driver.getTitle();

        // Assert
        assertThat(title).contains("expired.badssl.com");

//        Thread.sleep(2000);
    }
}
