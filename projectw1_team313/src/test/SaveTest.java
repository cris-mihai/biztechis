/*
package test;

import main.Model.Member;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static main.Model.ScannerOperations.clearTheFile;

public class SaveTest {

    private ArrayList<Member> testDriver;

    @Test
    public void saveTest() throws IOException {
        PrintWriter testWriter = new PrintWriter("testText.txt", "UTF-8");
        clearTheFile();
        for (Member d: testDriver){
            testWriter.println(d.getName()+" "+d.getYear()+" "+d.MemberStatus()+" "+d.getMemberID());
        }
        testWriter.close();
    }
}*/
