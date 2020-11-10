package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private final static String TITLE = "Основная страница GitHub";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By successTitle = By.xpath("//h2[@class = 'shelf-title']");

    public void validateLogin(){
        log.info("Проверяем успешность авторизации");
        Assert.assertTrue("Не удалось авторизоваться в приложении",
                driver.findElement(successTitle).isDisplayed());
        Assert.assertEquals(
                "Сообщение изменено, проверка не пройдена",
                "Learn Git and GitHub without any code!",
                driver.findElement(successTitle).getText());
        log.info("Успешно!");
    }

}
