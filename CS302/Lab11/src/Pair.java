import javax.print.attribute.standard.MediaSize.Other;

/**
 * Class representing paired object.
 * 
 * @author spoudel
 * 
 * @param <E>
 *            Type of object to pair.
 */
public class Pair<E> {
	/**
	 * First element of the pair
	 */
	E first;

	/**
	 * second element of the pair
	 */
	E second;

	/**
	 * Constructor for creating a pair with two elements.
	 * 
	 * @param f
	 *            the first element
	 * @param s
	 *            the second element
	 */
	public Pair(E f, E s) {
	    
	    this.first = f; this.second = s;		
	}

	/**
	 * Get the first element.
	 * 
	 * @return first element
	 */
	public E getFirst() {
	    
		return first; // null is dummy, and used to avoid compile error. Please replace false with our actual result
	}
	
	/**
	 * Set the new first element.
	 * @param newFirst
	 */
	public void setFirst(E newFirst) {
	    
	    first = newFirst;
	}

	/**
	 * Get the second element.
	 * 
	 * @return second element
	 */
	public E getSecond() {
	    
		return second; // null is dummy, and used to avoid compile error. Please replace false with our actual result
	}
	
	/**
	 * Set new second element.
	 * @param newSecond
	 */
	public void setSecond(E newSecond) {
	    
	    second = newSecond;
	}

	/**
	 * Checking if this pair equals the other pair.
	 * 
	 * @param other
	 *            the pair object to be compared with
	 * 
	 * @return true if both pair have same set of elements in same order i.e
	 *         first element of both pair are equal and the second element of
	 *         both pair are equal
	 */
	public boolean equals(Object other) {
	    
	    if(this.hashCode() == other.hashCode()) {
		
		return true; 
	    }
		
	    else return false; // false is dummy, and used to avoid compile error. Please replace false with our actual result
	}

	/**
	 * Return the hash code of the object.
	 * 
	 * @return hash code for the object
	 * @postcondition if pair1 equals pair2 hashCode(pair1) must equal
	 *                hashCode(pair2)
	 */
	public int hashCode() {
		
		/**
		 * XOR is good for combining two hashcodes because XOR has two outputs
		 * as 0 and two outputs as 1 for different combination of 0 & 1 thus
		 * making distribution uniform. 0 0 -> 0 0 1 -> 1 1 0 -> 1 1 1 -> 0
		 */
	
	    int hash1 = first.hashCode();
	    int hash2 = second.hashCode();
		// the hash value of the first and second element . XOR those value. Then return the output 
		// XOR operator: ^
	    
	    int hash = hash1^hash2;
	    
		return hash; 
	}
	
	/**
	 * Return the string as (first element, second element)
	 */
	public String toString() {
	    
		return getClass().getName() + " (" + first + ", " + second + ")"; // null is to avoid temporary. replace null with your actual value
		
	}
}
