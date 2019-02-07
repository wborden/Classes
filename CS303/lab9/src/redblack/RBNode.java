package redblack;

import binaryTree.BSTNode;



public class RBNode<T extends Comparable<T>, V> extends BSTNode<T> {
	
	
	
	private boolean color;
	public final static boolean BLACK = false;
	public final static boolean RED = true;
	private V value;
	
	
	public RBNode() {
		
	    super(); this.value = null; this.color = BLACK;
		
	}

	public RBNode(T theData) {
	
	    super(theData); this.value = null; this.color = BLACK;
	}

	public RBNode(T theData, RBNode<T, V> leftChild, RBNode<T, V> rightChild) {
		
		super(theData, leftChild, rightChild);
		
		this.color = BLACK; this.value = null;
		
	}

	
	
	
	public RBNode(T theData, V value) {
	  
	    super(theData); this.color = BLACK; this.value = value;
	    
	}

	@SuppressWarnings("unchecked")
	public RBNode<T, V> getLeft() {
		return (RBNode<T, V>) super.getLeft();
	}

	@SuppressWarnings("unchecked")
	public RBNode<T, V> getRight() {
		return (RBNode<T, V>) super.getRight();
	}	
	
	@SuppressWarnings("unchecked")
	public RBNode<T, V> getParent() {
		
		return (RBNode<T, V>) super.getParent();		
	}

	
	
	

	
	

	public void setColor(boolean color) {
		
		this.color = color;
		
	}
	
	public boolean getColor() {
		
		return this.color;
		
	}
	
	
	
	public V getValue() {
	    
	    return this.value;
	    
	}
	
	

}
