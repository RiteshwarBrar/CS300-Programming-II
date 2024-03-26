//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Test Class to verify the working of InventoryList Class
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
import java.util.NoSuchElementException;

/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class InventorySystemTester {
  /**
   * Checks the correctness of the getters and setters in LinkedBox Class
   * 
   * @return true if tests pass successfully
   */
  public static boolean testLinkedBox() {

    Box box = new Box(Color.BLUE);
    LinkedBox node1 = new LinkedBox(box);
    LinkedBox node2 = new LinkedBox(box);
    if (!(node1.getBox().toString().equals("BLUE 1"))) {
      box.restartNextInventoryNumber();
      return false;
    }
    node1.setNext​(node2);
    if (!(node1.getNext().equals(node2))) {
      box.restartNextInventoryNumber();
      return false;
    }
    box.restartNextInventoryNumber();
    return true;
  }


  /**
   * Checks for the correctness of the InventoryList.clear() method
   * 
   * @return true if tests pass successfully
   */
  public static boolean testClear() {
    InventoryList list = new InventoryList();
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 2 at the
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    list.clear();
    if (!list.isEmpty()) {
      return false;
    }
    return true;

  }

  /**
   * Checks for the correctness of the InventoryList.addYellow(), InventoryList.addBlue(), and
   * InventoryList.addBrown() methods
   * 
   * @return true if tests pass successfully
   */
  public static boolean testAddBoxes() {
    InventoryList list = new InventoryList();
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 2 at the
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 4 at the end of the list
    if (!list.get​(3).getColor().equals(Color.BROWN)) {
      list.clear();
      return false;
    }
    if (!list.get​(2).getColor().equals(Color.BLUE)) {
      list.clear();
      return false;
    }
    if (!list.get​(0).getColor().equals(Color.YELLOW)) {
      list.clear();
      return false;
    }
    list.clear();
    return true;
  }

  /**
   * Checks for the correctness of the InventoryList.removeBox() InventoryList.removeYellow(), and
   * InventoryList.remove Brown() methods
   * 
   * @return true if tests pass successfully
   */
  public static boolean testRemoveBoxes() {
    InventoryList list = new InventoryList();
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 2 at the
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 4 at the end of the list
    if (!list.removeYellow().getColor().equals(Color.YELLOW)) {
      list.clear();
      return false;
    }
    if (!list.removeBox​(1).getColor().equals(Color.BLUE)) {
      list.clear();
      return false;
    }
    if (!list.removeBrown().getColor().equals(Color.BROWN)) {
      list.clear();
      return false;
    }
    list.clear();
    return true;

  }

  /**
   * Checks for the correctness of the InventoryList.get() method
   * 
   * @return true if tests pass successfully
   */
  public static boolean testGetBoxes() {
    InventoryList list = new InventoryList();
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 2 at the
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 4 at the end of the list
    if (!list.get​(0).getColor().equals(Color.YELLOW)) {
      list.clear();
      return false;
    }
    if (!list.get​(3).getColor().equals(Color.BROWN)) {
      list.clear();
      return false;
    }
    if (!list.get​(2).getColor().equals(Color.BLUE)) {
      list.clear();
      return false;
    }
    list.clear();
    return true;
  }

  /**
   * A test suite method to run all your test methods
   * 
   * @return true if tests pass successfully
   */
  public static boolean runAllTests() {
    if (testLinkedBox() && testClear() && testAddBoxes() && testRemoveBoxes() && testGetBoxes()) {
      return true;
    } else
      return false;
  }

  /**
   * Main method to call the test method and print results
   * 
   * @param args not in use
   */
  public static void main(String[] args) {
    if (runAllTests())
      System.out.println("All tests passed");

    demo();
  }

  /**
   * Helper method to display the size and the count of different boxes stored in a list of boxes
   * 
   * @param list a reference to an InventoryList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(InventoryList list) {
    System.out.println("  Size: " + list.size() + ", yellowCount: " + list.getYellowCount()
        + ", blueCount: " + list.getBlueCount() + ", brownCount: " + list.getBrownCount());
  }

  /**
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list.toString()); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add a blue box to an empty list
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints list's content
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints list's content
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints list's content
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints list's content
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add more boxes to list and display its contents
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 7 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBlue​(new Box(Color.BLUE)); // adds BLUE 8
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints list's content
    list.removeBox​(3); // removes BLUE 3 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    try {
      list.removeBox​(25); // tries to remove box #25
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // remove all yellow boxes
    while (list.getYellowCount() != 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown​(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(8); // removes BLUE 8 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addYellow​(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
  }
}


