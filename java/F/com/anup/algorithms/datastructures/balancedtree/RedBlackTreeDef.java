package F.com.anup.algorithms.datastructures.balancedtree;

public class RedBlackTreeDef {

	
	//
	/*
	 * 1. A node is either red or black 2.The root and leaves(NIL) are all black.
	 * 3.If a node is red, then its children are black. 
	 * 4. All paths from the node
	 * to its NIL descendents contain the same number of black nodes here the main
	 * node is not counted.
	 */

	
	/* Rotation - objective decrese the heigth of the tree
	 * Rotation does not affect the order -- left have smaller and right has bigger
	 *  */
	
	
	//Insert 
	/*
	 * 1. Insert Z and color it red 2. Recolor and rotate the nodes to fix
	 * violations
	 * 
	 * 
	 * Four cases for violations 
	 * 1. Z= root>>color black 
	 * 
	 * 2. Z.uncle = red >>>>recolor all=uncle, parent and grandparent
	 *  
	 * 3.Z.uncle = black ( triangle)>>rotateZ.parent in opposite direction to Z
	 * so parent and z swap places 
	 * 
	 * 4.Z.uncle =black(line)>> >> rotate Z.grandparent in opposite direction to z  and
	 * recoloring of parent and grandparent>>
	 */
	
	
	
}
