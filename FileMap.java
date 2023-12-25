import java.util.*;

public class FileMap implements Map<List<String>, ArrayList<ArrayList<Integer>>>{
    private Map<List<String>, ArrayList<ArrayList<Integer>>> countWords;
    WordMap wordMap = new WordMap();
    NLP nlp = new NLP();

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
    public ArrayList<ArrayList<Integer>> get(Object key) {
        return countWords.get(key);
    }

    @Override
    public ArrayList<ArrayList<Integer>> put(List<String> key, ArrayList<ArrayList<Integer>> value) {
        return countWords.put(key, value);
    }

    @Override
    public ArrayList<ArrayList<Integer>> remove(Object key) {
        return countWords.remove(key);
    }

    @Override
    public void putAll(Map<? extends List<String>, ? extends ArrayList<ArrayList<Integer>>> m) {
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
    public Collection<ArrayList<ArrayList<Integer>>> values() {
        return countWords.values();
    }

    @Override
    public Set<Entry<List<String>, ArrayList<ArrayList<Integer>>>> entrySet() {
        return countWords.entrySet();
    }

    public /*void*/ WordMap addOccurrences(ArrayList<ArrayList<String[]> > arrayList){

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
        System.out.println(words.size());


        for (int k = 0; k < words.size(); k++) {
            ArrayList<ArrayList<Integer>> wordOccurrences = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                ArrayList<String> wordInWhichFile = new ArrayList<>();
                for (int y = 0; y < arrayList.get(i).size(); y++) {
                    if (y % 2 == 0){
                        ArrayList<Integer> wordOccurrencesPerfile = new ArrayList<>();
                    /*
                    if ( y == 0) {
                        String fileName = String.join("", arrayList.get(i).get(y+1)); //fonctionne comme avant
                    } else if ( (y+2) < arrayList.get(i).size() ) {
                        String fileName = String.join("", arrayList.get(i).get(y+2));
                    }
                     */


                        //}
                        String[] file = arrayList.get(i).get(y);
                        //if ( y + 1 < arrayList.get(i).size()) {
                        String fileName = String.join("", arrayList.get(i).get((y+1)));
                        //}

                        System.out.println(" fileName " + fileName + i + (y+1));
                        for (String elem : file) {
                            System.out.println(elem + i + y);
                        }
                        //int index =

                        //for (String elem : file){
                        //    System.out.println("elem : " + elem + " de arraylist .get " + i + ".get " + y);
                        //}
                        for (int j = 0; j < file.length; j++) {
                            if (words.get(k).equals(file[j])) {
                                wordOccurrencesPerfile.add(j);
                                if (wordInWhichFile.contains(fileName) == false) {
                                    wordInWhichFile.add(fileName);
                                }
                            }
                            countWords.put(wordInWhichFile, wordOccurrences);
                            wordMap.put(words.get(k), wordInWhichFile);
                        }
                        if (wordOccurrencesPerfile.isEmpty() == false){
                            wordOccurrences.add(wordOccurrencesPerfile);
                        }

                    }

                } //End boucle y
            }
        }
        System.out.println(countWords.size());
        //Map<String, List<String>>
        //for (Map.Entry<String, List<String>> entry : wordMap.entrySet()) {
        //    System.out.println(entry.getKey() + ": " + entry.getValue());
        //}
        return wordMap; //not sure if it works like i wanted
    }

}
