import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        /* this is my version bcoz i didnt see that prof gave code haha TAT

        Path folderPath = Paths.get("dataset");

        try (DirectoryStream<Path> directoryStream = getFiles(folderPath)) {
            for (Path filePath : directoryStream) {
                String fileName = filePath.toString();
                ConvertTxt convertTxt = new ConvertTxt();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();

                while (line != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                    line = bufferedReader.readLine();
                }
                String text = stringBuilder.toString();

                text = convertTxt.replacePunctuation(text);
                text = convertTxt.replaceSpace(text);

                // set up pipeline properties
                Properties props = new Properties();
                // set the list of annotators to run
                props.setProperty("annotators", "tokenize,pos,lemma");
                // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
                props.setProperty("coref.algorithm", "neural");
                // build pipeline
                StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
                // create a document object
                CoreDocument document = new CoreDocument(text);
                // annnotate the document
                pipeline.annotate(document);
                //System.out.println(document.tokens());
                for (CoreLabel tok : document.tokens()) {
                    System.out.println(String.format("%s\t%s",
                            tok.word(), tok.lemma()));
                }
            }
        } catch (IOException ioException) {
            // Handle exceptions, such as folder not found or permission issues
            ioException.printStackTrace();
        }
    }

         */
        ArrayList<String> listeDesDocsApresTraitement = new ArrayList<String>(); //each index are the formated txt of a file
        ArrayList<String> listeTest2 = new ArrayList<String>(); //each index are the words

        //We make the first instance of WordMaps
        WordMap wm = new WordMap();
        try {
            File folder = new File("src/dataset");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    BufferedReader br = new BufferedReader(new FileReader(new
                            File( "src/dataset" + "/" + file.getName())));

                    //Saving the file name
                    String fileName = file.getName();

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
                            System.out.println(String.format("%s\t%s", tok.word(), tok.lemma()));
                            String str = String.valueOf(tok.lemma());
                            if (!(str.contains("'s") || str.contains("’s"))) {
                                word.append(str).append(" ");
                            }
                            listeTest2.add(str); //Here we can get each words individually
                            //We should call WordMap here so that we can take each words separately
                            //Not really sure where to call FileMaps
                            //I think we should have a variable that has the position of the word in each iteration
                            //We call build with the word
                            //wm.build(str, fileName);

                        }
                    }
                    String str = String.valueOf(word);
                    str = str.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s+", " ").trim();

                    //Idk why but regex appeared
                    //We make the list in wordmap
                    // i should be the index of the word
                    int i = 0;
                    for (String mot : str.split(" ")) {
                        //On veut le fileName, l'index et le mot
                        i++;
                        //If the word is not in the list, we make a new fileMap
                        if (wm.containsKey(mot) == false) {
                            FileMaps fm = new FileMaps();
                            wm.put(mot, fm.buildFileMap(fileName, i));
                        } else { //if the word is in the list, we check in the fileMap
                            //System.out.println( wm.get(mot) ); //retourne null
                        }
                        //System.out.println( "Does wm containt the word : " + mot + " : " + wm.containsKey(mot) );

                    }

                    listeDesDocsApresTraitement.add(str);
                    System.out.println(fileName);

                }
            }
        } catch (IOException ioException){
            System.out.println("baka");}

        //Tests to see where we can get each words individually and the formated texts
        for(int i = 0; i < listeDesDocsApresTraitement.size(); i++){
            System.out.println("IMPRIMER " + listeDesDocsApresTraitement.get(i) +"AAAAAAAAAAAAA");
        }
        for(int i = 0; i < listeTest2.size(); i++){
            System.out.println("IMPRIMER2" + listeTest2.get(i) +"AAAAAAAAAAAAA2");
        }
    }




    /*
    public static DirectoryStream getFiles(Path dir) throws IOException {
        return Files.newDirectoryStream(dir);
    }

     */

}