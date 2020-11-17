package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collection;

import static helpers.ColorPrinter.printMessageInYellow;

@RunWith(Parameterized.class)
public class LoginNegativeTest extends BaseTest{

    private LoginPage page;
    private String errorMessage;
    private String invalidMessage;

    private String login;
    private String password;

    public LoginNegativeTest(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data(){
        Collection<String[]> result = new ArrayList<>();
        result.add(new String[]{"login", "password"});
        result.add(new String[]{"tester", "tester"});
        result.add(new String[]{"testGit", "testGit"});
        result.add(new String[]{"someTest", "123qweqwe"});
        return result;
    }

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
                .loginNegative(this.login, this.password)
                .validateErrorMessage(invalidMessage);
    }

    @After
    public void tearDown(){
        printMessageInYellow("===Тест окончен===");
    }

}
