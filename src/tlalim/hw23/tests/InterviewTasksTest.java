package tlalim.hw23.tests;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static tlalim.hw23.InterviewTasks.*;

class InterviewTasksTest {
    private static final int N_NUMBERS = 100000;
    int[] bigArray = new int[N_NUMBERS];
    @Test
    void isSum2PerformanceTest(){
        // isSum2Complexity O[N]
        isSum2(bigArray, 1);
    }
    @Test
    void isSum2N2PerformanceTest(){
        // isSum2Complexity O[N]
        is2Sum2N2(bigArray, 1);
    }
    @Test
    void isSum2Test() {
        int [] ar1 = {1000, 300, -200, 20, 40, -10};
        assertTrue(isSum2(ar1, 800));
        assertTrue(isSum2(ar1, 990));
        assertFalse(isSum2(ar1, 50));
    }
    @Test
    void is2Sum2N2Test() {
        int [] ar1 = {1000, 300, -200, 20, 40, -10};
        assertTrue(is2Sum2N2(ar1, 800));
        assertTrue(is2Sum2N2(ar1, 990));
        assertFalse(is2Sum2N2(ar1, 50));
    }
    @Test
    void getMaxPositiveWithNegativeValueTest() {
        int [] ar1 = {-1,100, 200, -50, 1, -100, 50};
        int [] ar2 = {-1, -100, 200, -500, 10, -100, 50, 200};
        assertEquals(100, getMaxPositiveWithNegativeValue(ar1));
        assertEquals(-1,  getMaxPositiveWithNegativeValue(ar2));
    }
    @Test
    void getMapOccurrencesTest() {
        String[] strings = {
                "lpm", "ab", "a", "lpm", "a", "aa", "lpm"
        };
        HashMap<String, Long> mapOccurrences = getMapOccurrences(strings);
        assertEquals(3, mapOccurrences.get("lpm"));
        assertEquals(2, mapOccurrences.get("a"));
        assertEquals(1, mapOccurrences.get("ab"));
        assertEquals(1, mapOccurrences.get("aa"));
    }
}