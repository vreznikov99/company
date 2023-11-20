package tlalim.company.interviewTasks;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyDictionary {
    List<String> array = new LinkedList<>();
    public MyDictionary(List<String> words) {
        //Filling words of the dictionary from the given list
        words.stream().forEach(word -> array.add(word));
    }
    /**
     * adds word into dictionary
     * @param word
     * @return true if new word has been added, false if such word already exists
     *
     */
    public boolean addWord(String word) {
        //
//        boolean res = false;
//        if(!array.contains(word)){
//            array.add(word);
//            res = true;
//        }
        boolean res = array.stream().anyMatch(w -> w.equals(word));
        if (!res) {
            array.add(word);
            res = true;
        } else{
            res = false;
        }

        return res;
    }
    /**
     * looking for the words with a given prefix
     * @param prefix
     * @return array of words with the given prefix
     */
    public String [] getWordsByPrefix(String prefix) {
        List<String> strRes = array.stream().
                              filter(s->s.startsWith(prefix)).
                              collect(Collectors.toList()).
                              stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();

//        String[] res =

        return strRes.toArray(new String[]{});
    }
}
