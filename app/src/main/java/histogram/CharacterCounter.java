package histogram;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CharacterCounter {

  HashMap<Character, Integer> charCount;
  
  char highestChar;
  int charSum;


  public CharacterCounter(){

    charCount = new HashMap<>();
    charSum = 0;

  }

  public void add (char c) {
    if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
      charCount.putIfAbsent ( c, 0 );
      charCount.put ( c, charCount.get(c)+1 );
    }

  }

  public void setHighestChar(){

    for(char key: charCount.keySet()){
      if(highestChar == 0){
        highestChar = key;
      }
      if (charCount.get(key) > charCount.get(highestChar)) {
        highestChar = key;
      }
    }

  }

  public void setCharSum(){
    for(int value: charCount.values()){
      charSum += value;
    }
  }

  

  public String getTopCountString(){

    StringBuilder str = new StringBuilder();

    this.setHighestChar();

    
    str.append("============================\n");
    str.append("***                      ***\n");
    str.append("** Most Occuring Character**\n");
    str.append("***                      ***\n");
    str.append("----------------------------\n");
    str.append("***                      ***\n");
    str.append("***   " + highestChar + " : " + charCount.get(highestChar) + "\n");
    str.append("***                      ***\n");
    
    return str.toString();
  }


  public String getCountString(){
    StringBuilder str = new StringBuilder();
    str.append("============================\n");
    str.append("***                      ***\n");
    str.append("*** Number of Characters ***\n");
    str.append("***                      ***\n");
    str.append("----------------------------\n");
    str.append("***                      ***\n");
    charCount.forEach(
      ( key, value ) -> {
        str.append("***  "+ key + "  :  " + value + "\n");
      }
    );
    str.append("***                      ***\n");

    return str.toString();
  }


  public String getHistogrammString(){
    StringBuilder str = new StringBuilder();
    DecimalFormat dec = new DecimalFormat("#.#");

    this.setCharSum();

    double maxPercent = Double.valueOf(charCount.get(highestChar)) / Double.valueOf(charSum) * 100;

    double maxPercentRound = Math.round(maxPercent*10)*0.1;

    str.append("=====================================================\n");
    str.append("  |           |            |            |           |\n");
    // calculates the absolute percentage of the indicators 
    str.append("  0%         "+Math.round(maxPercentRound*0.25*10)*0.1+"%         "+Math.round(maxPercentRound*0.50*10)*0.1+"%         "+Math.round(maxPercentRound*0.75*10)*0.1+"%        "+maxPercentRound+"%\n");
    str.append("\n");
    charCount.forEach((key, value)->{
      str.append(key+":");
      // calculates the amount of stars that have to be placed relative to the maxium character, which is always 50 spaces
      int maxRuns = (int) Math.round((double) value/ charCount.get(highestChar) * 50);
      for(int i = 0; i < maxRuns ; i++){
        str.append("*");
      }
      str.append("\n");
    });
    str.append("\n");
    str.append("  0%         "+Math.round(maxPercentRound*0.25*10)*0.1+"%         "+Math.round(maxPercentRound*0.50*10)*0.1+"%         "+Math.round(maxPercentRound*0.75*10)*0.1+"%        "+maxPercentRound+"%\n");
    str.append("  |           |            |            |           |\n");
    str.append("=====================================================\n");

    return str.toString();

  }
  
}
