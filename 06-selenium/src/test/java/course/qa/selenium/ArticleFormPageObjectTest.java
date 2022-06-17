package course.qa.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ArticleFormPageObjectTest {
    @Test
    public void TestTitleAndContentFields() throws InterruptedException {
        // In order to understand how action on WebElements using PageObjects work,
        // we will save all the logs of chrome driver. Below statement helps us
        // save all the logs in a file called TestLog.txt
        System.setProperty("webdriver.chrome.logfile", "TestLog.txt");

        ChromeOptions handlingSSL = new ChromeOptions();
        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriver driver = WebDriverManager.getInstance(ChromeDriver.class).capabilities(handlingSSL).create();

        driver.get("https://localhost:8081/articles/article-form");
        driver.manage().window().setSize(new Dimension(1722, 936));

        // Initialize the Page object
        ArticleFormPageObject pageObject = new ArticleFormPageObject(driver);

        // Write some values to title and content
        pageObject.title.sendKeys("Using Page Objects"); // A FindBy call is triggered to fetch title
        pageObject.content.sendKeys("Page objects make selenium testing more robust ..."); // A FindBy call is triggered to fetch content

        // Read values from the Text box.
        log.info("TITLE: {}", pageObject.title.getAttribute("value")); // A FindBy call is triggered to fetch title
        log.info("CONTENT: {}", pageObject.content.getAttribute("value")); // A FindBy call is triggered to fetch content

        assertThat(pageObject.title.getAttribute("value")).isEqualTo("Using Page Objects");
        assertThat(pageObject.content.getAttribute("value")).isEqualTo("Page objects make selenium testing more robust ...");

        driver.close();
        driver.quit();
    }
}
