
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JLabel;



/**
 * A class implementing the Leitner system for flashcard boxes.
 *
 * @invariant boxes != null
 */
public class Leitner implements StudyMethod
{
  /**
   * Constructs a new Leitner object.
   *
   * @precondition theBoxes != null
   */
  public Leitner(ArrayList<Box> theBoxes)
  {
    assert theBoxes != null;

    boxes = theBoxes;
  }

  /**
   * Internal method that computes the weight of a box.
   * <p>
   * The weight of a Leitner box depends on the box id the number of cards
   * it stores. The current implementation assigns a card in a lower box double
   * the weight as a card in the next higher box.
   *
   * @param  box      the box for which this weight is computed.
   * @param  numBoxes total number of boxes. This is needed to compute the
   *                  distance from box to the box with the highest Leitner id.
   * @return the weight of this box.
   *
   * @precondition box != null && numBoxes >= box.id()
   */
  private int weight(Box box, int numBoxes)
  {
    assert box != null && numBoxes >= box.id();

    // Each card in box number N has a weight of 2 ^ (|boxes| - N).
    //   Note: 1 << X left-shifts the number 1 by X position ( = 2^X )
    return (1 << (numBoxes - box.id())) * box.size();
  }

  /** Computes the total weight of all boxes */
  private int totalWeight()
  {
    int num = 0;

    for (Box box : boxes)
    {
      num += weight(box, boxes.size());
    }

    return num;
  }

  /**
   * Picks a random card from all boxes.
   *
   * Cards in lower boxes receive higher weight (priority).
   *
   * @precondition there must be at least one box with one card.
   */
  public void pickCard()
  {
    int           maxRand = totalWeight();
    assert maxRand > 0; // there must be at least one box with one card.

    // rndVal identifies the box where the card is located
    // | weight of box 1         | w. of box 2 | weight of Box 3 ... |
    // ^=0 [min rndVal]          ^first value for box 2             ^max(rndVal) [last value for highest box]
    //                                  ^ rndVal [falls in Box 2]
    int           rndVal  = rand.nextInt(maxRand);

    // Identify the box from where the card will be picked.
    Iterator<Box> boxIter = boxes.iterator();
    Box           currBox = boxIter.next();

    // Subtract the box's weight from rndVal until rndVal < weight(box)
    //    => we have identified the box.
    while (rndVal >= weight(currBox, boxes.size()))
    {
      rndVal -= weight(currBox, boxes.size());

      assert boxIter.hasNext();
      currBox = boxIter.next();
    }

    // Set the box from where the next card will be picked.
    box = currBox;

    // All cards in a box are equally likely to be picked,
    //   thus we generate another pseudo random number.
    card = box.get(rand.nextInt(box.size()));

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

  /**
   * Validates the response against the last picked card.
   *
   * @param s the response.
   * @return true, iff s was correct. s is assumed to be correct, if it is empty
   *         or the string returned by getAnswer equals s.
   *
   * @precondition s != null
   */
  public boolean checkAnswer(String s)
  {
    assert s != null;

    int     newBoxId = 1; // set target box id in case the response is incorrect
    boolean isCorrect = "".equals(s) || getCurrBack().getSideText().equals(s);

    if (isCorrect)
    {
      // response is correct -> update target box id
      newBoxId = Math.min(box.id() + 1, boxes.size());
    }

    box.remove(card);                  // remove card from current box
    boxes.get(newBoxId - 1).add(card); // store card in target box

    return isCorrect;
  }
  
  public boolean hasMoreCards(){
	  return true;
  }

  public Side getCurrFront() {
  
  return displayFront ? card.front : card.back;
  }


  public Side getCurrBack() {
  
  return displayFront ? card.back : card.front;
  }

  private final Random         rand = new Random(); /// random number generator.
  private Box                  box = null;          /// last picked box.
  private FlashCard            card = null;         /// last picked card.
  private boolean              displayFront = true; /// indicates side to display.
  private final ArrayList<Box> boxes;               /// the list of boxes.


}
