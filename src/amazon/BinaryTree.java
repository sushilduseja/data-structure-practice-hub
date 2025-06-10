package amazon;// A Java program to demonstrate serialization and
// deserialization of Binary Tree

import java.util.*;

class BinaryTree {
	TreeNode root;

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root)
	{
		if (root == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		List<String> l = new ArrayList<>();
		while (!s.isEmpty()) {
			TreeNode t = s.pop();

			// If current node is NULL, store marker
			if (t == null) {
				l.add("#");
			}
			else {

				// Else, store current node
				// and recur for its children
				l.add("" + t.val);
				s.push(t.right);
				s.push(t.left);
			}
		}
		return String.join(",", l);
	}

	static int t;

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data)
	{
		if (data == null)
			return null;
		t = 0;
		String[] arr = data.split(",");
		return helper(arr);
	}

	public static TreeNode helper(String[] arr)
	{
		if (arr[t].equals("#"))
			return null;

		// Create node with this item
		// and recur for children
		TreeNode root
			= new TreeNode(Integer.parseInt(arr[t]));
		t++;
		root.left = helper(arr);
		t++;
		root.right = helper(arr);
		return root;
	}

	// A simple inorder traversal used
	// for testing the constructed tree
	static void inorder(TreeNode root)
	{
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	// Driver code
	public static void main(String args[])
	{
		// Construct a tree shown in the above figure
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
//		tree.root.left.left = null;
//		tree.root.left.right = null;
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(14);

		String serialized = serialize(tree.root);
		System.out.println("Serialized view of the tree:");
		System.out.println(serialized);
		System.out.println();

		// Deserialize the stored tree into root1
		TreeNode t = deserialize(serialized);

		System.out.println(
			"Inorder Traversal of the tree constructed"
			+ " from serialized String:");
		inorder(t);
	}
}
