//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is a program for checking the functionality of the Palindrome class by using various
//////////////// test methods
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
public class PalindromeTester {
  /**
   * Test method for the mirrorA(char) method
   * 
   * @return true if all tests are passed and false otherwise
   */
  public static boolean testMirrorA() {
    boolean cond = false;
    if (!Palindrome.mirrorA('E').equals("E D C B A B C D E")) {
      return false;
    }
    if (!Palindrome.mirrorA('A').equals("A"))
      return false;
    try {
      Palindrome.mirrorA('a');
    } catch (IllegalArgumentException e) {
      cond = true;
    }

    return cond;
  }

  /**
   * Test method for the mirrorA(char, int) method
   * 
   * @return true if all tests are passed and false otherwise
   */
  public static boolean testMirrorAStep() {
    boolean cond = false;
    try {
      if (!Palindrome.mirrorA('E', 2).equals("E C A C E"))
        return false;
      if (!Palindrome.mirrorA('G', 3).equals("G D A D G"))
        return false;
      if (!Palindrome.mirrorA('A', 1).equals("A"))
        return false;
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }

    try {
      Palindrome.mirrorA('a', 1);
    } catch (IllegalArgumentException e) {
      cond = true;
    }
    if (!cond) {

      return false;
    }

    cond = false;// resets the value for cond to false so that if the next exception is not the
    // thrown then the method works correctly i.e. return false
    try {
      Palindrome.mirrorA('A', -1);
    } catch (IllegalArgumentException e) {
      cond = true;
    }
    if (!cond)
      return false;
    return true;
  }

  /**
   * Test method for the mirrorZ(char) method
   * 
   * @return true if all tests are passed and false otherwise
   */
  public static boolean testMirrorZ() {
    boolean cond = false;
    if (!Palindrome.mirrorZ('V').equals("V W X Y Z Y X W V"))
      return false;
    if (!Palindrome.mirrorZ('Z').equals("Z"))
      return false;
    try {
      Palindrome.mirrorZ('z');
    } catch (IllegalArgumentException e) {
      cond = true;
    }
    return cond;
  }

  /**
   * Test method for the mirrorZ(char, int) method
   * 
   * @return true if all tests are passed and false otherwise
   */
  public static boolean testMirrorZStep() {
    boolean cond = false;
    try {
      if (!Palindrome.mirrorZ('V', 2).equals("V X Z X V"))
        return false;
      if (!Palindrome.mirrorZ('V', 3).equals("V Y Y V"))
        return false;
      if (!Palindrome.mirrorZ('Z', 1).equals("Z"))
        return false;
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    try {
      Palindrome.mirrorZ('z', 1);
    } catch (IllegalArgumentException e) {
      cond = true;
    }
    if (!cond)
      return false;

    cond = false;// resets the value for cond to false so that if the next exception is not the
    // thrown then the method works correctly i.e. return false
    try {
      Palindrome.mirrorZ('Z', 0);
    } catch (IllegalArgumentException e) {
      cond = true;
    }
    if (!cond)
      return false;
    return true;
  }

  /**
   * Calls all the test methods and returns true if all the tests of each method are passed
   * 
   * @return true if all test methods return true otherwise false
   */
  public static boolean runAllTests() {
    if (testMirrorA() && testMirrorAStep() && testMirrorZ() && testMirrorZStep())
      return true;
    else
      return false;
  }

  /**
   * main method that calls runAllTests() only
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
