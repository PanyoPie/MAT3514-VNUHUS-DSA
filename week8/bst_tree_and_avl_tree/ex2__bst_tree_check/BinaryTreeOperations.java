package vn.io.tunaa.dsa.week8.bst_tree_and_avl_tree.ex2__bst_tree_check;

public class BinaryTreeOperations {
    public static boolean isBST(TreeNode root) {
        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTRecursive(TreeNode node, int minimum, int maximum) {
        if (node == null) {
            return true;
        }

        if (!(minimum < node.val && node.val < maximum)) {
            return false;
        }

        return isBSTRecursive(node.left, minimum, node.val) && isBSTRecursive(node.right, node.val, maximum);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);

        tree.left = new TreeNode(10);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(15);
        tree.left.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(7);

        System.out.println(isBST(tree));
    }
}