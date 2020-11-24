package tests;


import org.junit.Test;

import java.util.List;

import static helpers.ExcelHelper.readColumnFromExcelFile;
import static helpers.ExcelHelper.readExcelFile;
import static helpers.FileHelper.readLinesFromFile;
import static helpers.FileHelper.writeTextToFile;

public class SomeTest {

    @Test
    public void checkFile(){
        readExcelFile(
                System.getProperty("user.dir") + "/src/test/resources/data/TestExcelFile3.xltx",
                "Sheet1").forEach(System.out::println);
    }

}

