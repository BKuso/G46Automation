package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import pages.code.ProjectPage;

import java.util.stream.Collectors;


public abstract class BaseAuthorizedPage extends BasePage{

    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }
    //TODO Сделать чтобы всё работало
    //Search field
    private final By searchField = By.xpath("//input[@data-unscoped-placeholder = 'Search or jump to…']");
    private final By searchResults = By.xpath("//li[contains(@id, 'jump-to-suggestion-')]");
    //User Buttons
    private final By userProfileButton = By.xpath("//summary[@aria-label = 'View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public ProjectPage searchProject (String projectName){
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error(e);
        }
        driver.findElements(searchResults).get(1).click();
        return new ProjectPage(driver);
    }

    public HomePage logout(){
        driver.findElement(userProfileButton).click();
        driver.findElement(signOutButton).click();
        return new HomePage(driver);
    }

}
