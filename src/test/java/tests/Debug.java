package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.User;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static helpers.DbHelper.executeQueryWithResult;
import static org.javalite.activejdbc.Base.open;

public class Debug {

    @Before
    public void openDbConnection(){
        new DB("study")
                .open("org.postgresql.Driver",
                        "jdbc:postgresql://localhost:5432/study",
                        "postgres",
                        "postgres");
    }

    @Test
    public void checkDb(){
    //    User.findAll().forEach(System.out::println);
        User.find("username = ?", "BKuso")
                .forEach(user ->
                        System.out.println(user.getString("id")));
        User.findFirst("username = ?", " BKuso").deleteCascade();
        //System.out.println(executeQueryWithResult("select * from data.users"));
    }

    @After
    public void closeConnections(){
        new DB("study").close();
    }
}
