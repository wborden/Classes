package node;

public class Node<T> {

	
	
	private Node<T> next;
	T data;
	
	
	
	
	
	
	public Node(T val) {
		
		
		next = null;
		data = val;
		
	}



	public T getData() {
		
		
		return data;
		
	}
	
	public void setData(T val) {
		
		
		data = val;
		
	}
	
	
	
	public Node<T> getNext() {
		
		return next;
		
		
	}
	
	public void setNext(Node<T> nextVal) {
		
		
		next = nextVal;
		
	}
	
	
	
	
	
}
