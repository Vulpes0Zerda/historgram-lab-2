package histogram;

import java.util.HashMap;

public class CharacterCounter {

  HashMap<Character, Integer> charCount;

  public CharacterCounter(){

    charCount = new HashMap<Character, Integer>();

  }

  public void countCharacter (char c) {
    if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
      charCount.putIfAbsent ( c, 0 );
      charCount.put ( c, charCount.get(c)+1 );
    }

  }

  public String getCountString(){
    String formatedCount = "";
    formatedCount.concat("============================\n");
    formatedCount.concat("***                      ***\n");
    formatedCount.concat("*** Number of Characters ***\n");
    formatedCount.concat("***                      ***\n");
    formatedCount.concat("----------------------------\n");
    formatedCount.concat("***                      ***\n");
    charCount.forEach(
      ( key, value ) -> {
        formatedCount.concat("***  "+ key + "  :  " + value + "  ***\n");
        formatedCount.concat("***                      ***\n");
      }
    );
    formatedCount.concat("============================\n");
    return formatedCount;
  }
}
