package edu.grinnell.csc207.main;

/*
 * CSC207, MP1 Cipher.java by Jacob Bell.
 */

import java.io.PrintWriter;

/**
 * Sort out through the given args and determine what functions to use.
 */
public class Cipher  {

  /**
   * Amount of arguments.
   */
  public static final int LEN_OF_ARGS = 4;

    /**
   * Length of the alphabet.
   */
  public static final int LEN_OF_ALPHABET = 26;

  /**
   * Main function that takes args.
   * @param args
   */
  public static void main(String[] args)  {
    PrintWriter pen = new PrintWriter(System.out, true);
    char keych = '\0';
    String action = "";
    String cipherType = "";
    String message = "";
    String keyStr = "";

    if (args.length != LEN_OF_ARGS) {
      System.err.println("Error: not enough args");
      return;
    } // if

    for (int i = 0; i < args.length; i++) { // Determine what the actions/strings are

      if (args[i].equals("")) {
        System.err.println("Error: Empty");
        return;
      } // if

      if (args[i].equals("-encode") || (args[i].equals("-decode"))) {
        action = args[i]; //set action to encode or decode
      } else if (args[i].equals("-caesar") || args[i].equals("-vigenere")) {
        cipherType = args[i]; //set cipherType to caesar or vigenere
      } else if (message == "") {
        message = args[i]; //set the message to the first non action/cipherType
        if (message.length() == 0) {
          System.err.println("Error: Empty");
          return;
        } //if
      } else if (args[i].length() != 1) {
        keyStr = args[i]; //set the key to whatever the second non action/cipherType
      } else  {
        keych = args[i].charAt(0);
      } // if
    } // for

    for (char ch : message.toCharArray()) {
      if (!(ch >= 'a' && ch <= 'z')) {
        System.err.print("Error: not lowercase");
      } //if
    } //for

    for (char ch : keyStr.toCharArray()) {
      if (ch < 'a' || ch > 'z') {
        System.err.print("Error: not lowercase");
        return;
      } //if
    } //for

    if ((keych == '\0') && (keyStr.equals(""))) {
      System.err.print("Error: not lowercase");
      return;
    } else if (keych != '\0') { // This is simply saying that if keyStr is defined
      if (keych < 'a' || keych > 'z') {
        System.err.print("Error: not lowercase");
        return;
      } //if (nested)
    } //if

    String coded = "";

    if (cipherType.equals("-caesar")) { // Ask what cipher it is
      if (keyStr.length() > 0) {
        System.err.print("Error: Incorrect message size");
        return;
      } // if
      if (action.equals("-encode")) { //Encode or decode
        coded = edu.grinnell.csc207.util.CipherUtils.caesarEncrypt(message, keych);
        pen.print(coded);
      } else  {
        coded = edu.grinnell.csc207.util.CipherUtils.caesarDecrypt(message, keych);
        pen.print(coded);
      } // if (nested)
    } else  { // end of caesar if statement/start of vigenere
      if (action.equals("-encode")) {
        coded = edu.grinnell.csc207.util.CipherUtils.vigenereEncrypt(message, keyStr);
        pen.print(coded);
      } else {
        coded = edu.grinnell.csc207.util.CipherUtils.vigenereDecrypt(message, keyStr);
        pen.print(coded);
      } // if (nested)
    } //if
    pen.close();
  } //main
} //Cipher
