//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Benchmark class compare the complexity of SimpleBag and CleverBag class
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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class Benchmark {
  /**
   * Compare the time taken by the two classes to execute their respective loadData methods
   * 
   * @param f the object of the File class
   * @param s the object of the SimpleBag class
   * @param c the object of the CleverBag class
   * @return returns the time taken by SimpleBag and CleverBag to execute loadData method
   */
  public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
    long simpleBagLoadTime = System.currentTimeMillis();
    s.loadData(f);
    simpleBagLoadTime = System.currentTimeMillis() - simpleBagLoadTime;
    // gives us the time passed while the loadData method was called
    long cleverBagLoadTime = System.currentTimeMillis();
    c.loadData(f);
    cleverBagLoadTime = System.currentTimeMillis() - cleverBagLoadTime;
    return "load:\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
  }

  /**
   * Compare the time taken by the two classes to execute their respective removeRandom methods for
   * multiple times
   * 
   * @param n number of random words to be removed
   * @param s the object of the SimpleBag class
   * @param c the object of the CleverBag class
   * @return returns the time taken by SimpleBag and CleverBag to execute loadData method
   */
  public static String compareRemove(int n, SimpleBag s, CleverBag c) {
    long simpleBagRemoveTime = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      s.removeRandom();
    }
    simpleBagRemoveTime = System.currentTimeMillis() - simpleBagRemoveTime;
    long cleverBagRemoveTime = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      c.removeRandom();
    }
    cleverBagRemoveTime = System.currentTimeMillis() - cleverBagRemoveTime;
    return n + "\t" + simpleBagRemoveTime + "\t" + cleverBagRemoveTime + "\n";
  }

  /**
   * This creates an output to a .txt file which shows the time taken by the two classes to execute
   * similar functions in a particular format.
   * 
   * @param in      the object of the File which is to be read
   * @param out     the object of the file on which the output is stored.
   * @param nValues an array of values for the number of times the removeRandom method is to be
   *                tested for both the classes
   */
  public static void createResultsFile(File in, File out, int[] nValues) {
    SimpleBag os = new SimpleBag(0);
    CleverBag oc = new CleverBag(0);
    try {
      FileWriter writer = new FileWriter(out);
      writer.write(compareLoadData(in, os, oc));
      for (int i = 0; i < nValues.length; i++) {
        writer.write(compareRemove(nValues[i], os, oc));
      }
      writer.close();
      // FileWriter closed
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * The main method which tests whether no exception is thrown and the program runs correctly
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    File in = new File("frank.txt");
    File out = new File("output.txt");

    int[] nValues = new int[] {10, 100, 1000, 10000};
    createResultsFile(in, out, nValues);
    Scanner sc;
    String test = "";
    try {
      sc = new Scanner(out);
      while (sc.hasNextLine()) {
        test = test + sc.nextLine() + "\n";
      }
      System.out.println("test passed: No exceptions thrown");
      // test passed as the program runs smoothly
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(test);
  }
}
