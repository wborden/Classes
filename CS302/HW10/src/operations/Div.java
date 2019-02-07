package operations;

import treeExp.Expression;
import visitor.EvaluationVisitor;



/**
 * 
 * concrete element Div
 *
 */
public class Div extends Operation{

    /**
     * Div operation constructor
     * @param exp1
     * @param exp2
     */
	public Div(Expression exp1, Expression exp2) {
		super(exp1, exp2);
		
	}

	@Override
	public float accept(EvaluationVisitor visitor) {
	    
	    return visitor.visit(this);
	}

}
