package vn.io.tunaa.dsa.week8.bst_tree_and_avl_tree.ex3__avl_tree_implementations;

public class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int k) {
        key = k;
        left = null;
        right = null;
        height = 1;
    }
}