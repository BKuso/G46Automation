package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;

import static helpers.ColorPrinter.printMessageInYellow;

public class LoginPageTest extends BaseTest{

    private LoginPage page;
    private String errorMessage;
    private String invalidMessage;

    @Before
    public void setPage(){
        printMessageInYellow("===Тест начат===");
        this.page = new LoginPage(driver);
        this.errorMessage = "There have been several " +
                "failed attempts to sign in from this account " +
                "or IP address. Please wait a while and try " +
                "again later.";
        this.invalidMessage = "Incorrect username or password.";
    }

    @Test
    public void negativeAuthTest(){
        page.checkAuthFields()
                .loginNegative("admin", "admin")
                .validateErrorMessage(errorMessage, true)
                .returnToLoginPage()
                .loginNegative("login", "password")
                .validateErrorMessage(invalidMessage);
    }

    @Test
    public void checkPositiveLogin(){
        try{
            page.checkAuthFields()
                    .login(System.getProperty("login"),
                            System.getProperty("password"))
                    .validateLogin();
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void showSystemVars(){
        System.out.println(System.getProperty("login"));
        System.out.println(System.getProperty("password"));
    }

    @After
    public void tearDown(){
        printMessageInYellow("===Тест окончен===");
    }

}
