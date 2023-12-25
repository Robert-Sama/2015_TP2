import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class NLP {

    public ArrayList<ArrayList<String[]>> docToNLP(String dir){
        try {
            ArrayList<String[]> arrayline = new ArrayList<>(); //Test to see if the same as before
            //ArrayList<ArrayList<String[]>> txtlines = new ArrayList<>();

            File folder = new File(dir);
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    BufferedReader br = new BufferedReader(new FileReader(new
                            File( dir + "/" + file.getName())));
                    StringBuffer word = new StringBuffer();
                    String line;
                    while ((line = br.readLine()) != null) {
                        String newline = line.replaceAll("[^’'a-zA-Z0-9]", " ");
                        String finalline = newline.replaceAll("\\s+", " ").trim();
                        // set up pipeline properties
                        Properties props = new Properties();
                        // set the list of annotators to run
                        props.setProperty("annotators", "tokenize,pos,lemma");
                        // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
                        props.setProperty("coref.algorithm", "neural");
                        // build pipeline
                        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
                        // create a document object
                        CoreDocument document = new CoreDocument(finalline);
                        // annnotate the document
                        pipeline.annotate(document);
                        //System.out.println(document.tokens());
                        for (CoreLabel tok : document.tokens()) {
                            //System.out.println(String.format("%s\t%s", tok.word(), tok.lemma()));
                            String str = String.valueOf(tok.lemma());
                            if (!(str.contains("'s") || str.contains("’s"))) {
                                word.append(str).append(" ");
                            }
                        }
                    }
                    String str = String.valueOf(word);
                    str = str.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s+", " ").trim();
                    System.out.println(str);

                    String[] lines = str.split(" ");
                    String[] fileName = new String[1];
                    fileName[0] = file.getName();

                    //Test to see if the same as before
                    //ArrayList<String[]> arrayline = new ArrayList<>();

                    arrayline.add(lines);
                    arrayline.add(fileName);
                    //txtlines.add(arrayline);

                    /*
                    //Test to see what is going on in arrayLine
                    int indexArrayLine = 0;
                    System.out.println("In doc " + file.getName() + "\n");
                    for (String[] arrayElem : arrayline) {

                        int indexElemInTheArrayElem = 0;
                        for ( String elem : arrayElem) {
                            System.out.println("Print elems of arrayLine in sub String[] " + indexArrayLine +": " + elem + " at subIndex : " + indexElemInTheArrayElem);
                            indexElemInTheArrayElem ++;
                        }
                        indexArrayLine ++;
                    }
                     */
                }
            }
            //Test to see if lie before
            ArrayList<ArrayList<String[]>> txtlines = new ArrayList<>();
            txtlines.add(arrayline);
/*
            System.out.print("[ ");
            for (ArrayList<String[]> list : txtlines) { // Parcours du premier ArrayList
                System.out.print("[ ");
                for (String[] array : list) { // Parcours du deuxième ArrayList
                    System.out.print("{ ");
                    for (String element : array) { // Parcours du tableau de chaînes
                        System.out.print(element + " "); // Imprime l'élément suivi d'un espace
                    } System.out.print(" }");
                    //System.out.println(); // Nouvelle ligne après chaque tableau de chaînes
                } System.out.print(" ]");
            } System.out.print(" ]");
*/
            return txtlines;

        } catch (IOException ioException){
            System.out.println("no");
        }

        return null;
    }



}
