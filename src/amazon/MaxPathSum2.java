package amazon;

class MaxPathSum2 {
    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(Node root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }

    // Driver program to test above function
    public static void main(String args[]) {
        MaxPathSum2 maxPathSum = new MaxPathSum2();
        Tree tree = new Tree();

//        Input: root = [1,2,3]
//        Output: 6
//        Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

        int arr[] = new int[]{1, 2, 3};
        tree.root = tree.insertLevelOrder(arr, 0);
        System.out.println(maxPathSum.maxPathSum(tree.root));

//        Input: root = [-10,9,20,null,null,15,7]
//        Output: 42
//        Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

        int arr1[] = new int[]{-10,9,20,15,7};
        tree.root = tree.insertLevelOrder(arr1, 0);
        System.out.println(maxPathSum.maxPathSum(tree.root));
    }
}
