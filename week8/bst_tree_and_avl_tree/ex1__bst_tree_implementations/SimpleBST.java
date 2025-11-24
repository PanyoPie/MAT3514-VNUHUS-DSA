package vn.io.tunaa.dsa.week8.bst_tree_and_avl_tree.ex1__bst_tree_implementations;

import java.util.*;

@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {
    class Node {
        Key data;
        Node left, right;

        public Node(Key key) {
            this.data = key;
        }
    }

    private Node root = null;
    int n = 0;

    @Override
    public void insert(Key k) {
        root = insertRecursive(root, k);
    }

    private Node insertRecursive(Node node, Key k) {
        if (node == null) {
            n++;
            return new Node(k);
        }

        if (k.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, k);
        } else {
            node.right = insertRecursive(node.right, k);
        }

        return node;
    }

    @Override
    public Key search(Key k) {
        return searchRecursive(root, k);
    }

    private Key searchRecursive(Node node, Key k) {
        if (node == null) {
            return null;
        }

        if (node.data.equals(k)) {
            return node.data;
        }

        if (k.compareTo(node.data) < 0) {
            return searchRecursive(node.left, k);
        } else {
            return searchRecursive(node.right, k);
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return getInorder(root, new ArrayList<>()).iterator();
    }

    private ArrayList<Key> getInorder(Node node, ArrayList<Key> result) {
        if (result == null) {
            result = new ArrayList<>();
        }

        if (node == null) {
            return result;
        }

        result = getInorder(node.left, result);
        result.add(node.data);
        result = getInorder(node.right, result);

        return result;
    }

    // duyệt cây theo thứ tự trước (tiền thứ tự)
    public void preTraverse() {
        preTraverseRecursive(root);
    }

    private void preTraverseRecursive(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preTraverseRecursive(node.left);
        preTraverseRecursive(node.right);
    }

    // duyệt cây theo thứ tự sau (hậu thứ tự)
    public void postTraverse() {
        postTraverseRecursive(root);
    }

    private void postTraverseRecursive(Node node) {
        if (node == null) {
            return;
        }

        postTraverseRecursive(node.left);
        postTraverseRecursive(node.right);
        System.out.println(node.data);
    }


    // duyệt cây theo thứ tự giữa (trung thứ tự)
    public void inTraverse() {
        inTraverseRecursive(root);
    }

    private void inTraverseRecursive(Node node) {
        if (node == null) {
            return;
        }

        inTraverseRecursive(node.left);
        System.out.println(node.data);
        inTraverseRecursive(node.right);
    }

    public static void main(String[] args) {
        SimpleBST<Integer> bst = new SimpleBST<>();

        int[] data = {5, 6, 7, 1, 2, 3, 8, 6, 9, 0};
        for (int m : data) bst.insert(m);

        System.out.println("All elements in tree:");
        int[] t = new int[data.length];
        int id = 0;
        for(int d : bst) {
            t[id] = d;
            id++;
        }

        Arrays.sort(t);
        for (int d : t) {
            System.out.print(d + " ");
        }

        System.out.println();
        System.out.println("Size of tree = " + bst.size());

        System.out.println("Search key = 4> " + bst.search(4));
        System.out.println("Search key = 6> " + bst.search(6));

        System.out.println("Pre-order tree traversal");
        bst.preTraverse();
        System.out.println("Post-order tree traversal");
        bst.postTraverse();
        System.out.println("In-order tree traversal");
        bst.inTraverse();
    }
}