package present;

import java.util.ArrayList;

public class DictionaryImpl<K, V> implements Dictionary<K, V> {
    private ArrayList<DictionaryEntry<K, V>> contents;

    public DictionaryImpl() {
        contents = new ArrayList<DictionaryEntry<K, V>>();
    }

    private DictionaryEntry<K, V> findEntry(ArrayList<DictionaryEntry<K, V>> entries, K key) {
        if (entries.isEmpty()) {
            return null; // Base case: if the list is empty, return null
        }
        DictionaryEntry<K, V> firstEntry = entries.get(0);
        if (firstEntry.getKey().equals(key)) {
            return firstEntry; // Base case: if the first entry matches the key, return it
        }
        // Recursive case: search the rest of the list
        return findEntry(new ArrayList<>(entries.subList(1, entries.size())), key);
    }

    private DictionaryEntry<K, V> findEntry(K key) {
        return findEntry(contents, key);
    }

    @Override
    public void put(K key, V value) {
        DictionaryEntry<K, V> entry = findEntry(key);
        if (entry == null) {
            contents.add(new DictionaryEntry<K, V>(key, value));
        } else {
            entry.setValue(value);
        }
    }

    @Override
    public V get(K key) {
        DictionaryEntry<K, V> entry = findEntry(key);
        return (entry == null) ? null : entry.getValue();
    }
}
