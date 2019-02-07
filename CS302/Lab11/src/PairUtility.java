import java.util.List;

/**
 * Utility class for deriving pairs.
 * 
 * @author spoudel
 * 
 */
public class PairUtility {
	/**
	 * Return a pair with first part as the first element in the list and the
	 * second part as the last element in the list.
	 * 
	 * @param list
	 *            non-empty list of elements
	 * @return pair with elements (first element of list,last element of list)
	 */
	public static <E> Pair<E> getPair(List<E> list) {

		// take the 1st element from list 
		// take the last element from the list
		// generate instance of Pair<E> object
		
	    E first = list.get(0);
	    
	    E last = list.get(list.size() - 1);	    
	    
	    return new Pair<E>(first, last);
	    
	}

}
