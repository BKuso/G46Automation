package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;

import static helpers.ColorPrinter.printMessageInYellow;

public class MainPage extends BaseAuthorizedPage{

    private final static String TITLE = "Основная страница GitHub";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By successTitle = By.xpath("//h2[@class = 'shelf-title']");

    public void validateLogin(){
        printMessageInYellow("Проверяем успешность авторизации", log);
        Assert.assertTrue("Не удалось авторизоваться в приложении",
                driver.findElement(successTitle).isDisplayed());
        Assert.assertEquals(
                "Сообщение изменено, проверка не пройдена",
                "Learn Git and GitHub without any code!",
                driver.findElement(successTitle).getText());
        printMessageInYellow("Успешно!", log);
    }

    public ProjectPage openOurProject(){
        driver.get("https://github.com/BKuso/G46Automation");
        return new ProjectPage(driver);
    }

}
