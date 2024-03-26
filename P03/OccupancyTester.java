//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This is the code for testing the Classes Room and Person
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
 * 
 * This is the tester class for the program
 *
 */
public class OccupancyTester {
  /**
   * test method for the class Person
   * 
   * @return true if the class Person passes the tests
   */
  public static boolean testPerson() {
    Person p1 = new Person("Matt");
    Person p2 = new Person("Jacob");
    Person p3 = new Person("Matt");
    if (p1.getName().equals(p2.getName())) {
      System.out.println("Error: Test failed for Person.getName()");
      return false;
    } else if (!p1.getName().equals("Matt") || !p2.getName().equals("Jacob")
        || !p1.getName().equals(p3.getName())) {
      System.out.println("Error: Test failed for Person.getName()");
      return false;
    } else if (!p1.isWaiting()) {
      System.out.println("Error: Test failed for Person.isWaiting()");
      return false;
    }
    p1.toggleWaiting();
    if (p1.isWaiting()) {
      System.out.println("Error: Test failed for Person.toggleWaiting()");
      return false;
    }
    p1.toggleWaiting();
    if (!p1.isWaiting()) {
      System.out.println("Error: Test failed for Person.toggleWaiting()");
      return false;
    }
    if (!p1.equals(p3) || p1.equals(p2) || p1.equals("Matt")) {
      System.out.println("Error: Test failed for Person.equals()");
      return false;
    }
    return true;
  }

  /**
   * test method for the Room Constructor
   * 
   * @return true if the Room Constructor passes the tests
   */
  public static boolean testRoomConstructor() {
    Room r1 = new Room("CJ3", 6);
    Room r2 = new Room("CJ2", 5);
    if (!r1.getName().equals("CJ3"))
      return false;
    if (!r2.getName().equals("CJ2"))
      return false;

    try {
      Room r4 = new Room("FA23", 0);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException caught successfully");
    }
    try {
      Room r3 = new Room("CJ2", 2);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException caught successfully");
    }
    return true;
  }

  /**
   * test method for the Room Accessors
   * 
   * @return true if the Room Accessors passes the tests
   */
  public static boolean testRoomAccessors() {
    Room r1 = new Room("CJ3B", 6);
    Room r2 = new Room("CJ2A", 5);
    if (!r1.getName().equals("CJ3B") || !r2.getName().equals("CJ2A"))
      return false;
    if ((r1.getCapacity() != 6) || (r2.getCOVIDCapacity() != 3) || (r2.getOccupancy() != 0))
      return false;
    return true;
  }

  /**
   * test method for the Room Check in method
   * 
   * @return true if the Room Check in method passes the tests
   */
  public static boolean testRoomCheckIn() {
    Person p1 = new Person("Matt");
    Person p2 = new Person("Jacob");
    Room r7 = new Room("CJ3C", 6);
    int x = r7.getOccupancy();
    if (!r7.checkIn(p1)) {

      return false;
    }
    if (!r7.contains(p1) || r7.contains(p2) || x == r7.getOccupancy()) {

      return false;
    }
    try {
      r7.checkIn(null);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException caught successfully");
    }
    return true;
  }

  /**
   * test method for the Room Check out method
   * 
   * @return true if the Room Check out method passes the tests
   */
  public static boolean testRoomCheckOut() {
    Person p5 = new Person("Matt");
    Person p6 = new Person("Jacob");
    Room r5 = new Room("CJ3D", 6);
    int x = r5.getOccupancy();
    r5.checkIn(p5);
    r5.checkIn(p6);
    if (!r5.checkOut(p5)) {

      return false;
    }
    if (r5.contains(p5) || x == r5.getOccupancy()) {
      System.out.print(r5.contains(p5));
      return false;
    }
    try {
      r5.checkOut(null);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("IllegalArgumentException caught successfully");
    }
    return true;
  }

  /**
   * test method for the Room ToString method
   * 
   * @return true if the Room ToString method passes the tests
   */
  public static boolean testRoomToString() {
    Room r5 = new Room("402", 6);
    Person p0 = new Person("Monica");
    Person p2 = new Person("Chad");
    Person p4 = new Person("John");
    r5.checkIn(p0);
    r5.checkIn(p2);
    r5.checkIn(p4);
    String expected = "402\n===\nMonica\n-\nChad\n-\nJohn\n-\n";
    if (!r5.toString().equals(expected)) {
      System.out.println(expected);
      System.out.println("VS");
      System.out.println(r5.toString());
      return false;
    } else
      return true;
  }

  /**
   * The main method which is used to call all the test methods
   * 
   * @param args not utilized
   */
  public static void main(String[] args) {
    if (testPerson())
      System.out.println("All tests passed for class Person");
    if (testRoomConstructor())
      System.out.println("All tests passed for the construcor of class Room");
    if (testRoomAccessors())
      System.out.println("All tests passed for the class Room accessors");
    if (testRoomCheckIn())
      System.out.println("All tests passed for the checkIn method of class Room");
    if (testRoomCheckOut())
      System.out.println("All tests passed for the checkOut method of class Room");
    if (testRoomToString())
      System.out.println("All tests passed for the toString method of class Room");

  }
}
