//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: An Iterator class of type Order
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator class of type Order
 * 
 * @author Riteshwar
 */
public class OrderIterator implements Iterator<Order> {
  private LinkedOrder current;

  /**
   * Constructor, initializes current to the provided startingLinkedOrder. Does not care whether the
   * argument value is null
   * 
   * @param start
   */
  public OrderIterator(LinkedOrder start) {
    this.current = start;
  }

  @Override
  /**
   * This method returns true if and only if the iteration has more orders
   * 
   * @return true if there are more orders
   */
  public boolean hasNext() {
    if (current != null) {
      return true;
    } else
      return false;
  }

  @Override
  /**
   * Throws a NoSuchElementException with a descriptive error message if the iteration does not have
   * more orders to return.Otherwise returns the next Order and updates the current field
   * appropriately.
   * 
   * @return the next Order
   */
  public Order next() throws NoSuchElementException {
    Order decoy;
    if (this.hasNext()) {
      decoy = current.getOrder();
      current = current.getNext();
      return decoy;
    } else {
      throw new NoSuchElementException("Error: No more orders in the Iterator");
    }

  }

}
