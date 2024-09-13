package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
* AllCaesar checks what the user input is and determines which functions to run.
*/
public class AllCaesar {

  /**
   * Length of arguments that are to be given.
   */
  public static final int LEN_OF_ARGS = 4;

  /**
   * Main method to print commands.
   * @param args
   */
  public static void main(String[] args)  {

    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length == 1 || args.length == LEN_OF_ARGS) {
      System.err.println("Incorrect number of parameters");
    } //if

    if (!((args[0].equals("encode")) || (args[0].equals("decode")))) {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    } //If user input isn't encode or decode.

    if (args[0].equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = " + ch + ": " + CipherUtils.caesarEncrypt(args[1], ch) + "\n");
      } //for
    } else {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = " + ch + ": " + CipherUtils.caesarDecrypt(args[1], ch) + "\n");
      } //for
    } //else

    pen.close();
  } //main
} //AllCaesar
