package present;

import java.util.ArrayList;

public class NewDictionaryImpl<K, V> implements Dictionary<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public NewDictionaryImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    private int findIndex(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                return i;
            }
        }
        return -1; // Key not found
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index != -1) {
            return values.get(index);
        }
        return null;
    }

    // Methods for put will be implemented here
}
