package vn.io.tunaa.dsa.revision_2526_1st_midterm_1_2.ex2__queue_and_tree;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Tree<T> {
    class Node {
        T data;
        Node left;
        Node right;
    }

    void travel(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
