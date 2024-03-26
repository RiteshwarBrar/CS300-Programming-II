//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This program contains the code for a class which has the methods related to a person's
//////////////// details
// Course: CS 300 Fall 2020
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources:none
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This is the class that holds the methods related to a Person's details
 * 
 */
public class Person {
  private String name;
  private boolean isWaiting;

  /**
   * a Constructor of this class used to initialize the name of a person
   * 
   * @param name name of a person
   */
  public Person(String name) {
    this.name = name;
    isWaiting = true;
  }

  /**
   * An accessor for the person's name
   * 
   * @return the name of the person
   */
  public String getName() {
    return name;
  }

  /**
   * The method is an accessor for the status of the person's waiting
   * 
   * @return the status whether the person is waiting or not
   */
  public boolean isWaiting() {
    return isWaiting;
  }

  /**
   * This method changes the status of a person waiting from true to false and vice versa
   */
  public void toggleWaiting() {
    if (!isWaiting) {
      isWaiting = true;
    } else
      isWaiting = false;
  }

  /**
   * Checks whether an object's name is equal to another object's name
   */
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person) o).name);
    }
    return false;
  }

}
