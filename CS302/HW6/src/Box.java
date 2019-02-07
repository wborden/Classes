
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Implements a Leitner box holding flashcards.
 *
 * @invariant boxnum > 0 && cards != null
 */
public class Box
{
  /**
   * Constructs a new Box.
   *
   * @param num Leitner box number
   * @precondition num > 0
   */
  public Box(int num)
  {
    assert num > 0;

    boxnum = num;
    cards  = new ArrayList<FlashCard>();
  }

  /** returns current number of flashcards in the box. */
  public int size() { return cards.size(); }

  /**
   * returns specific flashcard from the box.
   *
   * @param  idx flashcard index
   * @return the queried Flashcard
   * @precondition 0 <= idx < size()
   */
  public FlashCard get(int idx) { return cards.get(idx); }

  /**
   * Adds a new flashcard to this box.
   *
   * @param card the new flashcard
   * @precondition card is not yet in the box
   */
  public void add(FlashCard card) { cards.add(card); }

  /**
   * Removes a flashcard from the box.
   *
   * @param card the card to be removed
   * @precondition card is in this box
   */
  public void remove(FlashCard card) { cards.remove(card); }

  /**
   * Removes a flashcard from the box.
   *
   * @param idx of the card to be removed
   * @precondition 0 <= idx < size()
   */
  public void remove(int idx) { cards.remove(idx); }

  /**
   * Returns an iterator to go through all flashcards in this box.
   *
   * @return an Iterator<FlashCard>
   */
  public Iterator<FlashCard> iterator() { return cards.iterator(); }

  /** Returns the Leitner-ID of this box. */
  public int id() { return boxnum; }

  /**
   * "Convenience function" that allows to add all of these cards to another box.
   * @return a reference to the internal box storage.
   * @todo This breaks encapsulation and exposes more class internals than needed.
   */
  List<FlashCard> getCards() { return cards; }

  private final int                  boxnum; /// Leitner id
  private final ArrayList<FlashCard> cards;  /// Flashcard storage
}
