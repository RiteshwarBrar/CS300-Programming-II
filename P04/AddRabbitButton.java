//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is program is for the class AddRabbitButton which is responsible for the Add Rabbit
//////////////// button and its use
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
/**
 * 
 * @author riteshwar
 *
 */
public class AddRabbitButton extends Button {
/**
 * this constructor calls the constructor of the parent class
 * @param x
 * @param y
 */
  public AddRabbitButton(float x, float y) {
    super("Add Rabbit", x, y);
  }

  /**
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Add Rabbit Button Pressed");
      Rabbit rabbit = new Rabbit();
      Button.processing.objects.add(rabbit);
    }

  }
}
