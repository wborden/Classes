package binaryTree;


public class BinaryTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root; // the root of the tree
	private BinaryTreeNode<T> cursor; // the current node
	
	
	/**
	 * Constructor for initializing a tree with node 
	 * being set as the root of the tree.
	 * @param node
	 */
	public BinaryTree(BinaryTreeNode<T> node) {
		root = node;
	}
	/**
	 * Moves the cursor to the root.
	 */
	public void toRoot() {
		cursor = root;
	}
	/**
	 * Returns the cursor node.
	 * @return cursor
	 */
	public BinaryTreeNode<T> getCursor() {
		return cursor;
	}
	
	/**
	 * Sets the root to the provided node.
	 * ONLY USE IN THE DELETE METHOD
	 * @param node
	 */
	public void setRoot(BinaryTreeNode<T> node) {
		root = node;
	}
	
	public BinaryTreeNode<T> getRoot() {
		
		return this.root;
		
	}

	/**
	 * Checks if the tree node has a left child node
	 * @return true if left child exists else false
	 */
	public boolean hasLeftChild() {
		return cursor.getLeft() != null;
	}

	/**
	 * Checks if the tree node has a right child node
	 * @return true if right child exists else false
	 */
	public boolean hasRightChild() {
		return cursor.getRight() != null;
	}

	/**
	 * Move the cursor to the left child 
	 */
	public void toLeftChild() {
		cursor = cursor.getLeft();
	}

	/**
	 * Move the cursor to the right child
	 */
	public void toRightChild() {
		cursor = cursor.getRight();
	}

	/**
	 * @return height of the tree
	 */
	public int height() {
		if (root != null) {
			return root.height();
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}


	}

