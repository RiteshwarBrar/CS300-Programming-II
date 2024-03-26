//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SimpleBag class represents a program with more complex methods with respect to CleverBag
// Course: CS 300 Fall 2020
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class SimpleBag {
  protected String[] data;
  protected Random random;

  /**
   * Constructor for class SimpleBag which initializes the values for data and random
   * 
   * @param seed this is an integer value used as a seed for the object of Random class
   */
  public SimpleBag(int seed) {
    this.data = new String[80000];
    random = new Random(seed);
  }

  /**
   * loadData method reads a file and store each word at a separate index in a String array
   * Complexity: O(N^2)
   * 
   * @param f is the name of the file object
   */
  public void loadData(File f) {
    try {
      Scanner sc = new Scanner(f);
      sc.nextLine();
      // skips the first line of the text file as that is the number of words and shouldn't be
      // considered a word itself
      while (sc.hasNext()) {
        for (int i = data.length - 2; i >= 0; i--) {
          data[i + 1] = data[i];
        }
        // first the data shifts to the right then the value is stored at index 0
        data[0] = sc.next();
      }
      sc.close();
      // Scanner closed
    } catch (Exception e) {
      return;
    }
  }


  /**
   * This method removes a random string in the data array and replaces the removed value
   * Complexity: O(N)
   * 
   * @return it returns the removed value
   */
  public String removeRandom() {
    if (data == null) {
      return null;
    } else {
      int ctr = 0;
      // counts the number of words
      String temp;
      // stores the String to return
      int x;
      // stores the random index at which the word is removed.
      for (int i = 0; i < data.length; i++) {
        if (data[i] != null)
          ctr++;
      }
      if (ctr == 0)
        return null;
      x = random.nextInt(ctr);
      temp = data[x];
      data[x] = null;
      for (int i = x; i < data.length - 1; i++) {
        data[i] = data[i + 1];
        if (i == data.length - 2)
          data[i + 1] = null;
        // when the loop reaches the end, to avoid repetition the last element is set as null
      }
      return temp;
    }
  }
}
