//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class creates and modifies the contents of a singely linked list using various
//////////////// methods
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
public class InventoryList {
  private LinkedBox head = null;
  private LinkedBox tail = null;
  private int size = 0;
  private int yellowCount = 0;
  private int blueCount = 0;
  private int brownCount = 0;

  public InventoryList() {
  }

  /**
   * Returns the size of this list
   * 
   * @return the size of this LinkedBoxList
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return true if this LinkedBoxList is empty, false otherwise
   */
  public boolean isEmpty() {
    if (head == null && size == 0 && yellowCount == 0 && blueCount == 0 && brownCount == 0) {
      return true;
    } else
      return false;
  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head.getBox().restartNextInventoryNumber();
    head = null;
    tail = null;
    size = 0;
    yellowCount = 0;
    blueCount = 0;
    brownCount = 0;
  }

  /**
   * Adds a brown box at the end of this inventory list
   * 
   * @param brownBox new brown box to be added to this list
   */
  public void addBrown​(Box brownBox) {
    if (brownBox == null || !brownBox.getColor().equals(Color.BROWN)) {
      throw new IllegalArgumentException(
          "Invalid entry: Either the box is empty or of some other color than brown");
    } else if (head == null) {
      LinkedBox node = new LinkedBox(brownBox);
      head = node;
      tail = node;
      brownCount++;
      size++;
    } else {
      LinkedBox node = new LinkedBox(brownBox);
      tail.setNext​(node);
      tail = node;
      brownCount++;
      size++;
    }

  }

  /**
   * Adds a new yellow box at the head of this list
   * 
   * @param yellowBox new box to be added to this list
   */
  public void addYellow​(Box yellowBox) {
    if (yellowBox == null || !yellowBox.getColor().equals(Color.YELLOW)) {
      throw new IllegalArgumentException(
          "Invalid entry: Either the box is empty or of some other color than Yellow");
    } else if (head == null) {
      LinkedBox node = new LinkedBox(yellowBox);
      head = node;
      tail = node;
      yellowCount++;
      size++;

    } else {
      LinkedBox node = new LinkedBox(yellowBox);
      node.setNext​(head);
      head = node;
      yellowCount++;
      size++;
    }
  }

  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box. Blue boxes must
   * be added at the buttom of yellow boxes and at the top of all the brown boxes if any. This means
   * that a new blue box must be added at index yellowCount.
   * 
   * @param blueBox
   */
  public void addBlue​(Box blueBox) {
    if (blueBox == null || !blueBox.getColor().equals(Color.BLUE)) {
      throw new IllegalArgumentException(
          "Invalid entry: Either the box is empty or of some other color than Blue");
    } else if (head == null) {
      LinkedBox node = new LinkedBox(blueBox);
      head = node;
      tail = node;
      blueCount++;
      size++;

    } else {
      LinkedBox node = new LinkedBox(blueBox);
      LinkedBox temp, currNode;
      if (yellowCount == 0) {

        node.setNext​(head);
        head = node;
        blueCount++;
        size++;
      } else {
        temp = head;
        currNode = null;
        for (int i = 0; i < yellowCount; i++) {
          currNode = temp;
          temp = temp.getNext();
        }
        currNode.setNext​(node);
        node.setNext​(temp);

        if (brownCount == 0 && blueCount == 0) {
          tail = node;
        }
        blueCount++;
        size++;

      }
    }
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index position within this list
   * @return the box stored at position index of this list
   */
  public Box get​(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Invalid Entry: index entered is out of bounds");
    } else {
      LinkedBox temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.getNext();
      }
      return temp.getBox();
    }
  }

  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * 
   * @return a reference to the removed box
   */
  public Box removeYellow() {
    if (yellowCount == 0) {
      throw new NoSuchElementException(
          "Invalid Operation: Cannot remove a yellow box as none of these exist currently");
    } else {
      LinkedBox temp = head;
      head = (head.getNext());
      size--;
      yellowCount--;
      return temp.getBox();
    }
  }

  /**
   * Removes and returns the element at the tail of this list if it has a brown color
   * 
   * @return a reference to the removed element
   */
  public Box removeBrown() {
    if (brownCount == 0) {
      throw new NoSuchElementException(
          "Invalid Operation: Cannot remove a brown box as none of these exist currently");
    } else {
      LinkedBox temp = tail;
      {
        if (size == 1) {
          temp = head;
          head = null;
          tail = null;
          size--;
          brownCount--;
          return temp.getBox();
        }
      }
      size--;
      tail = head;
      for (int i = 0; i < size - 1; i++) {
        tail = tail.getNext();
      }
      brownCount--;
      tail.setNext​(null);
      return temp.getBox();
    }
  }

  /**
   * Removes and returns a box given its inventory number from this list
   * 
   * @param inventoryNumber inventory number of the box to be removed from this list
   * @return a reference to the removed element
   */
  public Box removeBox​(int inventoryNumber) {
    LinkedBox temp = head;
    LinkedBox currNode = null;

    if (head.getBox().getInventoryNumber() == inventoryNumber) {
      if (size == 1) {
        head = null;
        tail = null;
      } else {
        head = head.getNext();
      }
      size--;
      if ((temp.getBox().getColor()).equals(Color.BLUE))
        --blueCount;

      if (temp.getBox().getColor().equals(Color.YELLOW))
        --yellowCount;

      if (temp.getBox().getColor().equals(Color.BROWN))
        --brownCount;
      return temp.getBox();
    } else {
      for (int i = 0; i < size - 1; i++) {
        currNode = temp;
        temp = temp.getNext();
        if (temp.getBox().getInventoryNumber() == inventoryNumber) {
          currNode.setNext​(temp.getNext());
          if ((temp.getBox().getColor()).equals(Color.BLUE)) {
            --blueCount;
          }
          if (temp.getBox().getColor().equals(Color.YELLOW)) {
            --yellowCount;
          }
          if (temp.getBox().getColor().equals(Color.BROWN)) {
            --brownCount;
          }
          size--;

          if (temp.getNext() == null) {
            tail = currNode;
          }

          return temp.getBox();
        }
      }
    }
    throw new NoSuchElementException("Invalid inventoryNumber: box not found");
  }

  /**
   * Returns the number of brown boxes stored in this list
   * 
   * @return the brownCount
   */
  public int getBrownCount() {
    return brownCount;
  }

  /**
   * Returns the number of yellow boxes stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns the number of blue boxes stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns a String representation of the contents of this list
   */
  public java.lang.String toString() {
    if (head == null)
      return "";
    else {
      String listRep = ""; // String representation of the list
      LinkedBox temp = head;
      listRep = listRep + temp.toString();
      for (int i = 0; i < size - 1; i++) {
        temp = temp.getNext();
        listRep = listRep + temp.toString();
      }
      return listRep;
    }
  }
}


