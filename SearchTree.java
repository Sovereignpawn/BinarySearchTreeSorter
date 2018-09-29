package project3;

/**
 * SearchTree is the class that handles the insertion/building and traversal of the tree. Within this class are two constructors that call into Node that assign a root for either 
 * a Fraction or Integer type.  This call to the SearchTree happens in project3GUI where the loops are that populate the arrays of integers or Fractions that hold the 
 * respective objects. The core functional methods called in SearchTree are the traversal methods that exist specifically for integers or alternatively for fraction types.
 * These methods traverse a sorted tree and return the nodes from left to right if in ascending order or right to left if in descending order.
 */
public class SearchTree {

	Node root;
	 
	private String traversed = "";
	
	
	public SearchTree(int rootNode) {
		root = new Node(rootNode);
	}
	
	public SearchTree(Fraction fraction) {
		root = new Node(fraction);
	}
	
	public Node insertValue(Node value, Integer currentInteger) {
	
		if(value == null) {
			 return value = new Node(currentInteger);
			 
		}
		
		/*
		 * Recursively travels down the left side of the tree until it finds a value that is less than the current node in the tree
		 * and assigns itself as a child of the node when it completes, returns the value of the node and the next iteration
		 * begins once the assignment is complete
		 */
		
		else if(currentInteger < value.current) {
			
			value.left = insertValue(value.left, currentInteger);
		}
		
		
		 /*
		 * Recursively travels down the right side of the tree until it finds a value that is less than the current node in the tree
		 * and assigns itself as a child of the node when it completes, returns the value of the node and the next iteration
		 * begins once the assignment is complete
		 */
		
		else {
			value.right = insertValue(value.right, currentInteger);
		}
		
		return value; 
		
		
	}
	
	 Node insertValueFraction(Node value, Fraction fraction) {
	        if (value == null) {
	            return value = new Node(fraction);
	        }
	       
	        /*
			 * Recursively travels down the left side of the tree until it finds a value that is less than the current node in the tree
			 * and assigns itself as a child of the node when it completes, returns the value of the node and the next iteration
			 * begins once the assignment is complete
			 */
	        if (fraction.compareTo(value.currentFrac) < 1) {
	            value.left = insertValueFraction(value.left, fraction);
	            
	            }
	        
	        /*
			 * Recursively travels down the right side of the tree until it finds a value that is less than the current node in the tree
			 * and assigns itself as a child of the node when it completes, returns the value of the node and the next iteration
			 * begins once the assignment is complete
			 */
	        else {
	            value.right = insertValueFraction(value.right, fraction);
	        }
	        
	        return value;
	    }
	
	public String inOrderTraversal(Node value) {
		if(value != null) {
			inOrderTraversal(value.left);
			traversed = traversed + value.current + " ";
			inOrderTraversal(value.right);
		}
		
		return traversed;
	}
	
	public String inOrderTraversalFraction(Node value) {
		if(value != null) {
			inOrderTraversalFraction(value.left);
			traversed = traversed + value.currentFrac + " ";
			inOrderTraversalFraction(value.right);
		}
		
		return traversed;
	}
	
	public String inOrderTraversalDescending(Node value) {
		if(value != null) {
			inOrderTraversalDescending(value.right);
			traversed = traversed + value.current + " " ;
			inOrderTraversalDescending(value.left);
		}
		
		return traversed; 
	}
	
	public String inOrderTraversalDescendingFraction(Node value) {
		if(value != null) {
			inOrderTraversalDescendingFraction(value.right);
			traversed = traversed + value.currentFrac + " " ;
			inOrderTraversalDescendingFraction(value.left);
		}
		
		return traversed; 
	}
}
