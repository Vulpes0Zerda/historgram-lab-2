package histogram.fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class FileReader {

    private String path;
    private BufferedReader reader;

    public FileReader(String path) throws FileNotFoundException{
        this.path = path;
        this.reader = new BufferedReader(new java.io.FileReader(path));
    }


    public boolean isReady() throws IOException {
        return reader.ready();
    }


    public Stream<String> getCharacterStream(){
        return reader.lines();
    }

    public BufferedReader getReader(){
        return reader;
    }
    
}
