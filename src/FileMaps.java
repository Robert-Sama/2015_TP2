import java.util.*;
import java.util.Map;

public class FileMaps /*implements Map*/ {
    Map<ArrayList, ArrayList> map = new HashMap<>();
    ArrayList<String> tabFileName = new ArrayList<>();
    ArrayList<Integer> tabIndex = new ArrayList<>();
    String fileName;
    int index;

    public FileMaps(/*String fileName, int index*/) {
        /*
        this.fileName = fileName;
        this.index = index;
        */
    }

    //We want to cumulate the data in lists, so each filename are in a list and each word position too
     public ArrayList buildFileMap (String fileName, int index) {
        //We want to put the strings in the lists, then map them
        tabFileName.add(fileName);
        tabIndex.add(index);
        return map.put(tabFileName, tabIndex);
     }


    /*
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
     */
}
