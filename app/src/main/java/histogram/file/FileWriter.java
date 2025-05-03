package histogram.file;

import java.io.File;
import java.util.Scanner;



public class FileWriter {

  private File file;
  private String fileText;
  private Scanner scanner;

  public FileWriter(String fileName){
    file = new File(fileName);
    scanner = new Scanner(System.in);
  }

  public void setFileText(String fileText){
    this.fileText = fileText;
  }

  public String getFileText(){
    return fileText;
  }

  public boolean saveFile(){
    return file.createNewFile();
  }
}
