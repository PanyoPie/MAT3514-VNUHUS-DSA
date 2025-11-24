package vn.io.tunaa.dsa.week8.bst_tree_and_avl_tree.ex1__bst_tree_implementations;

public interface SimpleBTreeInterface<Key extends Comparable<Key>> extends Iterable<Key> {
    public void insert(Key k);
    public Key search(Key k);
    public int size();
    public boolean isEmpty();
}