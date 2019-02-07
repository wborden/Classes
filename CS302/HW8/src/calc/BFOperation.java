package calc;

import java.math.BigInteger;

import numeric.BigFraction;


/**
 * Implements Operation and defines methods for BigFraction type.
 * @author wborden
 *
 */
public class BFOperation implements Operation<BigFraction> {

    @Override
    public BigFraction compute() {

	return calc();
    }

    @Override
    public BigFraction parens() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    /**
     *     
     * Returns the sum of two BigFractions.
     * @param BigFraction lhs, BigFraction rhs
     */
    public BigFraction plus(BigFraction lhs, BigFraction rhs) {
	
	BigInteger newNumLhs = lhs.getNumerator().multiply(rhs.getDenominator());
	BigInteger newDenomLhs = lhs.getDenominator().multiply(rhs.getDenominator());
	
	BigInteger newNumRhs = rhs.getNumerator().multiply(lhs.getDenominator());
	
	
	BigFraction summed = new BigFraction(newNumLhs.add(newNumRhs), newDenomLhs);
	
	summed = summed.simplifyFrac();
	return summed;
    }

    /**
     *     
     * Returns the value of the subtraction for two BigFractions.
     * @param BigFraction lhs, BigFraction rhs
     */
    @Override
    public BigFraction minus(BigFraction lhs, BigFraction rhs) {
	
	BigInteger newNumLhs = lhs.getNumerator().multiply(rhs.getDenominator());
	BigInteger newDenomLhs = lhs.getDenominator().multiply(rhs.getDenominator());
	
	BigInteger newNumRhs = rhs.getNumerator().multiply(lhs.getDenominator());

	BigFraction subbed = new BigFraction(newNumLhs.subtract(newNumRhs), newDenomLhs);

	subbed = subbed.simplifyFrac();
	
	return subbed;
	
    }

    /**
     *     
     * Returns the product of two BigFractions.
     * @param BigFraction lhs, BigFraction rhs
     */
    @Override
    public BigFraction mul(BigFraction lhs, BigFraction rhs) {
	
	BigInteger num = lhs.getNumerator().multiply(rhs.getNumerator());
	BigInteger denom = lhs.getDenominator().multiply(rhs.getDenominator());
	
	BigFraction mult = new BigFraction(num, denom);
	
	mult = mult.simplifyFrac();
	
	return mult;
    }

    /**
     *     
     * Returns the quotient of two BigFractions.
     * @param BigFraction lhs, BigFraction rhs
     */
    @Override
    public BigFraction div(BigFraction lhs, BigFraction rhs) {
	
	BigFraction toDiv = mul(lhs, rhs.flip());
	
	return toDiv.simplifyFrac();
	
	
	
    }

    @Override
    public BigFraction calc() {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     *     
     * Returns the type value of given str.
     * @param String str
     */
    @Override
    public BigFraction getValue(String str) {
	
	BigInteger num;
	BigInteger denom;
	int plc;
	BigFraction val;
	
	String slash = "/";
	
	if(str.contains(slash)) {
	    
	   plc = str.indexOf(slash);
	    
	   num = new BigInteger(str.substring(0, plc-1));

	   denom = new BigInteger(str.substring(plc + 1));
	   
	    val = new BigFraction(num, denom); 
	   
	   return val; }
	
	
	else {
	     num = new BigInteger(str);
	    val = new BigFraction(num);
	    return val;
	}
    }

   

}
