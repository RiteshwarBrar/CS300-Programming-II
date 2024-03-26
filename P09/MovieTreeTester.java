//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This is a test class for the MovieTree class and it checks the implementation of the
//////////////// MovieTree class
// Course: CS 300 Fall 2020
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer:Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    {
      MovieTree test = new MovieTree();
      if (test.size() != 0 || !test.isEmpty() || !test.toString().equals(""))
        return false;
    } // empty MovieTree
    {
      // adding one movie
      MovieTree test = new MovieTree();
      if (!test.addMovie(new Movie(2016, 6.0, "Scavengers: Infinity War")) || test.isEmpty()
          || test.size() != 1 || !test.toString()
              .equals("[(Year: 2016) (Rate: 6.0) (Name: Scavengers: Infinity War)]" + "\n"))
        return false;
      // adding another (smaller) movie
      if (!test.addMovie(new Movie(2010, 6.0, "S")) || test.isEmpty() || test.size() != 2
          || !test.toString().equals("[(Year: 2010) (Rate: 6.0) (Name: S)]" + "\n"
              + "[(Year: 2016) (Rate: 6.0) (Name: Scavengers: Infinity War)]" + "\n"))
        return false;
      // adding another(greater) movie
      if (!test.addMovie(new Movie(2018, 6.0, "A")) || test.isEmpty() || test.size() != 3
          || !test.toString()
              .equals("[(Year: 2010) (Rate: 6.0) (Name: S)]" + "\n"
                  + "[(Year: 2016) (Rate: 6.0) (Name: Scavengers: Infinity War)]" + "\n"
                  + "[(Year: 2018) (Rate: 6.0) (Name: A)]" + "\n"))
        return false;
      // adding two more movies
      if (!test.addMovie(new Movie(2012, 6.0, "B")) || test.isEmpty() || test.size() != 4
          || !test.toString()
              .equals("[(Year: 2010) (Rate: 6.0) (Name: S)]" + "\n"
                  + "[(Year: 2012) (Rate: 6.0) (Name: B)]" + "\n"
                  + "[(Year: 2016) (Rate: 6.0) (Name: Scavengers: Infinity War)]" + "\n"
                  + "[(Year: 2018) (Rate: 6.0) (Name: A)]" + "\n"))
        return false;
      if (!test.addMovie(new Movie(2019, 6.0, "C")) || test.isEmpty() || test.size() != 5
          || !test.toString()
              .equals("[(Year: 2010) (Rate: 6.0) (Name: S)]" + "\n"
                  + "[(Year: 2012) (Rate: 6.0) (Name: B)]" + "\n"
                  + "[(Year: 2016) (Rate: 6.0) (Name: Scavengers: Infinity War)]" + "\n"
                  + "[(Year: 2018) (Rate: 6.0) (Name: A)]" + "\n"
                  + "[(Year: 2019) (Rate: 6.0) (Name: C)]" + "\n"))
        return false;
      // adding an already existing movie
      if (test.addMovie(new Movie(2019, 6.0, "C")) || test.size() != 5)
        return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
   * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    // test on an empty MovieTree
    {
      MovieTree test = new MovieTree();
      if (test.contains(2000, 0.0, "AAA"))
        return false;
    }
    // at least 5 movies and height 3.
    {
      MovieTree test = new MovieTree();
      test.addMovie(new Movie(2016, 6.0, "A"));
      test.addMovie(new Movie(2010, 6.0, "B"));
      test.addMovie(new Movie(2018, 6.0, "C"));
      test.addMovie(new Movie(2014, 6.0, "D"));
      test.addMovie(new Movie(2009, 6.0, "E"));
      test.addMovie(new Movie(2019, 6.0, "F"));
      if (!test.contains(2016, 6.0, "A"))// Searching for the root of the tree
        return false;
      if (!test.contains(2018, 6.0, "C"))// Searching for a node on the right subtree of the root
        return false;
      if (!test.contains(2014, 6.0, "D"))// Searching for a node on the left subtree of the root at
                                         // a different level
        return false;
      if (test.contains(2001, 6.0, "C"))// Searching for a non existing node with different year
        return false;
      if (test.contains(2016, 6.0, "C"))// Searching for a non existing node with different name
        return false;
      if (test.contains(2016, 6.1, "A"))// Searching for a non existing node with different rating
        return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {

    MovieTree test = new MovieTree();
    if (test.height() != 0)// test on an empty MovieTree
      return false;
    test.addMovie(new Movie(2016, 6.0, "A"));
    if (test.height() != 1)// MovieTree with only one element
      return false;
    test.addMovie(new Movie(2014, 6.0, "A"));
    test.addMovie(new Movie(2018, 6.0, "A"));
    test.addMovie(new Movie(2017, 6.0, "A"));
    test.addMovie(new Movie(2020, 6.0, "A"));
    test.addMovie(new Movie(2019, 6.0, "A"));
    test.addMovie(new Movie(2015, 6.0, "A"));
    if (test.height() != 4)// MovieTree with only one element
      return false;
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    MovieTree test = new MovieTree();
    try {
      if (test.getBestMovie() != null) {// test on an empty MovieTree
        return false;
      }
    } catch (NoSuchElementException e) {
      return false;
    }

    test.addMovie(new Movie(2014, 6.0, "A"));
    test.addMovie(new Movie(2018, 6.0, "A"));
    test.addMovie(new Movie(2020, 6.0, "A"));
    test.addMovie(new Movie(2017, 6.0, "A"));
    test.addMovie(new Movie(2020, 7.0, "A"));
    test.addMovie(new Movie(2019, 6.0, "A"));
    test.addMovie(new Movie(2020, 7.0, "ABC"));
    test.addMovie(new Movie(2015, 6.0, "A"));
    try {
      if (!test.getBestMovie().equals(new Movie(2020, 7.0, "ABC"))) {// test for the best movie
        return false;
      }
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when
   * called on a non empty movie tree with one match, and two matches and more. Vary your search
   * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
   * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
   * tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    boolean result = false;
    {
      try {

        MovieTree test1 = new MovieTree();
        test1.lookup(2018, 8.8);
      } catch (NoSuchElementException e) {
        result = true;
      }
      if (!result) {
        return false;
      }
    } // tests an empty tree
    {
      MovieTree test2 = new MovieTree();
      test2.addMovie(new Movie(2016, 6.0, "Avengers: Infinity War"));
      test2.addMovie(new Movie(2018, 5.0, "Avengers: Infinity War"));
      test2.addMovie(new Movie(2017, 4.0, "Avengers: Infinity War"));
      test2.addMovie(new Movie(2018, 3.0, "Aveng Infinity War"));
      test2.addMovie(new Movie(2018, 1.0, "AvengInfinity War"));
      test2.addMovie(new Movie(2011, 2.0, "Ave Infinity War"));
      for (int i = 0; i < 2; i++) {
        if (test2.lookup(2018, 3.0).get(i).getYear() != 2018
            || !(test2.lookup(2018, 3.0).get(i).getRating() >= 3.0))
          result = false;
      }
      if (!result) {
        return false;
      }
    } // tests a tree with 2 matches
    result = false;
    {
      try {
        MovieTree test2 = new MovieTree();
        test2.addMovie(new Movie(2018, 6.0, "Avengers: Infinity War"));
        test2.addMovie(new Movie(2018, 5.0, "Avengers: Infinity War"));
        test2.addMovie(new Movie(2018, 4.0, "Avengers: Infinity War"));
        test2.addMovie(new Movie(2016, 3.0, "Aveng Infinity War"));
        test2.addMovie(new Movie(2006, 1.0, "AvengInfinity War"));
        test2.addMovie(new Movie(2011, 2.0, "Ave Infinity War"));
        test2.lookup(2017, 8.8);
      } catch (NoSuchElementException e) {
        result = true;
      }
    } // tests a tree for no matches
    return result;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    if (testLookup() && testAddMovieToStringSize() && testContains() && testHeight()
        && testGetBestMovie()) {
      System.out.println("Test(s) passed");
    } else
      System.out.println("Test(s) failed");
  }

}
