package operations;

import treeExp.*;
import visitor.EvaluationVisitor;


/**
 * Abstract Operation Class.
 * @author wborden
 *
 */
public abstract class Operation implements Expression{
	
	 Expression lhs;
	 Expression rhs;
	
	
	
	
	/**
	 * Super constructor used by arithmetic operations.
	 * @param expL
	 * @param expR
	 */
	 public Operation(Expression expL, Expression expR) {
	    
	    this.lhs = expL;
	    this.rhs = expR;
	    
	}
	 
	 	 
	  
	
	
	/**
	 * abstract accept method inherited by arithmetic methods.
	 * @return float 
	 */
	public abstract float accept(EvaluationVisitor visitor);
	
	/**
	 * returns the lhs of called expression
	 * @return Expression lhs
	 */
	public Expression getLHS() {
		
		
		return this.lhs;
		
	}
	
	/**
	 * returns the rhs of called expression
	 * @return Expression rhs
	 */
	public Expression getRHS() {
	
		return this.rhs;
		
	}
		
	
	
	
		
}
