package binaryTree;

import binaryTree.BinaryTreeNode;


public class BSTNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

	
	public BSTNode() {
		this(null, null, null, null);
	}

	public BSTNode(T theData) {
		this(theData, null, null, null);
	}

	public BSTNode(T theData, BSTNode<T> leftChild,
			BSTNode<T> rightChild, BSTNode<T> parent) {
		
		super(theData, leftChild, rightChild, parent);
		
	}
	
	public BSTNode(T theData, BSTNode<T> leftChild,
		BSTNode<T> rightChild) {
	
	super(theData, leftChild, rightChild);
	
}
	
	

	
	public String toString() {
		
		String dataStr = null;
		
		
		if (this.getData().equals(null)) {
			
			dataStr = dataStr + "Null";
			
		}
		
		else {
			
			dataStr = dataStr + this.getData();
			
		}
		
		
		return dataStr;
		
	}

	
}
	

