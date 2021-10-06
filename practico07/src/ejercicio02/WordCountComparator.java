package ejercicio02;

import java.util.Comparator;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Entry<String,Long>> {

    @Override
    public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
        if (o1.getValue() < o2.getValue()) {
            return 1;
        } else if (o1.getValue() > o2.getValue()) {
            return -1;
        }
        return 0;
    }

}
