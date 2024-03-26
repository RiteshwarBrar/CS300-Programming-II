//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Tests for Self Checkout Kiosk
// Course: CS 300 Fall 2020
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class serves as a test platform for various methods of the SelfCheckoutKiosk class
 */
public class SelfCheckoutKioskTester {

  /**
   * Checks whether SelfCheckoutKisok.getItemName() and SelfCheckoutKisok.getItemPrice() method work
   * as expected.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testItemNameAndPriceGetterMethods() {
    // consider all identifiers values as input arguments
    // GROCERY_ITEMS array is a perfect size array. So, its elements are stored
    // in the range of indexes from 0 .. GROCERY_ITEMS.length -1
    for (int i = 0; i < SelfCheckoutKiosk.GROCERY_ITEMS.length; i++) {
      // check first for the correctness of the getItemName(i) method
      if (!SelfCheckoutKiosk.getItemName(i).equals(SelfCheckoutKiosk.GROCERY_ITEMS[i][0])) {
        System.out.println("Problem detected: Called your getItemName() method with input value "
            + i + ". But it did not return the expected output.");
        return false;
      }
      // Check for the correctness of the getItemPrice(i) method
      // Notice that GROCERY_ITEMS[i][1] is of type String starting with "$" followed
      // by the double price value.
      double expectedPriceOutput =
          Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[i][1].substring(1).trim());
      // Note that we do not use the == operator to check whether two floating-point
      // numbers
      // (double or float) in java are equal. Two variables a and b of type double are
      // equal
      // if the absolute value of their difference is less or equal to a small
      // threshold epsilon.
      // For instance, if Math.abs(a - b) <= 0.001, then a equals b
      if (Math.abs((SelfCheckoutKiosk.getItemPrice(i) - expectedPriceOutput)) > 0.001) {
        // We recommend that you print a descriptive error message before
        // returning false
        System.out.println("Problem detected: Called the getItemPrice() method input value " + i
            + ". But it did not return the expected output.");
        return false;
      }
    }
    return true; // No defect detected -> The implementation passes this test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.addItemToBaggingArea() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToBaggingArea() {
    // Create an empty bagging area
    String[] items = new String[10];
    int size = 0;

    // Define the test scenarios:

    // (1) Add one item to an empty bagging area
    // try to add an apple (id: 0) to the bagging area
    size = SelfCheckoutKiosk.addItemToBaggingArea(0, items, size);
    if (size != 1) {
      System.out.println("Problem detected: Tried to add one item to an empty, "
          + "bagging area. The returned size must be 1. But your addItemToBaggingArea "
          + "method returned a different output.");
      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(0))) {
      // notice here the importance of checking for the correctness of your
      // getItemName()
      // method before calling it above
      System.out.println("Problem detected: Tried to add only one item to an empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (2) Consider a non-empty bagging area
    items = new String[] {"Milk", "Chocolate", "Onion", null, null, null, null};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(10, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to add only one item to an non-empty, "
          + "bagging area. The size must be incremented after the method returns. But "
          + "it was not the case");
      return false;
    }
    if (!items[3].equals(SelfCheckoutKiosk.getItemName(10))) {
      System.out.println("Problem detected: Tried to add one item to an non-empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (3) Consider adding an item to a full bagging are
    items = new String[] {"Pizza", "Eggs", "Apple"};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(2, items, size);
    // Check that the returned size is correct (must be 3), and that no
    // changes have been made to the content of items array {"Pizza", "Eggs",
    // "Apple"}
    if (size != 3) {
      System.out.println("Problem detected: Tried to add one item to a full "
          + "bagging area. The size must remain the same after the method returns. But "
          + "it was not the case");
      return false;
    }
    if (!items[2].equals(SelfCheckoutKiosk.getItemName(0))) {
      System.out.println("Problem detected: Tried to add one item to a full "
          + "bagging area. But there was supposed to be no change made to the "
          + "contents of the items array.");
      return false;
    }
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.count() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCount() {
    String[] items = new String[] {"Milk", "Chocolate", "Onion", null, null, null, null};
    int size = 3;
    String item = "beef";
    int count;
    // (1)testing a bagging area (defined by the items array and its size)
    // which contains 0 occurrences of the item named beef
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 0) {
      System.out.println("Problem detected: Tried to count the occurrence of an item "
          + "that was not in the bagging area. The method was supposed to return 0"
          + " but it failed to do so.");
      return false;
    }
    // (2) a bagging area which contains at least 4 items and only one occurrence
    // of the item to count
    items = new String[] {"Milk", "Chocolate", "Onion", "Chicken", null, null, null};
    size = 4;
    item = "Onion";
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 1) {
      System.out.println("Problem detected: Tried to count the occurrence of an item "
          + "that had only one occurrence in the bagging area. The method was supposed to return 1"
          + " but it failed to do so.");
      return false;
    }
    // (3) a bagging area which contains at least 5 items
    // and 2 occurrences of the item to count.
    items = new String[] {"Milk", "Chocolate", "Onion", "Chicken", "Milk", "Cookie", null};
    size = 5;
    item = "Milk";
    count = SelfCheckoutKiosk.count(item, items, size);
    if (count != 2) {
      System.out.println("Problem detected: Tried to count the occurrence of an item "
          + "that had two occurrences in the bagging area. The method was supposed to return 2"
          + " but it failed to do so.");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.indexOf() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIndexOf() {
    String[] items = new String[] {"Milk", "Chocolate", "Onion", "Beef", null, null, null};
    int size = 4;
    String item = "onion";
    // (1)The case where the items array contains at least one match
    // with the item to find
    int index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != 2) {
      System.out.println("Problem detected: Tried to find the index of the first "
          + "occurrence of an item in the bagging area. The method was supposed to return 2"
          + " but it failed to do so.");
      return false;
    }
    // (2)the case when the item was not stored in
    // the array and the expected output is -1
    items = new String[] {"Pepper", "Chocolate", "Cereal", "Beef", "Grape", null, null};
    size = 5;
    item = "onion";
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != -1) {
      System.out.println("Problem detected: Tried to find the index of the first "
          + "occurrence of an item that is not in the bagging area. The method "
          + "was supposed to return -1 but it failed to do so.");
      return false;
    }
    // (3)The case when the item existed multiple times in the bagging area
    // the expected output is the first occurrence
    items = new String[] {"Pepper", "Grape", "Cereal", "Beef", "Grape", "Chocolate", null};
    size = 6;
    item = "Grape";
    index = SelfCheckoutKiosk.indexOf(item, items, size);
    if (index != 1) {
      System.out.println("Problem detected: Tried to find the index of the first "
          + "occurrence of an item that is present multiple times in the bagging area."
          + " The method was supposed to return 1 but it failed to do so.");
      return false;
    }

    return true;
  }

  /**
   * Checks that when only one attempt to remove an item stored in the bagging area is made, only
   * one occurrence of that item is removed from the array of items, that the returned size is
   * correct, and that the items array contains all the other items.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    String[] items = new String[] {"Milk", "Chocolate", "Onion", "Milk", null, null, null};
    int size = 4;
    String item = "milk";
    int count;
    // (1)testing a bagging area (defined by the items array and its size)
    // which contains 0 occurrences of the item named beef
    size = SelfCheckoutKiosk.remove(item, items, size);
    count = SelfCheckoutKiosk.count(item, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to remove an item from the bagging area."
          + " The method was supposed to return 3 but it failed to decrease the size"
          + " after removing one occurence of an item.");
      return false;
    }
    if (count != 1) {
      System.out.println("Problem detected: Tried to remove an item from the bagging area."
          + "The method was supposed to remove an occurrence of the given item but it"
          + " failed to do so.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether getSubTotalPrice method returns the correct output
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetSubTotalPrice() {
    String[] items =
        new String[] {"Milk", "Chocolate", "Onion", "Milk", "Chocolate", "Cereal", "Grape"};
    int size = 7;
    double expectedTotal = 17.33;
    if (Math.abs((SelfCheckoutKiosk.getSubTotalPrice(items, size) - expectedTotal)) > 0.001) {
      System.out.println("Problem detected: Called getSubTotal() to calculate the total price of "
          + "items in the bagging area exclusive of tax. The subtotal calculated by the method"
          + " is not similar to what was expected.");
      return false;
    }
    items = new String[] {null, null, null, null};
    size = 0;
    expectedTotal = 0.00;
    if (Math.abs((SelfCheckoutKiosk.getSubTotalPrice(items, size) - expectedTotal)) > 0.001) {
      System.out.println("Problem detected: Called getSubTotal() to calculate the total price of "
          + "an empty bagging area. The subtotal calculated by the method is not similar to what"
          + " was expected.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether getUniqueCheckedOutput functioning is correct
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetUniqueCheckedOutItems() {
    String[] items =
        new String[] {"Milk", "Chocolate", "Onion", "Milk", "Chocolate", "Cereal", "Grape"};
    int size = 7;
    String[] itemSet = new String[items.length];
    int setSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemSet);
    if (setSize != 5) {
      System.out.println("Problem detected: Called getUniqueItems() to calculate the number of "
          + "unique occurrences in the bagging area. The number of unique items calculated by the "
          + "method is not similar to what was expected.");
      return false;
    }
    // if only one item is repeated in the array
    items = new String[] {"Milk", "Milk", "Milk", "Milk", "Milk"};
    size = 5;
    itemSet = new String[items.length];
    setSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, size, itemSet);
    if (setSize != 1) {
      System.out.println("Problem detected: Called getUniqueItems() to calculate the number of "
          + "unique occurrences in the bagging area. The number of unique items calculated by the "
          + "method is not similar to what was expected.");
      return false;
    }
    return true;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out
        .println("tesItemNameAndPriceGetterMethods(): " + testItemNameAndPriceGetterMethods());
    System.out.println("testAddItemToBaggingArea(): " + testAddItemToBaggingArea());
    System.out.println("testCount(): " + testCount());
    System.out.println("testIndexOf(): " + testIndexOf());
    System.out.println("testRemove(): " + testRemove());
    System.out.println("testGetSubTotalPrice(): " + testGetSubTotalPrice());
    System.out.println("testGetUniqueCheckedOutItems(): " + testGetUniqueCheckedOutItems());
  }
}
