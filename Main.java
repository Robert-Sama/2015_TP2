import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        NLP nlp = new NLP();
        FileMap fileMap = new FileMap();
        WordMap wordMap = new WordMap();


        wordMap= fileMap.addOccurrences(nlp.docToNLP("src/dataset"));

        /*
        //Verify the contents of fileMap
        for (Map.Entry<List<String>, ArrayList<ArrayList<Integer>>> entry : fileMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */

        //We take the user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string for TD method :");
        String userInput = input.nextLine();
        input.close();

        //Here we have the TFIDF functions
        //We look through all the words in wordMap
        for (Map.Entry<String, List<String>> entry1 : wordMap.entrySet()) {

            //We register a variable mot as a key.
            //We are looking for the user input by comparing it with the keys in wordMap
            //In retrospect, we could've just looked by doing .containskey, but its too late now.
            String mot = entry1.getKey(); //we get the word
            if (userInput.equals(mot)) {
                //We get the list of the files in which are the words
                List<String> countdwL = entry1.getValue(); 

                //We get the array of the positions of the words in the documents
                ArrayList<ArrayList<Integer>> positionsOfMots = fileMap.get(countdwL); 
                //We find totalD by looking at the dataset folder and getting its length
                File folder = new File("src/dataset");
                File[] listOfFiles = folder.listFiles();
                int totalD = listOfFiles.length;
                
                //We go through all the files that contain the word that we are looking for
                for (int i = 0; i < countdwL.size() ; i++){

                    //We get the name of the file that we are currently in
                    String elem = countdwL.get(i);
                    String path = "src/dataset" + elem;
                    //int countdw = countdwL.size();
                    File ff = new File(path);
                    long totalW = ff.length();                  //gets the length of the specified file
                    
                    int countdw = countdwL.size();       //gets the number of files containing the word
                                                        //countdwL is the list of the names of the files that contains the word
                    //We want to get the number of times the word is in the specified file
                    //positionsOfMots is the list containing the lists of the positions.
                    //So when i = 0, we are in the first file, we want the number of positions in this file.
                    // which corresponds to the first index of the sub list. So we want the size of the sub index of the first list.
                    int countw = positionsOfMots.get(i).size();  //gets all the number of times the word is in the file
                    System.out.println(countw + " times the word in specified file : " + elem);
                    System.out.println(countdw + "files in which there is the word");
                    System.out.println(totalW + "length of specified file");
                    System.out.println(totalD + "total number of files");
                    /*
                    int TF = countw/totalW;
                    double IDF = 1 + Math.log( (1+totalD)/(1+countdw) );
                    double TFIDF = TF * IDF;
                    System.out.println("TFIDF(\"" + mot + "\") dans le document " + elem + " = TF(\"" + mot + "\")xIDF(\"" + mot + "\") = " + TFIDF);
                    System.out.println("TF(\"" + mot + "\") = " + TF);
                    System.out.println("IDF(\"" + mot + "\") = " + IDF);
                     */
                    
                }



                //System.out.print(mot + fileMap.get(fmKey));
                //for (Map.Entry<List<String>, ArrayList<ArrayList<Integer>>> entry2 : fileMap.entrySet()) {
                //System.out.println(entry2.getKey() + ": " + entry2.getValue());
                //On veut pour chaque entry1.getkey(), avoir la entry2.getkey et get value correspondante
                //}

            } else {
                System.out.println("zgeg");

            }

        }
    }
}
