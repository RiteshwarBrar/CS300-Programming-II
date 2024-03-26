//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is a program for creating a palindrome string by using a character input from the
//////////////// user and making a pattern out of it
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources:Piazza posts
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class Palindrome {
  /**
   * Recursively create a simple alphabet pattern, starting at the provided character, moving
   * backward to the beginning of the alphabet, and then forward again to the provided letter,
   * separating each letter with a space.
   * 
   * @param start stores the character from which the pattern would begin
   * @return returns the desired mirror pattern
   * @throws IllegalArgumentException when the character from input is not an UpperCase Character
   */
  public static String mirrorA(char start) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException(
          "Invalid Input: Character entered as input is in Lower Case."
              + " The requirement here is Upper Case");
    }
    if (start != 'A' && start > 65)
      return start + " " + mirrorA((char) (start - 1)) + " " + start;
    else if (start == 'A')
      return "" + start;
    else
      return "";
  }

  /**
   * Recursively create an alphabet pattern, starting at the provided character, and moving back and
   * forth to the beginning of the alphabet by steps of size step .
   * 
   * @param start stores the character from which the pattern would begin
   * @param step  stores the number of characters to skip to create this special pattern
   * @return returns the desired mirror pattern
   * @throws IllegalArgumentException when the character from input is not an UpperCase Character or
   *                                  the step size is less than 1
   */
  public static String mirrorA(char start, int step) throws IllegalArgumentException {
    if ((!Character.isUpperCase(start)) || step < 1) {
      throw new IllegalArgumentException(
          "Invalid Input: Character entered is in Lower Case or the step size is less than 1");
    }
    if (start == 'A')
      return "" + start;
    else if ((start - step) < 65)
      return start + " " + start;
    else if (start != 'A' && start > 65)
      return start + " " + mirrorA((char) (start - step), step) + " " + start;

    else
      return "";
  }

  /**
   * Recursively create a simple alphabet pattern, starting the provided character, and moving
   * forward to the end of the alphabet, and then backward again to the provided letter, separating
   * each letter with a space.
   * 
   * @param start stores the character from which the pattern would begin
   * @return the desired mirror pattern
   * @throws IllegalArgumentException when the character from input is not an UpperCase Character
   */
  public static String mirrorZ(char start) throws IllegalArgumentException {
    if (!Character.isUpperCase(start)) {
      throw new IllegalArgumentException(
          "Invalid Input: Character entered as input is in Lower Case."
              + " The requirement here is Upper Case");
    }
    if (start != 'Z' && start < 90)
      return start + " " + mirrorZ((char) (start + 1)) + " " + start;
    else if (start == 'Z')
      return "" + start;
    else
      return "";
  }

  /**
   * Recursively create an alphabet pattern, starting at the provided character, and moving forward
   * and back to the end of the alphabet by steps of size step .
   * 
   * @param start stores the character from which the pattern would begin
   * @param step  stores the number of characters to skip to create this special pattern
   * @return the desired mirror pattern
   * @throws IllegalArgumentException when the character from input is not an UpperCase Character or
   *                                  the step size is less than 1
   */
  public static String mirrorZ(char start, int step) throws IllegalArgumentException {
    if (!Character.isUpperCase(start) || step < 1) {
      throw new IllegalArgumentException(
          "Invalid Input: Character entered is in Lower Case or the step size is less than 1");
    }
    if (start == 'Z')
      return "" + start;
    else if ((start + step) > 90)
      return start + " " + start;
    else if (start != 'Z' && start < 90)
      return start + " " + mirrorZ((char) (start + step), step) + " " + start;
    else
      return "";
  }

}
