package amazon;

import java.util.Arrays;

public class BuildTree {

    // Helper function to find the index of an element in the given array
    static int findIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    // Recursive function to construct a binary tree from preorder and inorder traversal
    static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        // base case: if there are no elements in the preorder or inorder array, return null
        if (preStart > preEnd || inStart > inEnd) return null;

        // get the root node from the preorder array
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // find the index of the root node in the inorder array
        int index = findIndex(inorder, rootValue);

        // calculate the number of nodes in the left and right subtrees
        int leftSubtreeSize = index - inStart;
        int rightSubtreeSize = inEnd - index;

        // recursively construct the left and right subtrees
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, index - 1);
        root.right = buildTree(preorder, inorder, preStart + leftSubtreeSize + 1, preEnd, index + 1, inEnd);

        return root;
    }

    // Function to construct a binary tree from preorder and inorder traversal
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        // call the helper function with the appropriate parameters
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    public static void main(String[] args) {
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        //Arrays.stream(preorder).forEach(() -> System.out.print(buildTree(preorder, inorder)));
    }
}
