package tlalim.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//class ReverseIntegerComparator implements Comparator<Integer>{
//    // Before Java 8 had to write a specific class Comparator
//    @Override
//    public int compare(Integer o1, Integer o2) {
//
//        return o2 - o1;
//    }
//}

class FunctionalInterfaceTest {
    Integer[] ar = {100, 13, -10, 201, 150, 17};
    @Test
    void reverseSortTest(){
        Integer[] expected = {201, 150, 100, 17, 13, -10};
//        Arrays.sort(ar, new ReverseIntegerComparator()); // Before Java 8
        Arrays.sort(ar, (o1, o2) -> o2 - o1); // lambda statement
        assertArrayEquals(expected, ar);
    }
    @Test
    void evenOddSortLambdaBlockTest() {
        // Start - even numbers, after - odd numbers
        // even numbers sorted in the Ascending order
        // odd numbers sorted by Descending order
        Integer[] expected = {-10, 100, 150, 201, 17, 13};
        Arrays.sort(ar, (o1, o2) -> {
            int res = 0;
            if (o1 % 2 == 0 && o2 % 2 != 0) {
                res = -1;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                res = 1;
            } else if(o1 % 2 == 0 && o2 % 2 == 0) {
                res = o1 - o2;
            } else if(o1 % 2 != 0 && o2 % 2 != 0) {
                res = o2 - o1;
            }
            return res;
        });
        assertArrayEquals(expected, ar);

    }
}