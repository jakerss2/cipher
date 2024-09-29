package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/*
 * CSC207, MP1 AllCaesar.java by Jacob Bell.
 */


/**
* AllCaesar checks what the user input is and determines which functions to run.
*/
public class AllCaesar {

  /**
   * Length of arguments that are to be given.
   */
  public static final int LEN_OF_ARGS = 2;

  /**
   * Main method to print commands.
   * @param args
   */
  public static void main(String[] args)  {

    PrintWriter pen = new PrintWriter(System.out, true);

    if (!(args.length == LEN_OF_ARGS)) {
      System.err.print("Error: Incorrect num of args, expected 4 got " + args.length);
      return;
    } //if

    if (args[1].equals("")) {
      System.err.print("");
    } //if

    if (!(args[0].equals("encode") || args[0].equals("decode"))) {
      System.err.print("Error: Needs encode or decode");
      return;
    } //if

    for (char ch : args[1].toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        System.err.print("");
      } //if
    } //for

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
