package operations;

import treeExp.Expression;
import visitor.EvaluationVisitor;


/**
 * 
 * Concrete element Sub
 *
 */
public class Sub extends Operation {

    /**
     * Sub operation constructor
     * @param expL
     * @param expR
     */
    public Sub(Expression expL, Expression expR) {
	super(expL, expR);
	
    }

    @Override
    public float accept(EvaluationVisitor visitor) {
	
	return visitor.visit(this);
	
    }
    
    

}