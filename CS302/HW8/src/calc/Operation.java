package calc;


/**
 * Operation interface parametized on a generic "N".
 * @author wborden
 *
 * @param <N>
 */
public interface Operation<N extends Number> {
    
    
    /**
     * returns call to calc();
     * @return N
     */
    public N compute();
    
    /**
     * Returns null for both implementation as it isn't needed.
     * @return null
     */
    public N parens();
    
    /**
     * Returns the sum.
     * @param lhs
     * @param rhs
     * @return
     */
    public  N plus(N lhs, N rhs);
    
    /**
     * Returns the subtraction value.
     * @param lhs
     * @param rhs
     * @return
     */
    public N minus(N lhs, N rhs);
    
    /**
     * Returns the product.
     * @param lhs
     * @param rhs
     * @return
     */
    public N mul(N lhs, N rhs);
    
    //Returns the quotient.
    public N div(N lhs, N rhs);
    
    
    public N calc();
    
    
    /**
     * Returns the value of given type.
     * @param str
     * @return N
     */
    public N getValue(String str);
    
    
    

}
