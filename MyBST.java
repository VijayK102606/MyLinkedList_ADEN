package tree;

import java.util.LinkedList;
import java.util.Queue;

// TODO: Auto-generated Javadoc
//Note: You will need to uncomment this when we implement Level-Order traversal
//import java.util.LinkedList;
//import java.util.Queue;

// TODO: Auto-generated Javadoc
/**
 * The Class MyBST.
 *
 * @param <E> the element type
 */
public class MyBST<E extends Comparable<E>> {
	
	/** The root of the BST. */
	private BSTNode<E> root;
	
	/** The size of the BST. */
	int size;
	
	/** The str order. */
	String strOrder;

	/**
	 * Instantiates a new MyBST .
	 */
	public MyBST() {
		size = 0;
	}
	
	// Part 1 - code and validate the insert and search methods
	
	/**
	 * Gets the root.
	 *
	 * @return the root node of the Binary Search Tree
	 */
	public BSTNode<E> getRoot() {
		return root;
	}

	
	/**
	 * Gets the size of the Binary Search Tree.
	 *
	 * @return the size of the Binary Search Tree
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Insert.
	 *
	 * @param e the element to insert into the BST
	 * @return true, if successful; false if e already exists in the BST
	 */
	public boolean insert(E e) {
		if(root == null) {
			root = new BSTNode<>(e, null);
		} else {
			BSTNode<E> runner = root;
			
			while(e.compareTo(runner.getData()) < 0 && runner.getLeftChild() != null
					|| e.compareTo(runner.getData()) > 0 && runner.getRightChild() != null) {
				if(e.compareTo(runner.getData()) < 0) {
					runner = runner.getLeftChild();
				} else if(e.compareTo(runner.getData()) > 0) {
					runner = runner.getRightChild();
				} 
			}
			if(e.compareTo(runner.getData()) < 0) {
				runner.setLeftChild(new BSTNode<>(e,runner));
			} else if(e.compareTo(runner.getData()) > 0) {
				runner.setRightChild(new BSTNode<>(e,runner));
			} else {
				return false;
			}
		}
		size++;
		return true;
	}
	
	/**
	 * Search the BST.
	 *
	 * @param e the element to search for
	 * @return true, if the element was found in the list...
	 */
	public boolean search(E e) {
		if(root == null) {
			return false;
		} else {
			BSTNode<E> runner = root;
			
			while(e.compareTo(runner.getData()) < 0 && runner.getLeftChild() != null
				||e.compareTo(runner.getData()) > 0 && runner.getRightChild() != null) {
					if(e.compareTo(runner.getData()) < 0) {
						runner = runner.getLeftChild();
					} else if(e.compareTo(runner.getData()) > 0) {
						runner = runner.getRightChild();
					} 
			}
			if(e.compareTo(runner.getData()) == 0) {
				return true;
			}
		}
		
		return false; 
	}
	

	// Part 2: Pre/Post/In order traversals
	
	/**
	 * Debug method to dump the results of a traversal as a string
	 *
	 * @return the str order
	 */
	public String getStrOrder() {
		return(strOrder);
	}
	
	/**
	 * Preorder - traverse the BST using the preorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void preorder() {
		strOrder = "";
		preorder(root);
	}
	
	/**
	 * Preorder traversal - process node, then left then right.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node
	 */
	private void preorder(BSTNode<E> node) {
		if(node == null) {
			return;
		}
		strOrder = strOrder + node.getData() + ",";
		preorder(node.getLeftChild());
		preorder(node.getRightChild());
	}
	
	

	/**
	 * Inorder - traverse the BST using the inorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void inorder() {
		strOrder = "";
		inorder(root);
	}
	
	/**
	 * Inorder traversal - process left, node, then right
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void inorder(BSTNode<E> node) {
		if(node == null) {
			return;
		}
		inorder(node.getLeftChild());
		strOrder = strOrder + node.getData() + ",";
		inorder(node.getRightChild());
	}
	
	/**
	 * Postorder - traverse the BST using the postorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void postorder() {
		strOrder = "";
		postorder(root);
	}
	
	/**
	 * Postorder traversal - process left, then right then node.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void postorder(BSTNode<E> node) {
		if(node == null) {
			return;
		}
		postorder(node.getLeftChild());
		postorder(node.getRightChild());
		strOrder = strOrder + node.getData() + ",";
		
	}
	
	// Part 3: Level order Traversal and node removal 
	// DO NOT CODE UNTIL ASSIGNED

	/**
	 * Levelorder. Processes the nodes of a binary tree by level, starting at the root. 
	 * Note that this is not recursive. Update strOrder when a node is removed from the
	 * queue.
	 */
	public void levelorder() {
		if(root == null) {
			return;
		}
		
		strOrder = "";
		Queue<BSTNode<E>> tree = new LinkedList<BSTNode<E>>();
		tree.add(root);
		
		while(tree.size() > 0) {
			BSTNode<E> runner = tree.remove();
			strOrder = strOrder + runner.getData() + ",";
			
			if(runner.getLeftChild() != null) {
				tree.add(runner.getLeftChild());
			}
			if(runner.getRightChild() != null) {
				tree.add(runner.getRightChild());
			}
		}
	}
	
	/**
	 * Returns the BSTNode whose data contains the given element.
	 *
	 * @param e the element to be matched
	 * @return the matching BSTNode if element was found; null otherwise.
	 */
	private BSTNode<E> getMatchingNode(E e) {
		if(root == null) {
			return null;
		} else {
			BSTNode<E> runner = root;
			
			while(e.compareTo(runner.getData()) < 0 && runner.getLeftChild() != null
				||e.compareTo(runner.getData()) > 0 && runner.getRightChild() != null) {
					if(e.compareTo(runner.getData()) < 0) {
						runner = runner.getLeftChild();
					} else if(e.compareTo(runner.getData()) > 0) {
						runner = runner.getRightChild();
					} 
			}
			if(e.compareTo(runner.getData()) == 0) {
				return runner;
			}
		}
		return null;
	}

	/**
	 * Connect to parent node to the child node in both directions.
	 * Must handle the case where the parent is null - connect to root
	 * Must handle the case where the child is null and NOT attempt to
	 * set the parent of the child!
	 *
	 * @param left - if true, connect the child to parent->left, otherwise parent->right
	 * @param parent the parent
	 * @param child the child
	 */

	private void connectToParent(boolean left, BSTNode<E> parent, BSTNode<E> child) {
		if(parent == null) {
			root = child;
				if(child != null) {
					child.setParent(null);
				}
			return;
		}

		if (left) {
			parent.setLeftChild(child);
		} else {
			parent.setRightChild(child);
		}
		
		if (child == null) {
			return;
		}
		child.setParent(parent);
	}
	
	/**
	 * Finds left-most node in the right child of the specified node.
	 *
	 * @param node the node
	 * @return the BST node
	 */
	private BSTNode<E> findLeftMostNode(BSTNode<E> runner) {
		while(runner.getLeftChild() != null) {
			runner = runner.getLeftChild();
		}
		return runner;
	}

	/**
	 * Remove the BST node that contains the supplied element
	 *
	 * @param e the element to be searched for in the BST
	 * @return true if the element was found and deleted; false otherwise
	 */
	public boolean remove(E e) {	
		boolean hasLeft = false;
		BSTNode<E> runner = getMatchingNode(e);
		
		if (runner == null) {
			return false;
		}
		if (runner.getParent() != null) {
			hasLeft = checkLeft(runner);
		}
		
		if (runner.getLeftChild() == null && runner.getRightChild() == null) {
			connectToParent(hasLeft, runner.getParent(), null);
		} else {
			BSTNode<E> left = runner.getLeftChild();
			BSTNode<E> right = runner.getRightChild();
			
			if (left != null && right == null) {
				connectToParent(hasLeft, runner.getParent(), left);
			} else if (left == null && right != null) {
				connectToParent(hasLeft, runner.getParent(), right);
			} else if (left != null && right != null) {
				BSTNode<E> farLeft = findLeftMostNode(right);
				hasTwoChildren(runner, farLeft, hasLeft, farLeft.getParent());
			}
		}
		size--;
		return true;
	}
	
	/**
	 * Checks for two children.
	 *
	 * @param runner the runner
	 * @param left the left
	 * @param hasLeft the has left
	 * @param parent the parent
	 */
	private void hasTwoChildren(BSTNode<E> runner, BSTNode<E> left, boolean hasLeft, BSTNode<E> parent) {
		if (runner == parent) {
			connectToParent(true, left, runner.getLeftChild());
			connectToParent(hasLeft, runner.getParent(), left);
		} else {
			connectToParent(true, left, runner.getLeftChild());
			connectToParent(true, left.getParent(), left.getRightChild());
			connectToParent(false, left, runner.getRightChild());
			connectToParent(hasLeft, runner.getParent(), left);
		}
	}
	
	/**
	 * Check left.
	 *
	 * @param runner the runner
	 * @return true, if successful
	 */
	private boolean checkLeft(BSTNode<E> runner) {
		if(runner.getParent().getData().compareTo(runner.getData()) > 0) {
			return true;
		}
		return false;
	}
}
	



