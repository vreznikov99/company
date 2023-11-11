package tlalim.test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseIntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

class FunctionalInterfaceTest {
    Integer[] ar = {100, 13, -10, 201, 150, 17};
    void reverseSortTest(){
        Integer[] expected = {201, 150, 100, 17, 13, -10};
        Arrays.sort(ar, new ReverseIntegerComparator());
        assertArrayEquals(expected, ar);
    }

}