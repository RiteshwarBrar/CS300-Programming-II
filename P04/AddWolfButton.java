//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is program is for the class AddRabbitButton which is responsible for the Add Wolf
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
public class AddWolfButton extends Button {
  /**
   * this constructor calls the constructor of the parent class
   * @param x
   * @param y
   */
  public AddWolfButton(float x, float y) {
    // TODO Auto-generated constructor stub
    super("Add Wolf", x, y);
  }

  /**
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      Wolf wolf = new Wolf();
      Button.processing.objects.add(wolf);
    }

  }
}
