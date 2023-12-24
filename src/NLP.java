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
            //ArrayList<String[]> arrayline = new ArrayList<>();
            File folder = new File(dir);
            File[] listOfFiles = folder.listFiles();

            //Creating the fileName as outside as possible
            //String[] fileName = new String[listOfFiles.length];
            //Index of the fileName tab
            //int indexFm = 0;
            ArrayList<ArrayList<String[]>> txtlines = new ArrayList<>();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    BufferedReader br = new BufferedReader(new FileReader(new
                            File( dir + "/" + file.getName())));
                    StringBuffer word = new StringBuffer();
                    String line;

                    //Increment index
                   // index ++;
                    //New fileName
                    //String[] fileName = new String[listOfFiles.length];
                    //fileName[indexFm] = file.getName();

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

                    //System.out.println("fileName[0] is : " + fileName[0]);
                    ArrayList<String[]> arrayline = new ArrayList<>();
                    arrayline.add(lines);
                    arrayline.add(fileName);

                    //To build txtlines like [[{lines of 900}, {"900.txt"}], [{...}, {...}]]
                    //ArrayList<String[]> tmp = new ArrayList<>();
                    //tmp.add(arrayline);
                    txtlines.add(arrayline);
                    //arrayline.add(String[] fileName = file.getName());
                    /*
                    for(int i=0;i<arrayline.size();i++){
                        for (int j = 0; i < arrayline.get(i).length; i++) {
                            //System.out.println("Printing arrayLine index " + i + " and its elem at index " + j + " : " + arrayline.get(i)[j]);
                            System.out.println("lines : " + lines[i])
                        }
                    }
                    */
                    /*
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
                    //Here at the end of one iteration. After this end, we want


                }
            } //End of iteration
            //ArrayList<ArrayList<String[]>> txtlines = new ArrayList<>(); //I moved it at the beninging
            // txtlines.add(arrayline); //I moved it

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
            //So txtlines is and arrayList containing arrayLine which contains a String[] lines and a String[] fileName
            //So we'll have a [ [{lines}, {fileName}], [...], [...] ]

            //Also, inc the index of fm
            //indexFm += 1;
            /*
            for ( int k = 0; k < txtlines.size(); k ++) {
                for ( int l = 0; l < txtlines.get(l).size(); l ){

                }
            }
             */

        } catch (IOException ioException){
            System.out.println("no");
        }

        return null;
    }



}
