package course.qa.selenium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HelloSeleniumTest {
    @Test
    public void openChromePage() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\CourseJavaQA\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);

        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Assert
        assertThat(title).contains("Selenium WebDriver");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            log.warn("Test interrupted", e);
//        }finally {

        //cleanup
        driver.quit();
//        }
    }
}
