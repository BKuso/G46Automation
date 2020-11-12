package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.issues.IssuesPage;

public class IssueCreationTest extends BaseTest{

    private IssuesPage page;

    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .openOurProject()
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation(){
        page.pressToCreateNewIssue()
                .createNewIssue("Automated title", "Test body")
                .validateCreatedIssue("Automated title", "Test body");
    }

}
