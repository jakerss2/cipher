package edu.grinnell.csc207.util;

/*
 * CSC207, MP1 CipherUtils.java by Jacob Bell.
 */


/**
 * Utility package for ciphers to work.
 */
public class CipherUtils {

  /**
   *  Letter_A is the int version of 'a'.
   */
  public static final int LETTER_A = 97;

  /**
   * Length of the alphabet.
   */
  public static final int LEN_OF_ALPHABET = 26;

  /**
   * Letter_Z is the in version of 'z'.
   */
  public static final int LETTER_Z = 122;

  /**
   * Converts a letter into an integer 0-25.
   * @param letter
   * @return int
   */
  private static int letter2int(char letter) {
    return (((int) letter) - LETTER_A); // Int - A(97)
  } //letter2int

  /**
   * Converts an integer from 0-25 into a letter.
   * @param i
   * @return char
   */
  private static char int2letter(int i) {
    if (i < 0) { // If the integer is less than 0 ('a')
      i += LEN_OF_ALPHABET;
    } //if

    if ((i + LETTER_A) >  LETTER_Z) { // If the character will be greater than 'z'
      return ((char) (i + LETTER_A - LEN_OF_ALPHABET));
    } // if
    return ((char) (i + LETTER_A)); // Return the character
  } //int2letter

  /**
   * Decrypt a cipher given a string and a letter.
   * @param str
   * @param letter
   * @return String
   */
  public static String caesarDecrypt(String str, char letter) {
    String coded = "";

    if (Character.isWhitespace(letter)) { // If there is no letter return no letter
      return coded;
    } // if

    for (int i = 0; i < str.length(); i++) { // Loop over the string changing the letter
      coded += int2letter(letter2int(str.charAt(i)) - letter2int(letter));
    } // for
    return coded;
  } // caesarDecrypt

  /**
   * Encrypt a given string by a letter.
   * @param str
   * @param letter
   * @return String
   */
  public static String caesarEncrypt(String str, char letter) {
    String coded = "";

    if (Character.isWhitespace(letter)) { // Check if there is no letter
      return coded;
    } //if

    for (int i = 0; i < str.length(); i++) { // Loop over the string and changing the letter
      coded += int2letter(letter2int(str.charAt(i)) + letter2int(letter));
    } // for

    return coded;
  } // caesarEncrypt

  /**
   * Vigenere encrypt a str with a given key.
   * @param str
   * @param key
   * @return String
   */
  public static String vigenereEncrypt(String str, String key) {
    if (key.equals("")) { // If the string key is nothing
      return key;
    } // if

    for (int i = 0; key.length() < str.length(); i++) { // Make the key the same length as str
      key += key.charAt(i);
    } //for

    String coded = "";

    for (int i = 0; i < str.length(); i++) { // Loop over the string and change the letter
      coded += int2letter(letter2int(str.charAt(i)) + letter2int(key.charAt(i)));
    } // for

    return coded;
  } // vigenereEncrypt

  /**
   * Vigenere decrypt a str with a key.
   * @param str
   * @param key
   * @return String
   */
  public static String vigenereDecrypt(String str, String key) {
    if (key.equals("")) { //If the string key is nothing
      return null;
    } // if

    for (int i = 0; key.length() < str.length(); i++) { // Make the key the same length as str
      key += key.charAt(i);
    } // for
    String coded = "";

    for (int i = 0; i < str.length(); i++) { // Loop over the string and change the letter
      coded += int2letter(letter2int(str.charAt(i)) - letter2int(key.charAt(i)));
    } // for

    return coded;
  } //vigenereDecrypt
} //CipherUtils
