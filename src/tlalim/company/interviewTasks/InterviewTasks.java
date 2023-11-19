package tlalim.company.interviewTasks;

import java.util.*;
import java.util.stream.*;



public class InterviewTasks {
    /**
     *
     * @param ar array of integer numbers
     * @param sum integer number
     * @return true if the given array contains two numbers, the sum of which equals the given sum value
     */
    public static boolean isSum2(int [] ar, int sum) {

        boolean running = true;
        HashSet<Integer> setHelper = new HashSet<>();
        int i = 0;
        while(i < ar.length && running) {
            if(setHelper.contains(sum - ar[i])) {
                running = false;
            } else {
                setHelper.add(ar[i]);
                i++;
            }
        }
        return !running;
    }
    /**
     *
     * @param ar array of integer numbers
     * @param sum integer number
     * @return true if the given array contains two numbers, the sum of which equals the given sum value
     */
    public static boolean isSum2N2(int[] ar, int sum) {
        int i = 1;
        int j = 0;
        boolean running = true;
        while(i < ar.length && running) {
            j = i - 1;
            while(j >= 0 ) {
                if(ar[j] + ar[i] == sum) {
                    running = false;
                    break;
                }
                j--;
            }
            i++;
        }
        return !running;
    }
    /**
     *
     * @param ar array of integer numbers
     * @return maximal positive number having negative number with the same absolute value
     */
    public static int getMaxPositiveWithNegativeValue (int ar[]) {
        int res = -1;
        HashSet<Integer> setHelper = new HashSet<>();

        for(int num: ar) {
            if(setHelper.contains(-num)) {
                res = Math.max(res, Math.abs(num));
            } else {
                setHelper.add(num);
            }
        }
        return res;
    }

    /**
     *
     * @param strings - array of strings
     * @return Map where key - string, value - number of occurrences in the array
     */
    public static HashMap<String, Long> getMapOccurrences(String[] strings) {

        //Optionally, additional bonus if you apply the method "merge" of the interface Map
        //try to understand this method https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
        //it uses Functional interface BiFunction
        HashMap<String, Long> res = new HashMap<>();
        for(String string: strings) {
            res.merge(string, 1l, Long::sum);
        }
        return res;
    }
    /**
     * Anagram of a string is another string containing all the symbols
     * from the string, but in different order (see the test cases)
     * @param string
     * @param anagram
     * @return true if the second parameter presents an anagram
     *  of the string from the first parameter, otherwise false
     */
    public static boolean isAnagram(String string, String anagram) {
        HashMap <Character,Integer> map = new HashMap();
        HashMap <Character,Integer> map1 = new HashMap();
        char [] a = string.toCharArray();
        char [] b = anagram.toCharArray();
        boolean running = false;
        for (char c : a)
        {
            map.merge(c, 1 , (x, y) -> x + y);
        }
        for (char c : b)
        {
            map1.merge(c, 1 , (x, y) -> x + y);
        }

        for (char c : a)
        {
            if (map1.get(c) != map.get(c) || string.equals(anagram))
            {
                running = false;
                break;
            } else {
                running = true;
            }

        }
        return running;

    }

    // Task for streams/grouping
    public static void displayDigitsDistribution(){

        // create steam of random int's, each int number in range[1,Integer.MAX_VALUE]
        // conversion to stream of Strings
        // extract separate char's from Strings
        // grouping with counting
        // sorting
        // printing

        int nNumbers = 1_000_000;
        Random gen = new Random();
//        Map<Integer, Long> map = gen.ints(nNumbers, 1, Integer.MAX_VALUE).
//        mapToObj(Integer::toString).
//        flatMapToInt(s->s.chars()).boxed().
//        collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<String, Long> map = gen.ints(nNumbers, 1, Integer.MAX_VALUE).
                mapToObj(Integer::toString).
                flatMapToInt(s->s.chars()).
                mapToObj(n -> "" + (char)n).
                collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        map.entrySet().stream().
        sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).
        forEach(e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue()));
    }

    /**
     * prints a given array in shuffled order
     * @param array
     * Hint: see solution of sportloto from "java-streams"
     */
    public static void displayArrayShuffling(int[] array){
        new Random().ints(0,array.length).
        distinct().limit(array.length).
        forEach(i -> System.out.print(array[i] + " "));


    }
}
