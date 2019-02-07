package test;

import operations.*;
import treeExp.Expression;
import visitor.EvaluationVisitor;


/**
 * 
 * @author wborden
 *Main class used for testing. 
 */
public class Tester {
    
    
    public static void main(String[] args) {
	
	//Instantiates new expression trees to test.
	Expression exp = new Add(new Value(98797), new Add(new Value(131235), new Value(42341)));
	
	Expression exp2 = new Mul(new Value(3.2f), new Add(new Value(4.1f), new Value(7.1f)));
	
	Expression exp3 = new Add(new Value(3.2f), new Mul(new Value(4.1f), new Value(7.1f)));
	
	//Instantiates new EvaluationVisitor
	EvaluationVisitor ev = new EvaluationVisitor();
	
	

	//Prints result
	System.out.println("Result is: " + exp.accept(ev));
	System.out.println("Result is: " + exp2.accept(ev));
	System.out.println("Result is: " + exp3.accept(ev));
	
    }

}
