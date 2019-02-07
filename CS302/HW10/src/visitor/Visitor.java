package visitor;



//import org.w3c.dom.Node;
//import node.*;
import operations.*;
//import treeExp.*;


/**
 * Visitor Interface
 *
 */
public interface Visitor {
    
	
    /**
     * Visits Add expression tree
     * @param exp
     */
    float visit(Add exp);
    
    /**
     * visits Sub expression tree
     * @param exp
     */
    float visit(Sub exp);
    
    /**
     * visits Mul expression tree
     * @param exp
     */
    float visit(Mul exp);
    
    /**
     * visits Div expression tree
     * @param exp
     */
    float visit(Div exp);
    
    /**
     * visits Value at end of expression tree
     * @param exp
     */
    float visit(Value val);
	
	

}
