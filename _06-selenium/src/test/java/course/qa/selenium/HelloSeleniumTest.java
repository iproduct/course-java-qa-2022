package course.qa.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    }
}
