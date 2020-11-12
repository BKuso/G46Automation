package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static helpers.ColorPrinter.printColorMessage;

public class IssueInfoPage extends BasePage {

    private final static String TITLE = "Страница информации о задаче";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title = By.xpath("//span[@class = 'js-issue-title']");
    private final By statusImg = By.xpath("//div[contains(@class, ' flex-md-self-center')]/span");
    private final By description = By.xpath("//td[contains(@class, 'js-comment-body')]");

    public IssueInfoPage validateCreatedIssue(String titleText, String body){
        printColorMessage("Проверяется созданная задача", log, Level.INFO);
        try {
            Assert.assertEquals(titleText, driver.findElement(title).getText());
            Assert.assertTrue(driver.findElement(statusImg).isDisplayed());
            Assert.assertEquals(body, driver.findElement(description).getText());
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректно: " + n.getMessage());
        }

        printColorMessage("Данные проверены. Задача успешно создана", log, Level.INFO);
        return this;
    }
}
