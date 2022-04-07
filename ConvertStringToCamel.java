import java.lang.StringBuilder;
class Solution{

  static String toCamelCase(String str){
    String[] array = str.split("[-_]");
    for(int i = 1; i < array.length; i ++){
      String word = array[i];
      String letter = word.substring(0,1);
      letter = letter.toUpperCase();
      word = letter + word.substring(1);
      array[i] = word;
    }
    return String.join("",array);
  }
}
