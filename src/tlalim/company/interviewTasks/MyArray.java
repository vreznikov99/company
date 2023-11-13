package tlalim.company.interviewTasks;

import java.util.*;

public class MyArray {

    /********************************************/
    /**
     * constructor
     * @param size - length of the array
     */
    private int size;
    private int value;
    private HashMap<Integer, Integer> map = new HashMap<>();
    public MyArray(int size) {
        this.size = size;
    }
    /**
     * sets all array's elements with a given value
     * @param value
     */
    public void setAll(int value) {
        map = new HashMap<>(value);
        this.value = value;
    }
    /**
     *
     * @param index
     * @return value at given index or null if index is wrong
     */
    public Integer get(int index) {
        Integer res = map.containsKey(index) ? map.get(index) : value;
        if (index < 0 || index >= size)
            res = null;
        return res;
    }
    /**
     * sets a given value at a given index
     * throws IndexOutOfBoundsException in the case of wrong index
     * @param index
     * @param value
     */
    public void set(int index, int value) {
        //TODO
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Wrong index" + index);
        }
        map.put(index, value);
    }
}
