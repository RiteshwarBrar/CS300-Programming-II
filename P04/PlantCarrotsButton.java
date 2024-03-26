//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is program is for the class AddRabbitButton which is responsible for the Plant
//////////////// Carrots button and its use
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
public class PlantCarrotsButton extends Button {
  /**
   * this constructor calls the constructor of the parent class
   * 
   * @param x
   * @param y
   */
  public PlantCarrotsButton(float x, float y) {
    // TODO Auto-generated constructor stub
    super("Plant Carrots", x, y);
  }

  /**
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Plant Carrots Button Pressed");
      Carrots.plant();
    }

  }
}
