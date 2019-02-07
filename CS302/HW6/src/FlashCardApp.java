
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class implementing a flashcard application
 *
 * @invariant boxes != null && boxes.size() > 0
 */
public class FlashCardApp
{
  private final int MAX_BOXES = 5; /// Number of boxes

  /** Constructs a new flashcard app object and sets the number of boxes */
  public FlashCardApp()
  {
    for (int i = 1; i <= MAX_BOXES; ++i)
    {
      boxes.add(new Box(i));
    }
  }

  /** Returns an object according to the Leitner study method. */
  public Leitner leitner() { return new Leitner(boxes); }
  
  public Drill drill() 
  { 
      Box drillBox = boxes.get(0);
      
      return new Drill(drillBox);  
  }

  /** Returns an iterator that lists all flash cards in the system. */
  public Iterator<FlashCard> listAll()
  {
    ArrayList<FlashCard> allCards = new ArrayList<FlashCard>();

    for (Box box : boxes)
    {
      allCards.addAll(box.getCards());
    }

    return allCards.iterator();
  }

  /**
   * Returns an iterator that lists all flash cards containing a given pattern.
   *
   * @param pattern search pattern for texts on flashcards.
   * @return Iterator<FlashCard> where all elements contain pattern in either
   *         front or back of the card.
   *
   * @precondition pattern != null
   */
  public Iterator<FlashCard> list(String pattern)
  {
    assert pattern != null;

    ArrayList<FlashCard> foundCards = new ArrayList<FlashCard>();

    for (Box box : boxes)
    {
      Iterator<FlashCard> cardIter = box.iterator();

      while (cardIter.hasNext())
      {
        FlashCard currCard = cardIter.next();
        boolean   inclCard = (  currCard.getChallenge().getText().indexOf(pattern) >= 0
                             || currCard.getResponse().getText().indexOf(pattern) >= 0
                             );

        if (inclCard) foundCards.add(currCard);
      }
    }

    return foundCards.iterator();
  }

  /**
   * Returns an iterator that lists all flash cards in a given box.
   *
   * @param boxid Leitner box id.
   * @return Iterator<FlashCard> where all elements contain pattern in either
   *         front or back of the card.
   *
   * @precondition 0 < boxid <= number of boxes in the app
   */
  public Iterator<FlashCard> list(int boxid)
  {
    assert boxid > 0 && boxid <= boxes.size();

    return boxes.get(boxid - 1).iterator();
  }


  /**
   * Creates a new flashcard and adds it to the first box.
   *
   * @precondition challenge != null && response != null
   */
  public void create(String challenge, String response)
  {
    assert challenge != null && response != null;

    boxes.get(0).add(new FlashCard(challenge, response));
  }

  private final ArrayList<Box> boxes = new ArrayList<Box>(); /// List of boxes
}
