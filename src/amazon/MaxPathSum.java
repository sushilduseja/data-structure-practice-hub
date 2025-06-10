package amazon;

class MaxPathSum {
    int maxValue;

    public int maxPathSum(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        MaxPathSum maxPathSum = new MaxPathSum();
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
