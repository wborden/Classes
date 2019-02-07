package treeExp;

import visitor.EvaluationVisitor;


/** 
 * @author wborden
 *Expression Interface.
 *Implemented by classes requiring accept method for Visitors.
 */
public interface Expression {
    
    
    	/**
    	 * accept method to be implemented 
    	 * @param visitor
    	 * @return float
    	 */
	public float accept(EvaluationVisitor visitor);

	
	
	
	
}
