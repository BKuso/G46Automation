package pages.issues;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class IssueCreationPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница создания задачи";

    public IssueCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By issueTitleField = By.id("issue_title");
    private final By issueBodyField = By.id("issue_body");
    private final By issueCreationButton = By.xpath("//button[@class = 'btn btn-primary']");
    private final By labelsShowButton = By.id("labels-select-menu");
    private final By issueLabels = By.xpath("//span[@class = 'name']");

    @Step("Создаём новую задачу")
    public IssueInfoPage createNewIssue(String title, String body, List<String> testLabels){
        log.info("Создаём новую задачу");
        Assert.assertTrue(driver.findElement(issueTitleField).isDisplayed());
        driver.findElement(issueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(issueBodyField).isDisplayed());
        driver.findElement(issueBodyField).sendKeys(body);
        Assert.assertTrue(driver.findElement(labelsShowButton).isDisplayed());
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(labelsShowButton));
        driver.findElement(labelsShowButton).click();
        driver.findElements(issueLabels)
                .stream()
                .filter(label -> testLabels.contains(label.getText()))
                .forEach(WebElement::click);
        driver.findElement(labelsShowButton).click();
        Assert.assertTrue(driver.findElement(issueCreationButton).isDisplayed());
        driver.findElement(issueCreationButton).click();
        log.info("Задача создана");
        return new IssueInfoPage(driver);
    }
}
