package histogram;

import java.io.IOException;
import java.util.Scanner;

import histogram.fileIO.FileReader;
import histogram.fileIO.FileWriter;

public class CommandSequence {

  private Scanner scanner;
  private FileReader reader;
  private FileWriter writer;
  private CharacterCounter counter;

  private boolean fileWritten = false;
  private boolean fileRead = false;

  public CommandSequence(){
    scanner = new Scanner(System.in);
  }

  public void start(){
    readFile();
    counter = new CharacterCounter();

    writeFile();
    System.out.println("Writeing successful. Exiting Programm.");
    System.out.println("Have a nice day.");
  }


  public void readFile () {

    while ( !fileRead ) {

      System.out.println("Please input the file path and name (type quit, q or /q to close the programm):");
      String input = scanner.nextLine();

      switch ( input ) {

        // in a more complex programm, don't check for commands like this.
        // use Enumd and a parser like a normal person

        case "quit":
        case "q":
        case "/q":

          System.out.println("Programm aborted. Till next time <3");
          System.exit(0);
          break;

        default:

          // prevents the user from reading files that are not meant to be read in pure text
          if ( !input.matches(".*\\.txt$") ) {

            System.err.println("Please input the file type of '.txt' as your file. Other file types are not supported.");
            

          }

          try {

            reader = new FileReader(input);
            fileRead = !fileRead;

          } catch ( IOException e ) {

            System.err.println("Path or file does not exist. Please try a diffrent file.");
            System.err.println("Error: " + e.getMessage());

          };
          break;
        
      }
    }
  }


  public void sleepForTime(int ms) throws Exception{
    try{

      Thread.sleep(ms);

    } catch (Exception eThread){

      System.err.println("Somehow the idle thread was interrupted. We don't know how that happend.");
      System.err.println("Error: " + eThread);
      throw eThread;

    }
  }


  public void countCharacters(){
    int waitingCycles = 10;
    int sleepTime = 500;
    for(int i=0; i < waitingCycles; i++){
        
      try{

        if(reader.isReady()){
        
          reader.getCharacterStream().forEach(
            (e)->{
              char c = e.charAt(0);
              counter.countCharacter(c);
            }
          );
          
        }else if(i < waitingCycles-1){
        
          this.sleepForTime(sleepTime);
        
        } else {
        
          System.err.println("The reader timed out after "+ (waitingCycles * sleepTime /1000) +"s and your file could not be read.");
          System.err.println("Please ensure that your hard drive is fast enough and the file is not too big.");
          break;
        
        }

      } catch ( IOException e ) {
        
        System.err.println("The reader suddenly can't read the file.");
        System.err.println("That is most likely because the file was deleted in the process or is locked from the System.");
        System.out.println("Trying again in moment.");

      } catch ( Exception eThread){

        break;

      }
    }

  }


  public void writeFile(){

    while ( !fileWritten ) {

      System.out.println("Please write the path and name of the file you want the histogramm to be written to:");
      String input = scanner.nextLine();

      switch (input) {

        case "quit":
        case "q":
        case "/q":

          System.out.println("Programm aborted. Till next time <3");
          System.exit(0);
          break;

        default:

          if(!input.matches(".*\\.txt$")){
            System.err.println("Please input the file type of '.txt' as your file. Other file types are not supported.");
            break;
          }

          try{
          
              writer = new FileWriter(input);
              fileWritten = !fileWritten;

          }catch(IOException e){

              System.err.println(input + " is not a valid file name or path. Please use another");
              System.err.println("Error: " + e.getMessage());

          }
      }
    }
  }
}
