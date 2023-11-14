package tlalim.stream;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {
    int[] arr = {10, 13, 8, 7, 3, 5, 6};
    @Test
    void arrayStreamTest() {
        //
        int[] empty = {};
        assertEquals(24, stream(arr).filter(n -> n % 2 == 0).sum());
        assertEquals(0, stream(empty).filter(n -> n % 2 != 0).max().orElse(0));
        assertEquals(13, stream(arr).filter(n -> n % 2 != 0).max().orElse(0));
    }

    @Test
    @Disabled
    void displaySportloto() {
        Random gen = new Random();
        gen.ints(1, 50).
                distinct().limit(7).
                forEach((n -> System.out.print(n + " ")));
    }
    @Test
    void evenOddGrouping(){
        Map<String, List<Integer>> mapOddEven = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
        System.out.println(mapOddEven);

    }

    @Test
    void displayOccurrenceSorted(){
        String[] strings = {"lpm", "y", "lpm", "aa", "yy", "yy", "aa", "lpm", "a"};
        //output:
        /*
         * lpm => 3
         * aa => 2
         * yy => 2
         * a => 1
         * y => 1
         */

        Map<String, Long> occurrenceMap = stream(strings).
                                          collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        occurrenceMap.entrySet().stream().
                sorted((e1,e2) -> {
                    int res = Long.compare(e2.getValue(),e1.getValue());
                    if(res == 0){
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                }).
                forEach(e -> System.out.printf("%s => %d\n", e.getKey(), e.getValue()));
//        System.out.println(occurrenceMap);
    }
    @Test
    void stringStream(){
        String string = "Hello";
        // output: h, e, l, l, o
//        string.chars().forEach(c -> System.out.printf("%c", c));
        string.chars().mapToObj(c -> "" + (char) c).
                forEach(s -> System.out.print(s + ","));
    }


}