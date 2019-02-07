package visitor;



import operations.*;

/**
 * 
 * @author wborden
 *implementation of Visitor interface.
 *handles all visit of expressions.
 */
public class EvaluationVisitor implements Visitor {  	

	

    	/**
    	 * Visit the Add expression
    	 * @return float result
    	 */
	public float visit(Add exp) { 
	    
	float result = (exp.getLHS().accept(this) + (exp.getRHS().accept(this)));
	
	return result;
		 
	
	}
	
	/**
	 * Visit the Sub expression
	 * @return float result
	 */
	public float visit(Sub exp) {	    
	
	float result = (exp.getLHS().accept(this) - (exp.getRHS().accept(this)));
	 
	 return result;	    
	
	
	}
	
	/**
	 * Visit the Mul expression
	 * @return float result
	 */
	public float visit(Mul exp) {   
	 
	 float result = (exp.getLHS().accept(this) * (exp.getRHS().accept(this)));
		 
	 return result;
	
	
	}

	/**
	 * Visit the Div expression
	 * @return float result
	 */
	public float visit(Div exp) {

	 float result = (exp.getLHS().accept(this) / (exp.getRHS().accept(this)));
		 
	 return result;    
	
	}

	/**
	 * Visits the Value of an expression. 
	 * @return float result
	 */
	public float visit(Value val) {
	    
	  
	return val.getVal();
	
	}
	
	
	
	

}
