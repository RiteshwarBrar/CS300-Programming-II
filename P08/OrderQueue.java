//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This is the program for creating a queue and using methods related to a queue using a
//////////////// singly linked list
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is used to create a queue using a singly-linked list and contains functions related to
 * it.
 * 
 * @author Riteshwar
 *
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {

  private LinkedOrder front;
  private LinkedOrder back;
  private int size;

  /**
   * default constructor used to initialize values to instance variables
   */
  public OrderQueue() {
    front = null;
    back = null;
    size = 0;
  }

  @Override
  /**
   * Creates and returns a new OrderIterator beginning with the current value of front
   * 
   * @return a new OrderIterator with the current value of front
   */
  public Iterator<Order> iterator() {
    OrderIterator OI = new OrderIterator(front);
    return OI;
  }

  /**
   * Adds a new LinkedOrder containing newElement to the back of the queue, updating the size
   * variable and front/back references appropriately
   * 
   * @param newElement takes an element to be added as a parameter
   */
  @Override
  public void enqueue(Order newElement) {
    LinkedOrder lo = new LinkedOrder(newElement);
    if (size == 0) {
      front = lo;
      back = lo;
    } else {
      back.setNext(lo);
      back = lo;
    }
    size++;

  }

  /**
   * Removes the next LinkedOrder from the front of the queue and returns its Order,updating the
   * size variable and front/back references appropriately Throws a NoSuchElementException if the
   * queue is empty
   * 
   * @return this method returns the element removed at the front of the queue
   */
  @Override
  public Order dequeue() {
    if (front == null) {
      throw new NoSuchElementException("Error: Queue is empty");
    } else {
      Order decoy = front.getOrder();
      if (size == 1) {
        front = null;
        back = null;
      } else {
        front = front.getNext();
      }
      size--;
      return decoy;
    }
  }

  /**
   * Returns the Order from the LinkedOrder at the front of the queue without removing
   * theLinkedOrder from the queue Throws a NoSuchElementException if the queue is empty
   * 
   * @return the element at the front of the list
   */
  @Override
  public Order peek() {
    if (front == null) {
      throw new NoSuchElementException("Error: Queue is empty");
    } else {
      Order decoy = front.getOrder();
      return decoy;
    }
  }

  /**
   * Checks the queue and returns true if and only if the queue is empty
   * 
   * @return true if queue is empty else false
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /***
   * Creates and returns a String representation of this OrderQueue* using an enhanced-for loop. For
   * example, a queue with three Orders* might look like this:*1001: fries (2) -> 1002: shake (1) ->
   * 1003: burger(3) -> END**@returnA String representation of the queue
   * 
   * @return a string form of the queue
   */
  @Override
  public String toString() {
    if (this.size == 0)
      return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }

}
