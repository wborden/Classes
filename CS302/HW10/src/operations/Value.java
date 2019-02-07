package operations;

import treeExp.Expression;
import visitor.EvaluationVisitor;

/**
 * Value class. 
 * Responsible for getting float of 
 *Value nodes in Expression tree.
 */
public class Value implements Expression {
	
	float val;
	
	
	/**
	 * Constructor for Value object.
	 * Stores float
	 * @param num
	 */
	public Value(float num){
		
		this.val = num;
	}
	
	/**
	 * gets float value of called Value object
	 * @return float val
	 */
	public float getVal(){
	
	return this.val;
	
    }
	
	


	@Override
	public float accept(EvaluationVisitor visitor) {

	    return visitor.visit(this);
	   
	   
	   
	}
		

	
	

}
