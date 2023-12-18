import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import java.util.Properties;
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

        try {
            File folder = new File("dataset");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    BufferedReader br = new BufferedReader(new FileReader(new
                            File( "dataset" + "/" + file.getName())));
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
                        }
                    }
                    String str = String.valueOf(word);
                    str = str.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s+", " ").trim();


                }
            }
        } catch (IOException ioException){
            System.out.println("baka");}
    }




    /*
    public static DirectoryStream getFiles(Path dir) throws IOException {
        return Files.newDirectoryStream(dir);
    }

     */


}
