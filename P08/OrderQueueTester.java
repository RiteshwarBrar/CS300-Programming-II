//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Test class for OrderIterator and OrderQueue
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
/**
 * This is a test class for OrderIterator and OrderQueue
 * 
 * @author Riteshwar
 *
 */
public class OrderQueueTester {
  /**
   * This method test the functionality of the QueueIterator methods
   * 
   * @return true if the methods work properly else returns false.
   */
  public static boolean Iteratortester() {
    Order o1 = new Order("tuna", 12);
    Order o2 = new Order("Sprouts", 2);
    Order o3 = new Order("Fried rice", 20);
    LinkedOrder node1 = new LinkedOrder(o1);
    LinkedOrder node2 = new LinkedOrder(o2);
    LinkedOrder node3 = new LinkedOrder(o3);
    node1.setNext(node2);
    node2.setNext(node3);
    OrderIterator test = new OrderIterator(node1);
    if (!test.hasNext()) {
      return false;
    }
    if (!test.next().getDishName().equals("tuna")) {
      return false;
    }
    OrderIterator test2 = new OrderIterator(node2);
    if (!test2.hasNext()) {
      return false;
    }
    if (!test2.next().getDishName().equals("Sprouts")) {
      return false;
    }
    Order.resetIDGenerator();//resets the ID of the Order
    return true;
  }

  /**
   * Tests the working of the enqueue() method of the OrderQueue class
   * 
   * @return true if the test passes else returns false.
   */
  public static boolean enqueueTester() {
    Order o1 = new Order("tuna", 12);
    Order o2 = new Order("Sprouts", 2);
    OrderQueue oQ = new OrderQueue();
    oQ.enqueue(o1);
    if (!oQ.peek().getDishName().equals("tuna") || !(oQ.peek().getPrepTime() == 12)
        || !(oQ.peek().getID() == 1001)) {
      return false;
    }
    oQ.enqueue(o2);
    if (oQ.peek().getDishName().equals("Sprouts"))
      return false;
    Order.resetIDGenerator();
    return true;
  }

  /**
   * Tests the working of the dequeue() method of the OrderQueue class
   * 
   * @return true if the test passes else returns false.
   */
  public static boolean dequeueTester() {
    Order o1 = new Order("tuna", 12);
    Order o2 = new Order("Sprouts", 2);
    Order o3 = new Order("Fried rice", 20);
    OrderQueue oQ = new OrderQueue();
    oQ.enqueue(o1);
    oQ.enqueue(o2);
    oQ.enqueue(o3);
    if (!oQ.peek().equals(oQ.dequeue())) {
      return false;
    } // each time the same if condition executes one node is removed from the queue and peek refers
      // to a new value

    if (!oQ.peek().equals(oQ.dequeue())) {
      return false;
    }
    if (!oQ.peek().equals(oQ.dequeue())) {
      return false;
    }
    Order.resetIDGenerator();
    return true;
  }

  /**
   * Tests the working of the peek() method of the OrderQueue class
   * 
   * @return true if the test passes else returns false.
   */
  public static boolean peekTester() {
    Order o1 = new Order("tuna", 12);
    Order o2 = new Order("Sprouts", 2);
    OrderQueue oQ = new OrderQueue();
    oQ.enqueue(o1);
    oQ.enqueue(o2);
    if (!oQ.peek().getDishName().equals("tuna"))
      return false;
    oQ.dequeue();
    if (!oQ.peek().getDishName().equals("Sprouts"))
      return false;
    Order.resetIDGenerator();
    return true;
  }

  /**
   * Returns true if and only if all test methods succeed;false otherwise
   * 
   * @return true if all the tests pass else false
   */
  public static boolean runAllTests() {
    if (Iteratortester() && enqueueTester() && dequeueTester() && peekTester())
      return true;
    else
      return false;

  }

  /**
   * The main method calls runAllTests() and prints appropriate message
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    if (runAllTests()) {
      System.out.println("All tests passed sucessfully");
    } else {
      System.out.println("One or more tests failed");
    }
  }
}
