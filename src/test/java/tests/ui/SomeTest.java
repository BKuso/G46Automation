package tests.ui;


import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.util.ExcelHelper.*;

public class SomeTest {

    @Test
    @Ignore
    public void checkFile(){
        List<String> testData = new ArrayList<>();
        testData.add("One");
        testData.add("Two");
        testData.add("Three");
        testData.add("Four");
        testData.add("Five");

        writeToExcelFile(
                System.getProperty("user.dir") + "/src/test/resources/data/TestExcelFile3.xltx",
                testData,
                "New automation",
                1);
    }

}

