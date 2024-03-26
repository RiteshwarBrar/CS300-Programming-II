//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class creates an object representation of an Order with attributes like name of dish,
//////////////// time of preparation and ID number. Also this class contains getters to access the
//////////////// attributes and methods to compare time of preparation and to return a string
//////////////// representaion of an order.
// Course: CS 300 Fall 2020
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
/**
 * Basic object representing a food order at this restaurant.
 * 
 * This class contains no mutator methods, only accessors.
 * 
 */
public class Order implements Comparable<Order> {

  private static int idGenerator = 1001; // generator of unique order ID numbers

  private String dishName; // name of the food associated with this Order
  private int prepTime; // approximate number of minutes to prepare this Order
  private final int ORDER_ID; // unique order ID number

  /**
   * Constructor, initializes dish name and estimated prep time. Also sets this order's unique
   * identifier.
   * 
   * @param dishName the name of the dish contained in this order
   * @param prepTime the approximate number of minutes required to prepare this dish
   */
  public Order(String dishName, int prepTime) {
    if (prepTime < 0)
      throw new IllegalArgumentException("Invalid prep time");
    this.ORDER_ID = idGenerator++;
    this.dishName = dishName;
    this.prepTime = prepTime;
  }

  /**
   * Returns the name of the food associated with this Order
   * 
   * @return the name of the food associated with this Order
   */
  public String getDishName() {
    return this.dishName;
  }

  /**
   * Returns the approximate number of minutes to prepare this Order
   * 
   * @return the approximate number of minutes to prepare this Order
   */
  public int getPrepTime() {
    return this.prepTime;
  }

  /**
   * Returns the unique ID number of this Order
   * 
   * @return the unique ID number of this Order
   */
  public int getID() {
    return this.ORDER_ID;
  }

  /**
   * Returns a String representation of this Order in the format "ID: dishname (prepTime)"
   * 
   * @return a String representation of this Order
   */
  @Override
  public String toString() {
    return this.ORDER_ID + ": " + this.dishName + " (" + this.prepTime + ")";
  }

  /**
   * This method resets the idGenerator to 1001. This method must be used in your tester methods
   * only.
   */
  public static void resetIDGenerator() {
    idGenerator = 1001;
  }

  /**
   * This method compares two orders in such manner that two Orders are equal if their prepTime
   * values are equal, and an Order is "less than" another Order if its prepTime is shorter than the
   * other Order's
   * 
   * @param o an object of class Order that is to be compared to this(current) object
   * @return returns 0 if both object have the same preparation-time, -1 if this object has lesser
   *         preparation time and 1 if vice-versa.
   */
  @Override
  public int compareTo(Order o) {
    if (this.getPrepTime() < o.getPrepTime())
      return -1;
    else if (this.getPrepTime() > o.getPrepTime())
      return 1;
    return 0;
  }

}
