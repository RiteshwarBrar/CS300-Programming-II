//////////////// FILE HEADER //////////////////////////////////////////////////
//
// Title: This is program is for the class RestartButton which is responsible for the restart
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
public class RestartButton extends Button {
  /**
   * this constructor calls the constructor of the parent class
   * 
   * @param x
   * @param y
   */
  public RestartButton(float x, float y) {
    // TODO Auto-generated constructor stub
    super("Restart", x, y);
  }

  /**
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      Button.processing.removeAll();
    }

  }
}
