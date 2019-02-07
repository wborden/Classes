package binaryTree;

import binaryTree.BinaryTree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{
	
	
	

	public BinarySearchTree(BSTNode<T> node) {
		
		super(node);
		
	}
	
	
		

	public void insert(T data) {
		
		BSTNode<T> x = (BSTNode<T>) getRoot();
		BSTNode<T> y = null;
		BSTNode<T> z = new BSTNode<T>(data);
		
		
		while(x != null) {
			
			y = x;
			
			
			if(z.getData().compareTo(x.getData()) < 0) {
				
				x = (BSTNode<T>) x.getLeft();
				
			}
			
			
			else {
				
				x = (BSTNode<T>) x.getRight();
				
			}			
			
		}
		
		
		
		z.setParent(y);
		
		if(y == null) {
			
			this.setRoot(z);
			
		}
		
		else if(z.getData().compareTo(y.getData()) < 0) {
			
			y.setLeft(z);
			
		}
		
		else {
			y.setRight(z);
		}
		
	}

	
	
	
	public void delete(BSTNode<T> x, T data) {
		
		BSTNode<T> y = null;
		
		BSTNode<T> z = search(x, data);
		
		if(z.getLeft() == null) {
			
			;
			transplant(z,(BSTNode<T>) z.getRight());
			
		}
		
		else if(z.getRight() == null) {
			
			transplant(z, (BSTNode<T>) z.getLeft());
			
		}
		
		else {
			
			y = treeMinimum((BSTNode<T>) z.getRight());
		
			if(y.getParent().getData().compareTo(z.getData()) != 0) {
				
			
			transplant(y, (BSTNode<T>) y.getRight());
			
			y.setRight(z.getRight());
			
			
			y.getRight().setParent(y);
			
			}
			
			
		
		
		transplant(z, y);
		
		y.setLeft(z.getLeft());
		y.getLeft().setParent(y);
		}
	}	
	
	public BSTNode<T> search(BSTNode<T> x, T k) {
		
		
		if(x == null || k == x.getData()) {
			
			return x;
			
		}
		
		if(k.compareTo(x.getData()) == 0) {
			
			BSTNode<T> left = (BSTNode<T>) x.getLeft();
			
			return search(left, k);
			
		}
		
		else {
			
			BSTNode<T> right = (BSTNode<T>) x.getRight();
			return search(right, k);
			
		}		
	}
	
	
	public void traversal(BSTNode<T> x) {
		
		if(x != null) {
			
		traversal((BSTNode<T>) x.getLeft());
		
		System.out.println(x.getData());
		
		traversal((BSTNode<T>) x.getRight());
			
		}		
	}
	
	
	public void transplant(BSTNode<T> u, BSTNode<T> v){
		
		if(u.getParent() == null) {
			
			setRoot(v);
		}
		
		else if(u == u.getParent().getLeft()) {			
			
			u.getParent().setLeft(v);
			
		}
		
		else {
			
			u.getParent().setRight(v);
			
		}
		
		if(v != null) {
			
		v.setParent(u.getParent());	
					
		}
		
		
	}
	
	public BSTNode<T> treeMinimum(BSTNode<T> z) {
		
		while(z.getLeft() == null) {
			
			z = (BSTNode<T>) z.getLeft();			
		}
		
		return z;
	}
	

}
