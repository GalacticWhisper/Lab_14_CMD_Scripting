import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class FileScan {
    public static void main(String[] args) {

        boolean bean = true;

        if(args = "FewWords.txt")
        {
        {
            System.out.println("Beans and such"); // This prints if there is a command line.
        }
        else // This runs if there is no command line. This is the original behavior of the program.
        {
            String rec = "";
            ArrayList<String> lines = new ArrayList<>();
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("src"));
            int result = chooser.showOpenDialog(chooser);


            try {
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();
                    InputStream in =
                            new BufferedInputStream(Files.newInputStream(file, CREATE));
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(in));


                    int line = 0;
                    int wordCount = 0;
                    int charCount = 0;
                    while (reader.ready()) {
                        rec = reader.readLine();
                        lines.add(rec);
                        line++;

                        System.out.printf("\nLine %4d %-60s ", line, rec);


                    }
                    String[] chars = rec.split("");
                    charCount += chars.length;

                    String[] words = rec.split("\\W");
                    wordCount += words.length;


                    System.out.println("\n\nFile name: " + selectedFile);
                    System.out.println("\nNumber of lines: " + line);
                    System.out.println("\nNumber of words: " + wordCount);
                    System.out.println("\nNumber of characters: " + charCount);

                    String fields[] = lines.get(0).split("\\W");


                    reader.close();
                    System.out.println("\n\nData file read.");
                } else {
                    System.out.println("No file was chosen. Run the program again and choose a file.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File could not be located.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
