//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: LinkedBox Class holds the attributes of a box that is to be linked in InventoryList Class
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
/**
 * 
 * @author Riteshwar Singh Brar
 *
 */
public class LinkedBox {
  private Box box;
  private LinkedBox next;

  /**
   * Creates a new LinkedBox node with given box and next fields
   * 
   * @param box  the box carried by this linked box
   * @param next reference to the next linked box in the list
   */
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }

  /**
   * Creates a new LinkedBox with a specified box and null as next field
   * 
   * @param box the box carried by this linked box
   */
  public LinkedBox(Box box) {
    this.box = box;
    this.next = null;
  }

  /**
   * Returns the next linked box node
   * 
   * @return the next field
   */
  public LinkedBox getNext() {
    return next;
  }

  /**
   * Sets the link to the next linked box node
   * 
   * @param next the next to set
   */
  public void setNext​(LinkedBox next) {
    this.next = next;
  }

  /**
   * Returns the data field box
   * 
   * @return the box
   */
  public Box getBox() {
    return box;
  }

  /**
   * Returns a String representation of this Linked box.
   * 
   * @return string representation of the linked box
   */

  public java.lang.String toString() {
    if (this.next == null) {
      return box.toString() + " -> END";
    } else
      return box.toString() + " -> ";
  }
}
