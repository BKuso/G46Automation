package tests;

import pages.LoginPage;

public class SomeTest {

   // @DataProvider
    public Object[][] testData(){
        return new Object[][]{ {"login", "password"}, {"admin", "admin"} };
    }

   // @Test(dataProvider = "testData")
    public void ourTest(String login, String password){
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }
}

