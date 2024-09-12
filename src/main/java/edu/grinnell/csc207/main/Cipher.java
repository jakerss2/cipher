package edu.grinnell.csc207.main;

import java.io.PrintWriter;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.printf("THIS IS A PRINT OF LENGTH %d \n", args.length);
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }

    char keych = '\0';
    String action = "", cipherType = "", message = "", keyStr = "";

    if (args.length != 4){
        System.err.println("Incorrect amount of commands");
    }

    for(int i = 0; i < args.length; i++){
      if (args[i].equals("-encode") || (args[i].equals("-decode"))){
        action = args[i]; //set action to encode or decode
        pen.printf("I AM PRINTING THE STRING ON LINE 23, %s \n", action);
      } else if(args[i].equals("-caesar") || args[i].equals("-vigenere")){
        cipherType = args[i]; //set cipherType to caesar or vigenere
        pen.printf("I AM PRINTING THE STRING ON LINE 26, %s \n", cipherType);
      } else if (message == ""){
        message = args[i]; //set the message to the first non action/cipherType
        pen.printf("I AM PRINTING THE STRING ON LINE 29, %s \n", message);
      } else if (args[i].length() != 1){
        keyStr = args[i]; //set the key to whatever the second non action/cipherType
      } else{
        keych = args[i].charAt(0);
      }
    }


    String coded = "";

    if (cipherType.equals("-caesar")){
      if (action.equals("-encode")){
        pen.println("KEYCH IS " + keych);
        coded = edu.grinnell.csc207.util.CipherUtils.caesarEncrypt(message, keych);
        pen.println(coded);
      } else {
        coded = edu.grinnell.csc207.util.CipherUtils.caesarDecrypt(message, keych);
        pen.println(coded);
      }
    } else {
      if (action == "-encode"){
        for (int i = 0; i < 26; i++){
          edu.grinnell.csc207.util.CipherUtils.vigenereEncrypt(message, keyStr);
        } // for caesarEncrypt
      } else {
        for (int i = 26; i > 0; i--){
          edu.grinnell.csc207.util.CipherUtils.vigenereDecrypt(message, keyStr);
        } // for caesarDecrypt
      }
      pen.close();

    }
  }
}
