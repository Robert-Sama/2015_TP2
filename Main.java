import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;

import java.nio.file.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

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

                System.out.println(text);
            }
        } catch (IOException e) {
            // Handle exceptions, such as folder not found or permission issues
            e.printStackTrace();
        }

    }

    public static DirectoryStream getFiles(Path dir) throws IOException {
        return Files.newDirectoryStream(dir);
    }

    /*
    1- process the text by replacing all punctuation marks by spaces, replacing multiple spaces by one
    2- NLP text processing: instruction page 11
    3- implement Map interface and override its necessary functions.
    4- Word map
    5- file map
    6- You can use the hashcode() method of the Object class, or override it

     */
}