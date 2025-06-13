/**
 * Binary Search Tree Implementation
 *
 * This is an educational implementation of a Binary Search Tree (BST) data structure
 * demonstrating the basic contains/search operation. A BST is a binary tree where
 * for each node:
 * - All nodes in the left subtree have values less than the node's value
 * - All nodes in the right subtree have values greater than the node's value
 *
 * Time Complexity:
 * - Contains/Search: O(h) where h is the height of the tree
 *   - Best case (balanced tree): O(log n)
 *   - Worst case (skewed tree): O(n)
 *
 * Space Complexity:
 * - O(h) for recursive call stack where h is the height of the tree
 */

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;
        else if (root.value > value)
            return contains(root.left, value);
        else
            return contains(root.right, value);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}