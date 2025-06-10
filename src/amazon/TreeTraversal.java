package amazon;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    static class TraversalNode {
        int data;
        TraversalNode left, right;

        public TraversalNode(int key) {
            data = key;
            left = right = null;
        }
    }

    static void preorder(TraversalNode TraversalNode) {
        if (TraversalNode == null)
            return;

        // Traverse root
        System.out.print(TraversalNode.data + " ");
        // Traverse left
        preorder(TraversalNode.left);
        // Traverse right
        preorder(TraversalNode.right);
    }

    static void inorder(TraversalNode TraversalNode) {
        if (TraversalNode == null)
            return;

        // Traverse left
        inorder(TraversalNode.left);
        // Traverse root
        System.out.print(TraversalNode.data + " ");
        // Traverse right
        inorder(TraversalNode.right);
    }

    static void postorder(TraversalNode TraversalNode) {
        if (TraversalNode == null)
            return;

        // Traverse left
        postorder(TraversalNode.left);
        // Traverse right
        postorder(TraversalNode.right);
        // Traverse root
        System.out.print(TraversalNode.data + " ");
    }
   static void printLevelOrder(TraversalNode root) {
       Queue<TraversalNode> queue = new LinkedList<TraversalNode>();
       queue.add(root);
       while (!queue.isEmpty()) {
           TraversalNode tempNode = queue.poll();
           System.out.print(tempNode.data + " ");

           /*add left child to the queue */
           if (tempNode.left != null) {
               queue.add(tempNode.left);
           }

           /*add right right child to the queue */
           if (tempNode.right != null) {
               queue.add(tempNode.right);
           }
       }
   }

    public static void main(String args[])
            
    {
        TraversalNode root = new TraversalNode(0);
        root.left = new TraversalNode(1);
        root.right = new TraversalNode(2);
        root.left.left = new TraversalNode(3);
        root.left.right = new TraversalNode(4);
        System.out.println("Inorder traversal");
        inorder(root);

        System.out.println("\nPreorder traversal ");
        preorder(root);

        System.out.println("\nPostorder traversal");
       postorder(root);

        System.out.println("\nLevelorder traversal");
        printLevelOrder(root);

    }

}