package operations;

import treeExp.Expression;
import visitor.EvaluationVisitor;

/**
 * concrete element Add 
 */
public class Add extends Operation {

    /**
     * Add operation constructor
     * @param exp1
     * @param exp2
     */
	public Add(Expression exp1, Expression exp2) { 
		 
	    super(exp1, exp2);
		
	}

	@Override
	public float accept(EvaluationVisitor visitor) {	   
	  
	  
	    return visitor.visit(this);
	
	   
	}

	

}
