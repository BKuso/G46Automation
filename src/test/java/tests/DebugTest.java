package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

import static helpers.DbHelper.executeQuery;
import static helpers.DbHelper.executeQueryWithResult;

public class DebugTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Old db test")
    public void checkDb(){
        executeQuery("update data.users set \"username\"='BKuso' where \"username\" = 'Test'");
    }

}
