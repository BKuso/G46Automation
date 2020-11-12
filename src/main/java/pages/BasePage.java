package pages;

import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static helpers.Level.DEBUG;

public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;
    private String title;

    public BasePage(WebDriver driver, String title){
        this.driver = driver;
        this.title = title;
        this.log = LogManager.getLogger(this.title);
        printColorMessage( "Создан экземпляр страницы: " + title + ", класс: "
                + this.getClass().getName(), log, DEBUG);
    }

}
