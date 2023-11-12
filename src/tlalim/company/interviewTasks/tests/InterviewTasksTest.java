package tlalim.company.interviewTasks.tests;

import static org.junit.jupiter.api.Assertions.*;
import static tlalim.company.interviewTasks.InterviewTasks.isAnagram;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InterviewTasksTest {
    @Test
    void isAnagramTest() {
        String string = "yellow";
        assertTrue(isAnagram(string, "wolely"));
        assertTrue(isAnagram(string, "elolwy"));
        assertTrue(isAnagram(string, "lowely"));
        assertTrue(isAnagram(string, "ollwey"));
        assertFalse(isAnagram(string, "wolelw")); //not y
        assertFalse(isAnagram(string, string));//the same order
        assertFalse(isAnagram(string, "wglely"));//g is not from the string
        assertFalse(isAnagram(string, "wolye"));//must be two 'l'

    }

}
