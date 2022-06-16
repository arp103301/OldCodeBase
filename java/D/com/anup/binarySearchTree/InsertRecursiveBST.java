package D.com.anup.binarySearchTree;

public class InsertRecursiveBST {
	
	private TreeNode root;
	
	private class TreeNode {
		private int data; // Generic type
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert(TreeNode root, int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		
		if(value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
 
	public static void main(String[] args) {
		InsertRecursiveBST bst = new InsertRecursiveBST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		
		bst.inOrder();
	}
}