package tests.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected RemoteWebDriver driver;
    protected RemoteWebDriver remoteWebDriver;

    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Attachment(value = "Failed screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenshotAsBytes){
            return screenshotAsBytes;
        }

        @Override
        protected void failed(Throwable e, Description description) {
            if (driver != null){
                saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
            super.failed(e, description);
        }

        @Override
        @Step("Закрываем драйвер после тестирования")
        protected void finished(Description description) {
            if (driver != null){
                driver.quit();
            }
        }

    };

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
        if (Boolean.parseBoolean(System.getProperty("remote.launch", "false"))){
            try {

                remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new DesiredCapabilities());

            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
    }

}
