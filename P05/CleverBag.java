//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: CleverBag class represents a program with less complex methods with respect to SimpleBag
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
import java.util.Scanner;

/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class CleverBag extends SimpleBag {
  private int size;

  /**
   * Constructor for class cleverBag which initializes the values for data and random by call the
   * constructor of the super class and initializes the size variable
   * 
   * @param seed this is an integer value used as a seed for the object of Random class
   */
  public CleverBag(int seed) {
    super(seed);
    size = 0;
  }


  /**
   * loadData method reads a file and store each word at a separate index in a String array
   * Complexity: O(N)
   * 
   * @param f is the name of the file object
   */
  @Override
  public void loadData(File f) {
    try {
      Scanner sc = new Scanner(f);
      sc.nextLine();
      // skips the first line of the text file as that is the number of words and shouldn't be
      // considered a word itself
      while (sc.hasNext()) {
        data[size] = sc.next();
        // words are added one by one at the end of the existing array
        size++;
      }
      sc.close();
    } catch (Exception e) {
      return;
    }
  }

  /**
   * This method removes a random string in the data array and replaces the removed value
   * Complexity: O(1)
   * 
   * @return it returns the removed value
   */
  @Override
  public String removeRandom() {
    if (data == null || size < 1) {
      return null;
    } else {
      String temp;
      int x;
      x = random.nextInt(size);
      temp = data[x];
      data[x] = data[size - 1];
      // the word removed is replaced by the last word in the array
      size--;
      return temp;
    }
  }


}
