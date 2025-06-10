class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        System.out.print(val + " ");
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

public class BstToGst {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        recBstToGst(root);
        return root;
    }


    public void recBstToGst(TreeNode root) {
        if (root == null) return;
        recBstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        System.out.print(" " + root.val + " ");
        recBstToGst(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        BstToGst b = new BstToGst();
        b.bstToGst(root);
    }
}
