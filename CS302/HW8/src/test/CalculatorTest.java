package test;

import calc.*;
import numeric.BigFraction;


/**
 * Main class used for testing the Calculator.
 * @author wborden
 *
 * @param <N>
 */
public class CalculatorTest<N extends Number> {
    
    
    
    public static void main(String[] args) {
    
    Operation<BigFraction> opFrac = new BFOperation();
    Operation<Float> opFloat = new FloatOperation();
    
    
    String toTest = "3/4*5/7";
    String toTest1 = "(3.231+(4.567*12.313))/4.3321";
    
    Calculator<BigFraction> testCalcFrac = new Calculator<BigFraction>(toTest, opFrac);
    Calculator<Float> testCalcFloat = new Calculator<Float>(toTest1, opFloat);
    
    BigFraction testFrac = testCalcFrac.compute();
    Float testFloat = testCalcFloat.compute(); 
    
    System.out.println(testFrac.toString());
    System.out.println(testFloat.toString());
    
    }

}
