package pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.code.ProjectPage;

public class SettingsPage extends BaseAuthorizedPage {

    private final static String TITLE = "";

    public SettingsPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By newNameField = By.name("new_name");
    private final By newNameApplyButton = By.xpath("//button[text() = 'Rename']");


    public ProjectPage renameRepository(String newName){
        driver.findElement(newNameField).clear();
        driver.findElement(newNameField).sendKeys(newName);
        driver.findElement(newNameApplyButton).click();
        return new ProjectPage(driver);
    }
}
