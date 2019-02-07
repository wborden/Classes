package redblack;

import redblack.RBNode;
import binaryTree.BinarySearchTree;


public class RBTree<T extends Comparable<T>, V> extends BinarySearchTree<T> {

	
	
	final static boolean BLACK = RBNode.BLACK;
	final static boolean RED = RBNode.RED;
	
	
	public RBTree(RBNode<T,V> node) {
		super(node);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public RBNode<T, V> getRoot() {
		
		return (RBNode<T, V>) super.getRoot(); 
	}
	
	public void setRoot(RBNode<T, V> node) {
		super.setRoot(node);
	}
	
	public void traversal() {
	    
	    super.traversal(this.getRoot());
	}
	
	public void keyvalPrint() {
	    
	    keyValTraversal(this.getRoot());
	    
	}
	
	public void keyValTraversal(RBNode<T, V> node) {
	    
	    if(node != null) {
		
		keyValTraversal(node.getLeft());
		System.out.println(node.getData() + " --> " + node.getValue());
		keyValTraversal( node.getRight());
		
	    }
	    
	}
	

	public void rbDataSearch(RBNode<T,V> node, T key) {
	    
	    
	    while(node != null) {
		
		if(node.getData() == key) {
		    
		    System.out.println("The value associated with this key is: " + node.getValue());
		    
		}
		
		else {
		    
		    rbDataSearch(node.getLeft(), key);
		    rbDataSearch(node.getRight(), key);
		    
		}
		
	    }
	    
	    
	    
	}
	
	public void rbInsert(T key, V value) {
		
		
		RBNode<T, V> x = this.getRoot();
		RBNode<T, V> y = null;
		RBNode<T, V> z = new RBNode<T,V>(key, value);
		
		
		while(x != null) {
		    
			y = x;		
			
			if(z.getData().compareTo(x.getData()) < 0) {
				
				x =  x.getLeft();			
				
			}			
			
			else {
				
				x = x.getRight();				
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
		
		
		z.setLeft(null);
		z.setRight(null);
		z.setColor(RED);
		
		rbInsertFixup(z);
		
	}
	
	
	
	
	public void rbInsertFixup(RBNode<T, V> z) {
		
		
		
		while(z.getParent().getColor() == RED) {
			
			if(z.getParent() == z.getParent().getParent().getLeft()) {
				
			    	RBNode<T, V> y = new RBNode<T,V>();
				y = z.getParent().getParent().getRight();
		
			if (y != null && y.getColor() == RED) {
				
				z.getParent().setColor(BLACK);
				
				y.setColor(BLACK);
				
				z.getParent().getParent().setColor(RED);
				
				z = z.getParent().getParent();
				
				if(z.getParent() == null) {
				    break;
				}
				
			}
			
			
			else{
				
				if(z == z.getParent().getRight()) {
				
				
				z = z.getParent();
				leftRotate(z);
				
				}
			
			
				
				z.getParent().setColor(BLACK);
				
				
				z.getParent().getParent().setColor(RED);
				
				rightRotate(z.getParent().getParent());
				
				}
			}
			
			
			
			
			else {
				
				
				RBNode<T,V> y = z.getParent().getParent().getLeft();
				if ( y != null && y.getColor() == RED) {
					
					z.getParent().setColor(BLACK);
					
					y.setColor(BLACK);
					
					z.getParent().getParent().setColor(RED);
					
					z = z.getParent().getParent();
					
					if(z.getParent() == null) { break;}
				}
				else{
					
					
					if (z == z.getParent().getLeft()){
				
					
					
					z = z.getParent();
					
					
					rightRotate(z);
					
					}
				
				
				
					z.getParent().setColor(BLACK);
					
					
					 z.getParent().getParent().setColor(RED);
					
					
					leftRotate(z.getParent().getParent());
				
					}
			
			}
			
		}
		
		this.getRoot().setColor(BLACK);
		
	}
	
	public void leftRotate(RBNode<T,V> x) {
		
		RBNode<T,V> y = x.getRight();
		
		x.setRight(y.getLeft());
		
		if(y.getLeft() != null) {
			
			y.getLeft().setParent(x);
			
		}
		
		
		y.setParent(x.getParent());
	
		
		if(y.getParent() == null) {
			
			this.setRoot(y);
			
		}
		
		else if(x == x.getParent().getLeft()) {
			
			x.getParent().setLeft(y);
			
		}
		
		else {
			
			x.getParent().setRight(y);
			
		}
		
		y.setLeft(x);
		
		x.setParent(y);
	}
	
	
	public void rightRotate(RBNode<T,V> x) {
		
		RBNode<T,V> y = x.getLeft();
		
		x.setLeft(y.getRight());
		
		if(y.getRight() != null) {
			
			y.getRight().setParent(x);
			
		}
		
		
		y.setParent(x.getParent());
	
		
		if(y.getParent() == null) {
			
			this.setRoot(y);
			
		}
		
		else if(x == x.getParent().getParent().getRight()) {
			
			x.getParent().setRight(y);
			
		}
		
		else {
			
			x.getParent().setLeft(y);
			
		}
		
		y.setRight(x);
		
		x.setParent(y);
	}
	

}
