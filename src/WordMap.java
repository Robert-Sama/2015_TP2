import java.util.*;

public class WordMap implements Map<String, List<String>> {

    private Map<String, List<String>> words;

    public WordMap(){
        this.words = new HashMap<>();
    }

    @Override
    public int size() {
        return words.size();
    }

    @Override
    public boolean isEmpty() {
        return words.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return words.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return words.containsValue(value);
    }

    @Override
    public List<String> get(Object key) {
        return words.get(key);
    }

    @Override
    public List<String> put(String key, List<String> value) {
        return words.put(key, value);
    }

    @Override
    public List<String> remove(Object key) {
        return words.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<String>> m) {
        words.putAll(m);
    }

    @Override
    public void clear() {
        words.clear();
    }

    @Override
    public Set<String> keySet() {
        return words.keySet();
    }

    @Override
    public Collection<List<String>> values() {
        return words.values();
    }

    @Override
    public Set<Entry<String, List<String>>> entrySet() {
        return words.entrySet();
    }
}
