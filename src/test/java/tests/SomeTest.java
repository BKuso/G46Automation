package tests;

import org.junit.Before;
import pages.LoginPage;

public class SomeTest extends BaseTest{

    private LoginPage page;

    @Before
    public void setPage(){
        page = new LoginPage(driver);
        System.out.println();
    }

    //@Test()
    public void ourTest(){
        page.checkAuthFields();
    }


}

