package list;

import node.Node;

public class NodeLinkedList<T> {
	
	
	public int cnt; 
	
	private Node<T> head;
	
	
	
	public NodeLinkedList() {
		
		
		head = new Node<T>(null);
		
		
	}
	
	
	
	public void insert(T data) {
		
		
		
	
		
		
		if(head == null) {
			
		head = new Node<>(data);	
			
		}
		
		
		Node<T> tempNode = new Node<T>(data); 
		
		
		
		Node<T> currNode = head;
		
		
		
		if(currNode != null) {
			
			
			
			while(currNode.getNext() != null) {
				
				currNode = currNode.getNext();
				
				
			}
			
			
			currNode.setNext(tempNode);
		}
		
		cnt++;
		
		
	}
	
	
	public void insert(T data, int index) {
		
		
		Node<T> tempNode = new Node<T>(data);
		
		Node<T> currNode = head;
		
		
		if(currNode != null) {
			
			
			for(int i = 1; i < index && currNode.getNext() != null; i++) {
				
				currNode = currNode.getNext();
				
			}
		}
		
		tempNode.setNext(currNode.getNext());
		
		currNode.setNext(tempNode);
		
		
		cnt++;
		
	}
	
	
	
	public Object get(int index) {
		
		
		if(index <= 0)	return null;
		
		
			Node<T> currNode = null;
		
		if(head !=null) {
			
			
			for(int i = 1; i < index; i++) {
				
				if(currNode.getNext()  == null)
				
				{
					
					return null;
					
				}
				
				currNode = currNode.getNext();
				
			}
			
			return currNode.getData();
		}
		
		return currNode;
		
	}
	
	
	public int getLastIndex() {
	    
	    Node<T> currNode = head;	    
	   int index = 0;
	    
	    while(currNode.getNext() != null) {
		
		currNode = currNode.getNext();
		
		index++;
		
	    }
	    
	    return index;
	    
	    
	}
	
	
	public void removeElem(int index) {
		
		Node<T> currNode = head;
		
		
		if(index < 1 || index > size()) {
			
			return;  }
		
		if(currNode != null) {
			
			for(int i = 0; i < index; i++) {
				
				
				if( currNode.getNext() == null){ return;}
				
				currNode = currNode.getNext();
				
			}
			
			
			currNode.setNext(currNode.getNext().getNext());
			
			
			cnt--;
			
		}
		
		
		
		
		
	}
	
	
	
	public int size(){
	    
		return this.cnt;
		
	}
	
	
	public boolean searchList(T data) {
		
		Node<T> currNode = this.head;
		
		
		for(int i = 0; i < size(); i++) {
			
			
			if(data == currNode.getData()) {
				
				  return true;
				
			} 			
			
			currNode = currNode.getNext();			
			
		}	
		 
		return false;		
		
	}
	

}
