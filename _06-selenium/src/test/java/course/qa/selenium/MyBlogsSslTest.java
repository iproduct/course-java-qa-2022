package course.qa.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v101.security.Security;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MyBlogsSslTest {
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
        driver.get("https://localhost:8081/articles");
        String title = driver.getTitle();

        // Assert
        assertThat(title).contains("Articles List");

//        Thread.sleep(5000);
    }
    @Test
    public void openBrowserPage() throws InterruptedException {
        // Setup webdriver for browser
        driver = WebDriverManager.getInstance(ChromeDriver.class).create();
        var devTools =  ((ChromeDriver) driver).getDevTools();
        devTools.send(Security.enable());
        devTools.send(Security.setIgnoreCertificateErrors(true));

        // Exercise
        driver.get("https://localhost:8081/articles");
        String title = driver.getTitle();

        // Assert
        assertThat(title).contains("Articles List");

//        Thread.sleep(5000);
    }

}
