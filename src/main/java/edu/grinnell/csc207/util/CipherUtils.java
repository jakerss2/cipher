package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return (((int)letter) - 97); // STUB
  }

  private static char int2letter(int i) {
    if (i < 0){
      i += 26;
    }

    if ((i + 97) >  122){
      return ((char)(i + 97 - 26));
    }
    return ((char)(i + 97)); // STUB
  }

  public static String caesarDecrypt(String str, char letter) {
    String coded = "";

    if (Character.isWhitespace(letter)) {
      return coded;
    }

    for (int i = 0; i < str.length(); i++){
      coded += int2letter(letter2int(str.charAt(i)) - letter2int(letter));
    }
    

    return coded; // STUB
  }

  public static String caesarEncrypt(String str, char letter) {
    String coded = "";
    if (Character.isWhitespace(letter)) {
      return coded;
    }

    for (int i = 0; i < str.length(); i++){
      coded += int2letter(letter2int(str.charAt(i)) + letter2int(letter));
    }

    return coded; // STUB
  }

  public static String vigenereEncrypt(String str, String key) {
    for(int i = 0; key.length() < str.length(); i++){
      key += key.charAt(i); 
    }
    String coded = "";

    for (int i = 0; i < str.length(); i++){
      coded += int2letter(letter2int(str.charAt(i)) + letter2int(key.charAt(i)));
    }

    return coded;
  }

  public static String vigenereDecrypt(String str, String key) {
    for(int i = 0; key.length() < str.length(); i++){
      key += key.charAt(i); 
    }
    String coded = "";

    for (int i = 0; i < str.length(); i++){
      coded += int2letter(letter2int(str.charAt(i)) - letter2int(key.charAt(i)));
    }

    return coded;
  }
}
