package tests.ui;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp(){
        switch (System.getProperty("browser", "chrome")){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "opera":
                driver = new OperaDriver();
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
    }

    @After
    public void quit(){
        driver.quit();
    }

}
