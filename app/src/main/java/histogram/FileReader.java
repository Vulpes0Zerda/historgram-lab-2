package histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {
    public BufferedReader fileReader;
    public int nextCharacter;
    
    public void printFileCharacters(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            int character;
            while ((character = inputStreamReader.read()) != -1) {
                System.out.print((char) character);
            }
            inputStreamReader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
