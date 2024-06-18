package present;

import java.util.ArrayList;

public class DictionaryImpl<K, V> implements Dictionary<K, V> {
    private ArrayList<DictionaryEntry<K, V>> contents;
    public DictionaryImpl(){
        contents = new ArrayList<DictionaryEntry<K, V>>();
    }
    private DictionaryEntry<K, V> findEntry(K key){
        for(DictionaryEntry<K, V> entry : contents){
            if(entry.getKey().equals(key)){
                return entry;
            }
        }
        return null;
    }
}
