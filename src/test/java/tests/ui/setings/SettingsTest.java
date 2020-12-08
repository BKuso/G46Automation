package tests.ui.setings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.settings.SettingsPage;
import tests.ui.BaseTest;

public class SettingsTest extends BaseTest {

    private SettingsPage page;


    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("BKuso/G46Automation")
                .openSettingsPage();
    }

    @Test
    public void checkRepositoryRenaming(){
        page.renameRepository("SomeName")
                .validateRenaming("SomeName");
    }


    @After
    public void tearDown(){
        page.logout()
                .validateLogOut();
    }

}
