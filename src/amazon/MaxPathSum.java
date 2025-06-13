package amazon;

/**
 * Binary Tree Maximum Path Sum Implementation
 *
 * Problem Source: LeetCode Problem #124
 * Original Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * This class provides implementations for finding the maximum path sum in a binary tree.
 * A path is defined as any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections.
 *
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
 *
 * Common Interview Question At:
 * - Amazon
 * - Google
 * - Microsoft
 */
class MaxPathSum {
    private int maxValue;

    /**
     * Main method to find maximum path sum in the tree
     * @param root Root node of the binary tree
     * @return Maximum path sum found in the tree
     */
    public int maxPathSum(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    /**
     * Recursive helper method that computes the maximum path sum
     * while updating the global maximum
     *
     * @param node Current node being processed
     * @return Maximum sum of path from current node to any leaf
     */
    private int maxPathDown(Node node) {
        if (node == null) return 0;

        // Get maximum path sum from left and right subtrees
        // Negative sums are ignored by taking max with 0
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        // Update global maximum if path through current node is larger
        maxValue = Math.max(maxValue, left + right + node.val);

        // Return maximum path sum starting from current node
        return Math.max(left, right) + node.val;
    }

    /**
     * Alternative implementation using a result wrapper class
     * This approach avoids using class member variables
     */
    public int maxPathSumAlternative(Node root) {
        return new MaxPathSumHelper().maxPathSum(root);
    }

    private static class MaxPathSumHelper {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(Node root) {
            findMaxPath(root);
            return maxSum;
        }

        private int findMaxPath(Node node) {
            if (node == null) return 0;

            // Recursively compute left and right path sums
            int leftGain = Math.max(findMaxPath(node.left), 0);
            int rightGain = Math.max(findMaxPath(node.right), 0);

            // Price of taking this path
            int priceNewPath = node.val + leftGain + rightGain;

            // Update max_sum if better path found
            maxSum = Math.max(maxSum, priceNewPath);

            // Return this node's maximum contribution to its parent
            return node.val + Math.max(leftGain, rightGain);
        }
    }

    // Test cases
    public static void main(String args[]) {
        MaxPathSum maxPathSum = new MaxPathSum();
        Tree tree = new Tree();

        // Test Case 1: Basic path
        System.out.println("Test Case 1: [1,2,3]");
        tree.root = tree.insertLevelOrder(new int[]{1, 2, 3}, 0);
        System.out.println("Expected: 6, Got: " + maxPathSum.maxPathSum(tree.root));

        // Test Case 2: Negative values
        System.out.println("\nTest Case 2: [-10,9,20,null,null,15,7]");
        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.right.left = new Node(15);
        root2.right.right = new Node(7);
        System.out.println("Expected: 42, Got: " + maxPathSum.maxPathSum(root2));

        // Test Case 3: Single node
        System.out.println("\nTest Case 3: [1]");
        System.out.println("Expected: 1, Got: " + maxPathSum.maxPathSum(new Node(1)));

        // Test Case 4: Negative values only
        System.out.println("\nTest Case 4: [-3,-2,-1]");
        tree.root = tree.insertLevelOrder(new int[]{-3, -2, -1}, 0);
        System.out.println("Expected: -1, Got: " + maxPathSum.maxPathSum(tree.root));

        // Compare both implementations
        System.out.println("\nComparing implementations:");
        System.out.println("Original: " + maxPathSum.maxPathSum(root2));
        System.out.println("Alternative: " + maxPathSum.maxPathSumAlternative(root2));
    }
}
