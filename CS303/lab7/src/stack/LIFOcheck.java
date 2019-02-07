package stack;


import stack.Stack;

public class LIFOcheck {
    
    
    
    public Object getOpposite(Object data) {
	
	if(data == "(") {
	    
	    return ")";
	}
	
	
	if(data == "{") {
	    
	    return "}";
	    
	}


	if(data == "[") {
    
	    return "]";
	    
	}
	
	
	else {
	    
	    return "Non-valid parens";
	    
	}
	
    }
    
    
    public <T> String getNextParens(Stack<?> stack) {
	
	
	while(stack.getNext() != null) {
	 
	    Object currNode = stack.getNext();
	    
	    
	    if(currNode == ("(")) {
		
		return "(";
		
	    }
	    
	    if(currNode == ("{")) {
		
		return "{";
		
	    }

	    if(currNode == ("[")) {
	
		return "[";
	
	    }
	    
	    
	    if(currNode == ("]")) {
		
		return "]";
		
	    }


	if(currNode == (")")) {
	
		return ")";
	
	}

	if(currNode == ("}")) {
	
	    return "}";
	
	}
	    
	    
	}
	
	
	return "No parens found";
    }
    
    public <T> boolean parensStackCheck(Stack<?> stack) {
	
	if(getNextParens(stack) != stack.get(stack.getLastIndex())) {
	    
	    return false;
	    
	}
	
	while(stack.getNext() != null) {
	    
	    
	   
	    
	    if(getNextParens(stack) == stack.get(stack.getLastIndex()) ) {
		
		for(int i = 0; i < stack.cnt; i++) {
		    
		    stack.removeElem(i);
		    stack.removeElem(stack.cnt - 1);
		   
		}
		
	    }
	}
	
	return true;
    }
    
    
    
    
    
    


    public <T> boolean LIFOvalidity(Stack<?> stack)
    {
	
	@SuppressWarnings("unused")
	Object currNode = null;
	
	
	Stack<T> parensStack = new Stack<T> ();
	
	while(stack.getNext() != null) {
	    
	    currNode = stack.getNext();
	   
	    @SuppressWarnings("unchecked")
	    T key = (T) getNextParens(stack);
	    
	    	parensStack.insert(key);       
	    
	}
	
	return parensStackCheck(parensStack);
	
	
	
	
	
    }
    
    
    
    
    

}
