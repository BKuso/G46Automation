package pages.issues;

import helpers.Level;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;

public class IssueInfoPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница информации о задаче";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class = 'js-issue-title']");
    private final By statusImg = By.xpath("//div[contains(@class, ' flex-md-self-center')]/span");
    private final By description = By.xpath("//td[contains(@class, 'js-comment-body')]");
    private final By labels = By.xpath("//*[@class = 'lh-condensed-ultra']");

    @Step("Проверяем корректность создания задачи")
    public IssueInfoPage validateCreatedIssue(String titleText, String body, List<String> testLabels){
        printColorMessage("Проверяется созданная задача", log, Level.INFO);
        try {
            log.debug("Проверяю заголовок задачи");
            Assert.assertEquals(titleText, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImg).isDisplayed());
            log.debug("Проверяю тело задачи");
            Assert.assertEquals(body, driver.findElement(description).getText());
            driver.findElements(labels).forEach(label -> {
                log.debug("Проверяю метку: " + label.getText());
                Assert.assertTrue(testLabels.contains(label.getText()));
                testLabels.remove(label.getText());
            });
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректно: " + n.getMessage());
        }

        printColorMessage("Данные проверены. Задача успешно создана", log, Level.INFO);
        return this;
    }
}
