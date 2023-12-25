import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bigrams {

    FileMap fileMap = new FileMap();
    public void wordOccurProb(String w1, ArrayList<ArrayList<String>> txts){

        ArrayList<ArrayList<Integer>> wordAppearances = fileMap.get(fileMap.wordMap.get(w1));

        int countWord1 = 0;
        Map<String, Integer> neighborCounts = new HashMap<>();

        //for loop on array of int where the word appeared in txt files [[3, 36], [8]] for example
        for(ArrayList<Integer> wordAppearance : wordAppearances){
            //loop on each array
            for(int j = 0; j < wordAppearances.size(); j++){
                // number of instance this word came up in txt
                countWord1++;

                /*
                1. for each instance, we find the neighbour following word of the current w1.
                2. we make a list of neighbour words, and
                3. make a for loop again in which each we calculate the probability of appearance
                4. probability of appearance is another method, the equation is the given P(W2|W1) = C(W1,W2)/C(W1)
                5. we make a new map neighbourCounts,
                in which we store the neighbour words as keys and probability as values
                6. we make a final comparison for the most probable and the smallest word as output

                 */
            }
        }
    }

}
