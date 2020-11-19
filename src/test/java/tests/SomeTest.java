package tests;


import org.junit.Test;

import java.util.List;

import static helpers.FileHelper.readLinesFromFile;
import static helpers.FileHelper.writeTextToFile;

public class SomeTest {

    @Test
    public void checkFile(){
        writeTextToFile(
                "/home/bohdan/projectQALight/G46Automation/src/test/resources/data/out.txt",
                "First line\nSecond line\nThird line");
    }

}

