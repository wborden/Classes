
import java.util.Random;

import javax.swing.JLabel;


public class Drill implements StudyMethod{    
    
    /** Construct a new Drill object
     * 
     * @param box
     * @precondition box != null
     */
    public Drill(Box box)
    {
	assert box != null;
	
	drillBox = box;
    }
    
    /**
     * 
     * @param box
     * @return int value = to it's size
     * @precondition box != null
     */
    private int boxSize(Box box)
    {	
	assert box != null;	
	
	return box.size();
    }

   
    /** pick a random card
     * @precondition box size > 0
     */
    public void pickCard() {
	
	int maxRand = boxSize(this.drillBox);   //Max number of cards.
	
	assert maxRand > 0; 
	
	int rndVal = rand.nextInt(maxRand);  //Random value not to be greater than maxRand.
	
	
	card = drillBox.get(rndVal); //Pick random card.
	
	// Choose side of card.
	displayFront = (rand.nextInt(2) == 0);	
	
    }
    
    /**
     * Returns the question for the last picked card.
     *
     * @return the question
     *
     * @precondtion pickCard() has been called at least once
     */
    public JLabel getQuestion()
    {
      assert card != null;
      return displayFront ? card.getChallenge() : card.getResponse();
    }

    /**
     * Returns the answer for the last picked card.
     *
     * @return the answer
     *
     * @precondtion pickCard() has been called at least once
     */
    public JLabel getAnswer()
    {
      assert card != null;
      return displayFront ? card.getResponse() : card.getChallenge();
    }

   
    /** Returns true if the given answer is correct
     * 
    *  @param s  the string input given by user
    *  @precondition s != null
    */ 
    
    public boolean checkAnswer(String s) {
	
	assert s != null;

	 boolean isCorrect = "".equals(s) || getCurrBack().getSideText().equals(s);

	    if (isCorrect)
	    {
	      drillBox.remove(card);
	    }

	    return isCorrect;
    }
    
    
    
    public boolean hasMoreCards(){
	assert drillBox != null;
	
	if(drillBox.size() > 0) {
	    
	    return true;
	    
	}
	
	else return false;
    }

    public Side getCurrFront() {

    return displayFront ? card.front : card.back;
	}


	public Side getCurrBack() {

    return displayFront ? card.back : card.front;
	}

    /**
     * @precondition box it is called on 
     * has at least one card
     */
    public boolean hasCard() {
	
	assert drillBox != null;
	
	if(drillBox.size() > 0) {
	    
	    return true;
	    
	}
	
	else return false;
    }
    
    
    
    
    private final Random         rand = new Random(); /// random number generator.
    private FlashCard            card = null;         /// last picked card.
    private boolean              displayFront = true; /// indicates side to display.
    private Box 		 drillBox = null;     /// The currently used box.
    

}
