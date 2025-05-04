package histogram.fileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;



public class FileWriter {

  private BufferedWriter writer;
  private String text;


  public FileWriter(String path) throws IOException,NullPointerException,IllegalStateException{
    File file = new File(path);
    File parent = file.getParentFile();
    if (parent != null && !parent.exists() && !parent.mkdirs()) {
        throw new IllegalStateException("Couldn't create dir: " + parent);
    }
    this.writer = new BufferedWriter(new java.io.FileWriter(path));
  }

  public void writeToFile(String text) throws IOException{
    writer.append(text);
  }
}
