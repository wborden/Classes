import javax.swing.JLabel;



/**
 * Represents a text based flashcard.
 *
 * This class is immutable.
 * @invariant front != null && back != null
 */
public class FlashCard
{
  /**
   * Constructor setting up a flashcard object.
   *
   * @param challenge front of the card
   * @param response back of the card
   * @precondition challenge != null && response != null
   */
  FlashCard(String challenge, String response)
  {
    assert challenge != null && response != null;

    
    if(ImageSide.imgTest(challenge)) {
	
	front =  new ImageSide(challenge);
    }
    else{
	
	front = new TextSide(challenge);
    }
    
    if(ImageSide.imgTest(response)) {
	
	back = new ImageSide(response);
    }
    else {
	
	back = new TextSide(response);
    }   
    
    
  }

  /** Returns the front side. */
  public JLabel getChallenge() { return front.getSideLabel(); }

  /** Returns the back side. */
  public JLabel getResponse() { return back.getSideLabel(); }

  /**
   * Produces a textual representation of this flashcard.
   *
   * @return a string containing two lines, one for front and one for back.
   */
  
  
  
 
  public final Side front;
  public final Side back;
}
