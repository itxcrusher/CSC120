package present;

public class DictionaryEntry<K, V> {
    private K key;
    private V value;

    public DictionaryEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V newValue) {
        this.value = newValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DictionaryEntry<?, ?> that = (DictionaryEntry<?, ?>) obj;
        return key.equals(that.key); // Compare only the keys
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "{" + key + ": " + value + "}";
    }
}


private DictionaryEntry<K, V> findEntry(ArrayList<DictionaryEntry<K, V>> entries, K key) {
    if (entries.isEmpty()) {
        return null;
    }
    DictionaryEntry<K, V> firstEntry = entries.get(0);
    if (firstEntry.getKey().equals(key)) {
        return firstEntry;
    }
    return findEntry(new ArrayList<>(entries.subList(1, entries.size())), key);
}

private DictionaryEntry<K, V> findEntry(K key) {
    return findEntry(contents, key);
}