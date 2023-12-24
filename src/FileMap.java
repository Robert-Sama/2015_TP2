import java.util.*;

public class FileMap implements Map<List<String>, List<Integer>>{
    private Map<List<String>, List<Integer>> countWords;
    WordMap wordMap = new WordMap();
    //NLP nlp = new NLP();

    public FileMap(){
        this.countWords = new HashMap<>();
    }
    @Override
    public int size() {
        return countWords.size();
    }

    @Override
    public boolean isEmpty() {
        return countWords.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return countWords.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return countWords.containsValue(value);
    }

    @Override
    public List<Integer> get(Object key) {
        return countWords.get(key);
    }

    @Override
    public List<Integer> put(List<String> key, List<Integer> value) {
        return countWords.put(key, value);
    }

    @Override
    public List<Integer> remove(Object key) {
        return countWords.remove(key);
    }

    @Override
    public void putAll(Map<? extends List<String>, ? extends List<Integer>> m) {
        countWords.putAll(m);
    }

    @Override
    public void clear() {
        countWords.clear();
    }

    @Override
    public Set<List<String>> keySet() {
        return countWords.keySet();
    }

    @Override
    public Collection<List<Integer>> values() {
        return countWords.values();
    }

    @Override
    public Set<Entry<List<String>, List<Integer>>> entrySet() {
        return countWords.entrySet();
    }

    public void addOccurrences(ArrayList<ArrayList<String[]> > arrayList){
        //Here the list we take is txtlines
        //txtlines is and arrayList containing arrayLine which contains a String[] lines and a String[] fileName

        ArrayList<String> words = new ArrayList<>();

        for (ArrayList<String[]> innerList : arrayList) {
            for (String[] file : innerList) {
                for (int j = 0; j < file.length; j++) {
                    if (!words.contains(file[j])) {
                        words.add(file[j]);
                    }
                }
            }
        }
        System.out.println("word size : " + words.size());



        for (int k = 0; k < words.size(); k++) {
            ArrayList<Integer> wordOccurrences = new ArrayList<>();
            ArrayList<String> wordInWhichFile = new ArrayList<>();

            for (int i = 0; i < arrayList.size(); i++) {
                for (int y = 0; y < arrayList.get(i).size(); y++) {
                    //The second arrayList contains
                    String fileName = String.join("", arrayList.get(i).get(1));
                    String[] file = arrayList.get(i).get(y);
                    for (int j = 0; j < file.length; j++) {
                        if (words.get(k).equals(file[j])) {
                            wordOccurrences.add(j);
                            if (!wordInWhichFile.contains(fileName)) {
                                wordInWhichFile.add(fileName);
                            }
                        }
                        countWords.put(wordInWhichFile, wordOccurrences);
                        wordMap.put(words.get(k), wordInWhichFile);
                    }
                }
            }
        }
        System.out.println(countWords.size());
    }

}
