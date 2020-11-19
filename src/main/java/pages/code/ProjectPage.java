package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.BasePage;
import pages.issues.IssuesPage;

public class ProjectPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница проекта";

    private final By issuesTab = By.xpath("//span[@data-content = 'Issues']");

    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public IssuesPage openProjectIssues(){
        try {
            driver.findElement(issuesTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new IssuesPage(driver);
    }
}
