package stack;

import list.NodeLinkedList;

public class Stack<T> extends NodeLinkedList<T> {
    
    
    private NodeLinkedList<T> lst;
    
    public Stack(NodeLinkedList<T> list) {
	
	this.lst = list;
	
    }
    
    public Stack() {
	
	
	
    }
    
    
    public void pop() {
	
	
	if (this.size() < 1) {
	    
	    System.out.println("Empty List");
		    
	}
	
	removeElem(size());
	
    }
	
	
    
    
    
    
    public void push(T data) {
	
	
    this.insert(data);
	
	
    }




   



    public Object getNext() {
	
	return this.lst;
    }
    
    
    
    




  




   

}
