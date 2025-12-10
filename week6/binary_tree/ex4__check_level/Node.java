package vn.io.tunaa.dsa.week6.binary_tree.ex4__check_level;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }

    @Override
    public String toString() {
        return "vn.io.tunaa.dsa.exam_2526_1st_midterm_1.ex1__tree__min_depth_and_sum_nodes_at_level.vn.io.tunaa.dsa.exam_2526_1st_midterm_2.ex1__tree_min_leaf_value_and_count_nodes_at_level.Node{" +
                "value=" + value +
                '}';
    }
}