/*
package test;

import main.Model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConsoleUI {
    private ArrayList list;

    @BeforeEach
    public void setup() {
        list = new ArrayList();
    }

    @Test
    public void testGettingInfo() {
        Member testDriver1 = new Member("Test", 1, true, 1);
        Member testDriver2 = new Member("Test2", 2, false, 6);
        Member testDriver3 = new Member("Test3", 3, true, 101);
        list.add(testDriver1);
        list.add(testDriver2);
        list.add(testDriver3);

        assertEquals(testDriver1.getName(), "Test");
        assertEquals(testDriver2.getName(), "Test2");
        assertEquals(testDriver3.getName(), "Test3");
        assertEquals(testDriver1.getYear(), 1);
        assertEquals(testDriver2.getMemberID(), 6);
        assertFalse(testDriver3.MemberStatus());
    }

    @Test
    public void testCreatingNewDriver() {
        Member userGeneratedTest = new Member(null, 0, false, 0);
        userGeneratedTest.setName("Racer");
        userGeneratedTest.setYear(4);
        userGeneratedTest.setMemberStatus(true);
        userGeneratedTest.setMemberID(9);

        assertEquals(userGeneratedTest.getName(), "Racer");
        assertEquals(userGeneratedTest.getYear(), 4);
        assertEquals(userGeneratedTest.MemberStatus(), true);
        assertEquals(userGeneratedTest.getMemberID(), 9);
    }
}*/
