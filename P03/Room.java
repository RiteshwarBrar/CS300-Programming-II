//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class contains the attributes and functions related to rooms
// Course: CS 300 Fall 2020
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources:Piazza
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * This class holds the code for methods related to Rooms
 *
 */
public class Room {
  private static ArrayList<String> names = new ArrayList<String>();
  private String name;
  private Person[] occupants;
  private int currentOccupancy;

  /**
   * This is the class constructor which is used to add a Room name and its capacity
   * 
   * @param name     a room's name
   * @param capacity a room's capacity
   */
  public Room(String name, int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException(
          "Invalid Capacity: capacity that was passed is less than equal to zero");
    }
    for (int x = 0; x < names.size(); x++) {
      if (name.equals(names.get(x)))
        throw new IllegalArgumentException("Invalid Name: Room name is already taken");
    }
    names.add(name);
    this.name = name;
    this.occupants = new Person[capacity];
    currentOccupancy = 0;
  }

  /**
   * This is a static method that returns an Arraylist for the list of clients
   * 
   * @return list of clients
   */
  public static String[] getNames() {
    String[] tempList = new String[names.size()];
    for (int x = 0; x < tempList.length; x++) {
      tempList[x] = names.get(x);
    }
    return tempList;
  }

  /**
   * An Accessor method for accessing the name of the room
   * 
   * @return a room's name
   */
  public String getName() {
    return name;
  }

  /**
   * An Accessor method for accessing the current capacity of people in a room
   * 
   * @return people in a room at the moment
   */
  public int getOccupancy() {
    return currentOccupancy;
  }

  /**
   * An Accessor method for accessing the number of people allowed in a room during COVID
   * 
   * @return number of people permitted in a room during COVID
   */
  public int getCOVIDCapacity() {
    return (int) Math.ceil(occupants.length / 2.0);
  }

  /**
   * An Accessor method for accessing the number of people allowed in a room before COVID
   * 
   * @return number of people permitted in a room normally
   */
  public int getCapacity() {
    return occupants.length;
  }

  /**
   * This method checks whether a name has already checked in or not
   * 
   * @param p An object of type Person which holds details like a person's name
   * @return true is the name has checked in else returns false
   */
  public boolean contains(Person p) {
    if(occupants[0]==null)
      return false;
    for (int x = 0; x < currentOccupancy; x+=2) {
      if (p.getName().equals(occupants[x].getName())) {
        return true;
      }
    }
    return false;
  }

  /**
   * This is a method for checking in a person
   * 
   * @param in An object of type Person which holds details like a person's name
   * @return true if person has checked in successfully
   */
  public boolean checkIn(Person in) {

    if (in == null || contains(in))
      throw new IllegalArgumentException("Invalid object:The object is null");

    if (currentOccupancy == getCOVIDCapacity()) {

      return false;
    } else {
      occupants[currentOccupancy * 2] = in;

      currentOccupancy++;
      in.toggleWaiting();
      return true;
    }

  }

  /**
   * This is a method for checking out a person
   * 
   * @param in An object of type Person which holds details like a person's name
   * @return true if person has checked out successfully
   */
  public boolean checkOut(Person out) {
    if (out == null)
      throw new IllegalArgumentException("Error: Unable to check out");
    if (!contains(out)) {

      return false;
    } else {
      out.toggleWaiting();
      currentOccupancy--;
      for (int x = 0; x < currentOccupancy; x+=2) {
        if (out.getName().equals(occupants[x].getName())) {
          occupants[x] = null;
        }

      }
      return true;
    }
  }

  /**
   * This method displays the contents of a room
   */
  public String toString() {
    String roomDescription = getName() + "\n===\n";
    for (int x = 0; x < occupants.length; x++) {
      if (occupants[x] == null)
        roomDescription = roomDescription + "-\n";
      else
        roomDescription = roomDescription + occupants[x].getName() + "\n";
    }
    return roomDescription;
  }

}
