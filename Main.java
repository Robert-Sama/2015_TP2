import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NLP nlp = new NLP();
        FileMap fileMap = new FileMap();
        WordMap wordMap = new WordMap();

        fileMap.addOccurrences(nlp.docToNLP("src/dataset"));
///*
        for (Map.Entry<List<String>, ArrayList<ArrayList<Integer>>> entry : fileMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//*/


    }
}
