//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This program is responsible for methods and attributes related to a wolf
//
// Author: Riteshwar Singh Brar
// Email: rbrar@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources:Piazza posts
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
/**
 * 
 * @author riteshwar
 *
 */
public class Wolf extends Animal {
  private static final String WOLF = "images" + File.separator + "wolf.png";
  private static int scanRange = 120; // scanning range to look for a rabbit
  // in the neighborhood
  private static int nextID = 1; // identifier of the next Wolf to be created
  private static final String TYPE = "W"; // A String that represents the Wolf type
  private final int ID; // positive number that represents the order of this Wolf
  private int rabbitEatenCount; // Number of rabbits that the current Wolf has eaten so far

  /**
   * Creates a new Wolf object at a random position of the display window
   *
   */

  public Wolf() {
    super(WOLF);

    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current Wolf
    nextID++;
    // rabbitEatenCount=0;
  }

  public int getRabbitEatenCount() {
    return rabbitEatenCount;
  } // gets rabbitEatenCount instance field

  public static int getScanRange() {
    return scanRange;
  } // gets the scanRange of a Wolf

  /**
   * Moves to the position of the specified rabbit passed as input, and eats it. The eaten rabbit
   * will be removed from the patch and he number of eaten rabbits by this wolf is incremented by
   * one.
   * 
   * @param rabbit rabbit to eat by this wolf
   */
  public void eatRabbit(Rabbit rabbit) {
    // if the mouse is over the current Wolf, release it so the Wolf can move
    // ahead to the position of rabbit and eat it.
    if (isMouseOver())
      this.mouseReleased();
    // TODO
    this.setX(rabbit.getX());
    this.setY(rabbit.getY());
    processing.objects.remove(rabbit);
    rabbitEatenCount++;
  }

  /**
   * Defines the action of this wolf in the carrot patch. This wolf lookup for rabbits in its
   * neighborhood (Wolf.scanRange) and eats the first found rabbit only. This method also displays
   * the number of rabbit eaten by this wolf if any.
   */
  @Override
  public void action() {
    // TODO
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Rabbit) {
        if (this.isClose((Animal) processing.objects.get(i), getScanRange())) {
          this.eatRabbit((Rabbit) processing.objects.get(i));
        }
      }


    }
    if (rabbitEatenCount > 0)
      displayrabbitEatenCount(); // display rabbitEatenCount
  }

  /**
   * Displays the number of eaten rabbits if any on the top of the Wolf image
   */
  public void displayrabbitEatenCount() {
    processing.fill(0); // specify font color: black
    // display rabbitEatenCount on the top of the Wolf's image
    processing.text(rabbitEatenCount, this.getX(), this.getY() - this.image.height / 2 - 6);
  }

}
