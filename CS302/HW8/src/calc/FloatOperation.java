package calc;

/**
 * Implements Operation interface and defines methods for Float type
 * @author wborden
 *
 */
public class FloatOperation implements Operation<Float> {

    @Override
    public Float compute() {
	// TODO Auto-generated method stub
	return calc();
    }

    @Override
    public Float parens() {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     *     
     * Returns the sum of two Float values.
     * @param Float lhs, Float rhs
     */
    @Override
    public Float plus(Float lhs, Float rhs) {
	
	float res = lhs + rhs;
	return res;	
    }

    /**
     *     
     * Returns the subtracted value of two Float values.
     * @param Float lhs, Float rhs
     */
    @Override
    public Float minus(Float lhs, Float rhs) {
	
	float res = lhs - rhs;
	return res;
    }

    /**
     *     
     * Returns the product of two Float values.
     * @param Float lhs, Float rhs
     */
    @Override
    public Float mul(Float lhs, Float rhs) {
	
	float res = lhs*rhs;
	return res;
    }

    /**
     *     
     * Returns the quotient of two Float values.
     * @param Float lhs, Float rhs
     */
    @Override
    public Float div(Float lhs, Float rhs) {
	
	assert(rhs != 0);
	
	float res = lhs/rhs;
	return res;
    }

    @Override
    public Float calc() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Float getValue(String str) {
	
	Float val = Float.parseFloat(str);
	
	return val;
    }

    

   
    
    
   

}
