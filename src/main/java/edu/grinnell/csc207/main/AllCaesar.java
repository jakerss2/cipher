package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
  PrintWriter pen = new PrintWriter(System.out, true);

  if (args.length == 1 || args.length == 4){
      System.err.println("Incorrect number of parameters");
  }
  if (args.length != 2){
      System.err.println("Incorrect amount of commands");
      System.exit(2);
  }
  if (!((args[0].equals("encode")) || (args[0].equals("decode")))){
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
  } //If user input isn't encode or decode.

  if (args[0].equals("encode")){
    for (char ch = 'a'; ch <= 'z'; ch++){
      pen.printf("n = " + ch + ": " + CipherUtils.caesarEncrypt(args[1], ch) + "\n");
    } //for
  } else {
      for (char ch = 'a'; ch <= 'z'; ch++){
        pen.printf("n = " + ch + ": " + CipherUtils.caesarDecrypt(args[1], ch) + "\n");
      } //for
  } //else

    pen.close();
  } //main
} //AllCaesar
