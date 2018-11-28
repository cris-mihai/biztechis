/*
package test;

import main.Model.Member;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static main.Model.ScannerOperations.splitOnSpace;

public class LoadTest {

    private ArrayList<Member> testMember;

    @Test
    public void loadTest() throws IOException {
        PrintWriter testWriter = new PrintWriter("testText.txt", "UTF-8");
        List<String> lines = Files.readAllLines(Paths.get("testText.txt"));
        for (String line : lines){
            ArrayList<String> testList = splitOnSpace(line);
            Member testMember = new Member("Cris", 2, true, 0001);
            this.testMember.add(testMember);
        }

    }
}
*/
