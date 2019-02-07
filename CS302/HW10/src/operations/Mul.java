 
package operations;

import treeExp.Expression;
import visitor.EvaluationVisitor;

/**
 * 
 * concrete element Mul
 *
 */
public class Mul extends Operation {

    /**
     * Mul operation constructor
     * @param expL
     * @param expR
     */
    public Mul(Expression expL, Expression expR) {
	super(expL, expR);
	
    }

    @Override
    public float accept(EvaluationVisitor visitor) {
	
	return visitor.visit(this);
	
    }
    
    

}
