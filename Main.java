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


        for (Map.Entry<List<String>, ArrayList<ArrayList<Integer>>> entry : fileMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter string for TD method :");
        String userInput = input.nextLine();
        input.close();


        //TEST wordMap
        //For all the words, ...
        //We want to take the word
        //look at its txt files
        //get the length of each txt files
        //find the number of times the word is in each txt files
        for (Map.Entry<String, List<String>> entry1 : wordMap.entrySet()) {

            //System.out.println(entry1.getKey() + ": " + entry1.getValue());
            String mot = entry1.getKey(); //we get the word
            if (userInput.equals(mot)) {
                List<String> countdwL = entry1.getValue(); //We get the list of the files in which are the mots
                for (String elem2 : countdwL){
                    System.out.println(elem2);

                }

                ArrayList<ArrayList<Integer>> positionsOfMots = fileMap.get(entry1.getValue()); //We get the array of the positions of the words in the documents
                //We find totalD
                File folder = new File("src/dataset");
                File[] listOfFiles = folder.listFiles();
                int totalD = listOfFiles.length;

                //For all the files of the word, we calculate TF, IDF, etc.
                for (int i = 0; i < countdwL.size() ; i++){
                    String elem = countdwL.get(i);
                    String path = "src/dataset" + elem;
                    //We get the length of each txt files
                    int countdw = entry1.getValue().size();       //gets the number of files of the word
                    //int countdw = countdwL.size();
                    File ff = new File(path);
                    long totalW = ff.length();                  //gets the length of the specified file
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

                    //TFd(w) = count(w)/totalW
                    //count(w) = le nombre de fois où le mot w apparaît dans un document
                    //totalW = totalW est le nombre total de mots dans le document (longueur en termes de mots)
                    //IDF(w) = 1 + ln((1+totalD)/(1+count(d,w)))
                    //TFIDFd(w) = TFd(w)⨉IDF(w)
                    //Scored =σ𝑤∈𝑞𝑢𝑒𝑟𝑦 TFIDFd(w)


                }



                //System.out.print(mot + fileMap.get(fmKey));
                //for (Map.Entry<List<String>, ArrayList<ArrayList<Integer>>> entry2 : fileMap.entrySet()) {
                //System.out.println(entry2.getKey() + ": " + entry2.getValue());
                //On veut pour chaque entry1.getkey(), avoir la entry2.getkey et get value correspondante
                //}

            } else {
                System.out.println("Input word not in any files");

            }

        }
        //We now have wordMap and fileMap
        //we want to look at



    }
}
//For the number of txt files that the word is in,
//for (int i =0; i < fileMap.entrySet().getKey().size(); i ++ ) {
//}