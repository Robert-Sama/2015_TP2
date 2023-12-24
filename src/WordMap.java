import java.util.*;

public class WordMap<K, V> extends AbstractMap<K, V> {

    //I just copied what the teacher did

    // physical storage for the map entries
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
    //private Map<String, FileMaps> map;

    // construct an initially empty map
    public WordMap() {}

    // private utilities
    // return the index of the entry with key k, or -1 if not found
    private int findIndex( K k ) {
        int n = this.table.size();
        for( int j = 0; j < n; j++ )
            if( this.table.get( j ).getKey().equals( k ) ) // found it
                return j;
        // none found
        return -1; // special value denoting not such entry
    }

    // number of entries in the map
    public int size() { return this.table.size(); }
    // return the value associated with the specified key, or null if not found
    public V get( K key ) {
        int j = this.findIndex( key );
        if( j == -1 ) return null; // not found
        return this.table.get( j ).getValue();
    }
    // check if an entry with given key exists
    public boolean containsKey( K key ) { return this.findIndex( key ) != -1; }
    // associate the pair key-value, replacing existing value if any
    public V put( K key, V value ) {
        int j = findIndex( key );
        if( j == -1 ) { // not found, so insert the new pair
            this.table.add( new MapEntry<>( key, value ) );
            return null;
        } else // key exists
            return this.table.get( j ).setValue( value ); // return old value
    }
    // remove the entry with specified key, if any, return its value
    public V remove( K key ) {
        int j = findIndex( key );
        if( j == -1 ) return null; // no such entry found
        int n = this.size();
        V retV = this.table.get( j ).getValue();
        // remove in O(1)
        if( j != n-1 ) // move last entry of the array to index j
            this.table.set( j, this.table.get( n-1 ) );
        this.table.remove( n-1 ); // remove the last entry
        // remove in O(n)
        //this.table.remove( j );
        return retV;
    }
    // support for entrySet public method
    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int j = 0;
        public boolean hasNext() { return j < table.size(); }
        public Entry<K,V> next() {
            if( j == table.size() ) throw new NoSuchElementException();
            return table.get( j++ );
        }
        public void remove() { throw new UnsupportedOperationException(); }
    }
    private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator() { return new EntryIterator(); }
    }
    public Iterable<Entry<K,V>> entrySet() { return new EntryIterable(); }
/*
    public void build(String word, int index, String fileName){
        //If the word is not in there, we put it in and we do a call to FileMaps
        if ( get((K) word) == null) {
            put( word, FileMaps);

        }

    } */

}
//String word;

//public WordMap (String motPStruct) {
// this.word = motPStruct;
//}


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


/*
    //This method is used to return the number of key/value pairs available in the map.
    public int size() {
        return 0;
    }

    //This method is used to check if a map is having any entry for key and value pairs. If no mapping exists, then this returns true.
    public boolean isEmpty() {
        return false;
    }

    //This method is used in Map Interface in Java to check whether a particular key is being mapped into the Map or not.
    //It takes the key element as a parameter and returns True if that element is mapped in the map.
    public boolean containsKey(Object key) {
        return false;
    }

    //This method is used in Map Interface to check whether a particular value is being mapped by a single or more than one key in the Map.
    //It takes the value as a parameter and returns True if that value is mapped by any of the keys in the map.
    public boolean containsValue(Object value) { return false; }

    //This method is used to retrieve or fetch the value mapped by a particular key mentioned in the parameter.
    //It returns NULL when the map contains no such mapping for the key.
    public Object get(Object key) {
        return null;
    }

    //This method is used in Java Map Interface to associate the specified value with the specified key in this map.
    public Object put(Object key, Object value) {
        return null;
    }

    //This method is used in Map Interface to remove the mapping for a key from this map if it is present in the map.
    public Object remove(Object key) {
        return null;
    }

    //This method is used in Map Interface in Java to copy all of the mappings from the specified map to this map.
    public void putAll(Map m) {

    }

    //This method is used in Map Interface in Java to copy all of the mappings from the specified map to this map.
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
*/
//We want to add the word in the map
//public void build(String mot, int index, String fileName){
//1-see if its not already registered
//containsKey()
//If it's already registered, we go find it in fileMap and add
//2-If not registered, add it with the reference to filemap
//put(Object key, Object value)
//Here we're gonna call filemap with the fileName and the position
