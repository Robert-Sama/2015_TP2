import java.util.*;

public class WordMap implements Map {

//First thing:
    //check if we already have the word(key)
    //If we already have the key:
        // we go to FileMap (the key of WordMap is the reference)

//Second thing:
    //If we dont have the word(key):
        // we want to add a word(key) to WordMap
        // we check the size:
            //If size too small -> 2 * size + 1 => we need to adjust size of FileMaps too i think
            //If size fine: we do nothing

        // we add the word(key) and we create a reference to FileMap
        // we go to FileMap and take the name of the file/txt and the position (i think)

//Im not so sure how to create the reference towards FileMap




    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }

    public Object put(Object key, Object value) {
        return null;
    }

    public Object remove(Object key) {
        return null;
    }

    public void putAll(Map m) {

    }

    public void clear() {

    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set<Entry> entrySet() {
        return null;
    }
}
