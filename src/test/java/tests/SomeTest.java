package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.LoginPageObject;

public class SomeTest extends BaseTest{

    private LoginPageObject page;

    @Before
    public void setPage(){
        page = new LoginPageObject(driver);
    }

    //@Test()
    public void ourTest(){
        page.checkAuthFields();
    }


}

