

import javax.swing.JLabel;

/**
 * Class implementing an interface for study methods using flashcards.
 *
 */
public interface StudyMethod {
	
	/** method for responsible for picking a random flashcard to show to the user. */
	public void pickCard();
	
	/** method responsible for returning the question given to the user. */
	public JLabel getQuestion();
	
	/** method responsible for returning the answer for the given question. */
	public JLabel getAnswer();
	
	/** method responsible for checking if the answer given matches the correct answer for the given flashcard,
	 *  and handles the necessary moving of the flashcard depending on whether the user was correct or not.
	 *  
	 *  @param s = the answer the user gave.
	 */
	public boolean checkAnswer(String s);
	
	/**
	 * method that shows whether the study method object has anymore cards left.
	 * 
	 * it is meant for the drill study method, so that when all the cards have been answered correctly
	 * the study session will end.
	 * 
	 * Leitner.hasMoreCards() will always return true, since there is always at least one box with cards.
	 */
	public boolean hasMoreCards();
	
	
	
	
	//Returns the side that is currently the front.
	    public Side getCurrFront();
	    
	    //Returns the side that is currently the back.
	    public Side getCurrBack();
}
