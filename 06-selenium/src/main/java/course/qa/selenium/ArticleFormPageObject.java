package course.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class ArticleFormPageObject {
    // No page elements added

    public ArticleFormPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "title")
    public WebElement title;

    @FindBy(how = How.NAME, using = "content")
    public WebElement content;
}
