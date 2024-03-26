//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class is a test class for the OrderPriorityQueue class and tests the correctness of
//////////////// the implementation of all the major methods in the OrderPriorityQueue class.
//
// Author: Riteshwar Singh Brar, Mouna Ayari Ben Hadj Kacem and Hobbes LeGault
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem or Hobbes LeGault
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
 * OrderPriorityQueue.
 * 
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 */
public class OrderPriorityQueueTester {

  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and verify that it is empty (2) add a
   * new Order to the queue and verify that it is NOT empty (3) remove that Order from the queue and
   * verify that it is empty again
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    Order.resetIDGenerator();
    OrderPriorityQueue test1 = new OrderPriorityQueue(10);
    if (!test1.isEmpty())
      return false;
    Order first = new Order("Pancakes", 10);
    test1.insert(first);
    if (test1.isEmpty())
      return false;
    test1.removeBest();
    if (!test1.isEmpty())
      return false;
    test1.insert(first);
    if (test1.isEmpty())
      return false;
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue and add a single order with a large
   * prepTime to it (2) use the OrderPriorityQueue toString method to verify that the queue's
   * internal structure is a valid heap (3) add at least three more orders with DECREASING prepTimes
   * to the queue and repeat step 2.
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    Order.resetIDGenerator();
    OrderPriorityQueue test1 = new OrderPriorityQueue(10);
    Order first = new Order("Chicken Platter", 45);
    test1.insert(first);
    if (!test1.toString().equals("1001(45)"))
      return false;
    Order second = new Order("Shrimp Platter", 40);
    Order third = new Order("Sea Platter", 35);
    Order fourth = new Order("Beef Platter", 30);
    Order fifth = new Order("Fish Platter", 25);
    test1.insert(second);
    test1.insert(third);
    test1.insert(fourth);
    test1.insert(fifth);
    if (!test1.toString().equals("1001(45), 1002(40), 1003(35), 1004(30), 1005(25)"))
      return false;
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create an array of at least four Orders that represents a valid heap
   * (2) add a fifth order at the next available index that is NOT in a valid heap position (3) pass
   * this array to OrderPriorityQueue.percolateUp() (4) verify that the resulting array is a valid
   * heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    Order.resetIDGenerator();
    Order first = new Order("C", 45);
    Order second = new Order("S", 40);
    Order third = new Order("A", 35);
    Order fourth = new Order("B", 30);
    Order fifth = new Order("F", 25);
    Order sixth = new Order("K", 44);
    Order[] queue = new Order[10];
    queue[0] = first;
    queue[1] = second;
    queue[2] = third;
    queue[3] = fourth;
    queue[4] = fifth;
    queue[5] = sixth;
    OrderPriorityQueue.percolateUp(queue, 5);
    String array = "";
    for (int i = 0; i < 6; i++) {
      array = array + queue[i];
      if (i < 5)
        array = array + ", ";
    }
    if (!array.equals(
        "1001: C (45), 1002: S (40), 1006: K (44), 1004: B (30), 1005: F (25), 1003: A (35)"))
      return false;
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue OUT of order (2) use the OrderPriorityQueue toString method
   * to verify that the queue's internal structure is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    Order.resetIDGenerator();
    OrderPriorityQueue test1 = new OrderPriorityQueue(10);
    Order first = new Order("Chicken Platter", 25);
    Order second = new Order("Shrimp Platter", 40);
    Order third = new Order("Sea Platter", 35);
    Order fourth = new Order("Beef Platter", 26);
    Order fifth = new Order("Fish Platter", 45);
    Order sixth = new Order("Pancakes", 36);
    test1.insert(first);
    test1.insert(second);
    test1.insert(third);
    test1.insert(fourth);
    test1.insert(fifth);
    test1.insert(sixth);
    if (!test1.toString().equals("1005(45), 1002(40), 1006(36), 1001(25), 1004(26), 1003(35)"))
      return false;
    return true;
  }

  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least: (1) create an array of at least five Orders where the Order at index 0 is
   * NOT in valid heap position (2) pass this array to OrderPriorityQueue.percolateDown() (3) verify
   * that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {
    Order.resetIDGenerator();
    Order first = new Order("C", 4);
    Order second = new Order("S", 40);
    Order third = new Order("A", 35);
    Order fourth = new Order("B", 25);
    Order fifth = new Order("F", 30);
    Order sixth = new Order("K", 20);
    Order[] queue = new Order[10];
    queue[0] = first;
    queue[1] = second;
    queue[2] = third;
    queue[3] = fourth;
    queue[4] = fifth;
    queue[5] = sixth;
    OrderPriorityQueue.percolateDown(queue, 0, 6);
    String array = "";
    for (int i = 0; i < 6; i++) {
      array = array + queue[i];
      if (i < 5)
        array = array + ", ";
    }
    if (!array.equals(
        "1002: S (40), 1005: F (30), 1003: A (35), 1004: B (25), 1001: C (4), 1006: K (20)"))
      return false;
    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with at least 6 orders of varying
   * prepTimes, adding them to the queue in whatever order you like (2) remove all but one of the
   * orders, verifying that each order has a SHORTER prepTime than the previously-removed order (3)
   * peek to see that the only order left is the one with the SHORTEST prepTime (4) check isEmpty to
   * verify that the queue has NOT been emptied (5) remove the last order and check isEmpty to
   * verify that the queue HAS been emptied
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {
    Order.resetIDGenerator();
    OrderPriorityQueue test1 = new OrderPriorityQueue(10);
    Order first = new Order("Chicken Platter", 25);
    Order second = new Order("Shrimp Platter", 40);
    Order third = new Order("Sea Platter", 35);
    Order fourth = new Order("Beef Platter", 26);
    Order fifth = new Order("Fish Platter", 45);
    Order sixth = new Order("Pancakes", 36);
    test1.insert(first);
    test1.insert(second);
    test1.insert(third);
    test1.insert(fourth);
    test1.insert(fifth);
    test1.insert(sixth);
    Order prev;
    if (!test1.peekBest().equals(test1.peekBest()))
      return false;
    for (int i = 0; i < 5; i++) {
      prev = test1.removeBest();
      if (prev.compareTo(test1.peekBest()) < 0)
        return false;
    }
    if (test1.peekBest().getPrepTime() != 25)
      return false;
    if (test1.isEmpty())
      return false;
    test1.removeBest();
    if (!test1.isEmpty())
      return false;
    return true;
  }

  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * 
   * You should, at least: (1) create a new OrderPriorityQueue with an invalid capacity argument,
   * and verify that the correct exception is thrown (2) call peekBest() on an OrderPriorityQueue
   * with an invalid state for peeking, and verify that the correct exception is thrown (3) call
   * removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify that the
   * correct exception is thrown
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    Order.resetIDGenerator();
    boolean errCond = false;
    try {
      OrderPriorityQueue test = new OrderPriorityQueue(0);
    } catch (IllegalArgumentException e) {
      errCond = true;
    } catch (Exception e) {
      return false;
    }
    if (!errCond)
      return false;
    errCond = false;// reset condition
    OrderPriorityQueue test1 = new OrderPriorityQueue(10);
    try {
      test1.peekBest();
    } catch (NoSuchElementException e) {
      errCond = true;
    } catch (Exception e) {
      return false;
    }
    if (!errCond)
      return false;
    errCond = false;// reset condition
    try {
      test1.removeBest();
    } catch (NoSuchElementException e) {
      errCond = true;
    } catch (Exception e) {
      return false;
    }
    if (!errCond)
      return false;
    return true;
  }

  /**
   * Calls the test methods individually and displays their output
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: " + testIsEmpty());
    System.out.println("insert basic: " + testInsertBasic());
    System.out.println("percolate UP: " + testPercolateUp());
    System.out.println("insert advanced: " + testInsertAdvanced());
    System.out.println("percolate DOWN: " + testPercolateDown());
    System.out.println("peek/remove valid: " + testPeekRemove());
    System.out.println("error: " + testErrors());
  }

}
