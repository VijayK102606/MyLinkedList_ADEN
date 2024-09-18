package tree;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTNode. This is a Generic Binary Search Tree, and includes the methods for operating on 
 * that tree
 *
 * @param <E> the element type
 */
public class BSTNode<E> {
	
	/** The data. */
	private E data;
	
	/** The parent. */
	private BSTNode<E> parent;
	
	/** The left. */
	private BSTNode<E> left;
	
	/** The right. */
	private BSTNode<E> right;
	

	/**
	 * Instantiates a new BST node.
	 *
	 * @param e the data element
	 * @param parent the parent
	 */
	public BSTNode(E e, BSTNode<E> parent) {
		this.parent = parent;
		this.data = e;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	E getData() {
		return this.data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	void setData(E data) {
		this.data = data;
	}
	
	/**
	 * Sets the parent to node
	 *
	 * @param node the new parent
	 */
	void setParent(BSTNode<E> node) {
		this.parent = node;
	}
	
	/**
	 * Gets the parent node
	 *
	 * @return the parent
	 */
	BSTNode<E> getParent() {
		return this.parent;
	}
	
	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	 BSTNode<E> getLeftChild() {
		return this.left;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	BSTNode<E> getRightChild() {
		return this.right;
	}
	
	/**
	 * Sets the left child to the passed in node.
	 *
	 * @param node the new left child
	 */
	void setLeftChild(BSTNode<E> node) {
		this.left = node;
	}
	
	/**
	 * Sets the right child to the passed in node.
	 *
	 * @param node the new right child
	 */
	void setRightChild(BSTNode<E> node) {
		this.right = node;
	}
	
	
	/**
	 * Creates and initializes a new left child.
	 *
	 * @param element the new left child
	 */
	void addLeftChild(E element) {
		this.left = new BSTNode<E>(element, parent);
	}

	/**
	 * Creates and initializes a new right child.
	 *
	 * @param element the new right child
	 */
	void addRightChild(E element) {
		this.right = new BSTNode<E>(element, parent);
	}
	
	/**
	 * Checks if the current node is a leaf node.
	 *
	 * @return true, if is leaf
	 */
	boolean isLeaf(BSTNode<E> node) {
		if(node.right == null && node.left == null) {
			return true;
		}
			return false;
	}
	
	/**
	 * Checks if the current node has a left child
	 *
	 * @return true, if the current node has a left child; otherwise false
	 */
	boolean hasLeft() {
		if(parent.left != null) {
			return true;
		}
			return false;
	}

	/**
	 * Checks for right.
	 *
	 * @return true, if the current node has a right child; otherwise false
	 */
	boolean hasRight() {
		if(parent.right != null) {
			return true;
		}
			return false;
	}
}
