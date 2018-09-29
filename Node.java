package project3;

/**
 * The node class contains the constructors that handle the root assignments either for a Fraction or Integer data type depending on the values specified in the GUI.
 * Also included are attributes of each node that provide references to the nodes to the left and right of that node. If a Fraction type is passed to this class,
 * the currentFrac type is assigned to the node, whereas the current integer type is assigned to the node if an integer is passed to this method. 
 */
public class Node {
	
	Fraction currentFrac;
	int current;
	Node left, right = null;



public Node(int data) {
	this.current = data;
	
	}

public Node(Fraction fraction) {
	this.currentFrac = fraction;
}

}