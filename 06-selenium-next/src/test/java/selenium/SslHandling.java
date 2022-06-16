package selenium;

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
import org.openqa.selenium.devtools.v101.security.Security;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SslHandling {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

//    @BeforeEach
//    void setupTest() {
//        driver = new ChromeDriver();
//    }

//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }


    @Test
    void testChrome() throws InterruptedException {

        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        driver = WebDriverManager.getInstance(ChromeDriver.class).capabilities(handlingSSL).create();

        //Launching the URL
        driver.get("https://expired.badssl.com/");

//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));

        // Verify
        var title = driver.getTitle();
        System.out.println("The page title is : " + title);
        assertThat(title).contains("expired.badssl.com");

        Thread.sleep(10000);
    }

    @Test
    void testChromeSelenium4DevTools() throws InterruptedException {

        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        driver = WebDriverManager.getInstance(ChromeDriver.class).capabilities(handlingSSL).create();

        // Get new Selenium 4 Dev Tools
        var devTools = ((ChromeDriver) driver).getDevTools();

        //Launching the URL
        driver.get("https://expired.badssl.com/");
        devTools.send(Security.enable());
        devTools.send(Security.setIgnoreCertificateErrors(true));
//        Thread.sleep(1000);

        // Verify
        var title = driver.getTitle();
        System.out.println("The page title is : " + title);
        assertThat(title).contains("expired.badssl.com");

        Thread.sleep(5000);
    }

    @Test
    void testFirefox() throws InterruptedException {

        //Creating an object of the FirefoxOptions Class
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        //Using the setAcceptInsecureCerts() method to pass parameter as False
        firefoxOptions.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        driver = WebDriverManager.getInstance(FirefoxDriver.class).capabilities(firefoxOptions).create();

        //Launching the URL
        driver.get("https://expired.badssl.com/");

//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));

        // Verify
        var title = driver.getTitle();
        System.out.println("The page title is : " + title);
        assertThat(title).contains("expired.badssl.com");

        Thread.sleep(10000);
    }

}
