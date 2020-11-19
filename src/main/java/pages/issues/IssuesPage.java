package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.BasePage;

public class IssuesPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница со список задач проекта";

    public IssuesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By newIssueButton = By.xpath("//a[@class = 'btn btn-primary']");

    public IssueCreationPage pressToCreateNewIssue(){
        log.info("Нажимем на \"Создать новую задачу\"");
        Assert.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        driver.findElement(newIssueButton).click();
        log.info("Кнопка нажата");
        return new IssueCreationPage(driver);
    }
}
